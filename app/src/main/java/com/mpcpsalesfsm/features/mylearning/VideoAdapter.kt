package com.mpcpsalesfsm.features.mylearning
import android.content.Context
import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.mpcpsalesfsm.R
import com.mpcpsalesfsm.app.types.FragType
import com.mpcpsalesfsm.features.dashboard.presentation.DashboardActivity
import com.google.android.exoplayer2.DefaultRenderersFactory
import com.google.android.exoplayer2.ExoPlayer
import com.google.android.exoplayer2.MediaItem
import com.google.android.exoplayer2.PlaybackException
import com.google.android.exoplayer2.Player
import com.google.android.exoplayer2.source.MediaSource
import com.google.android.exoplayer2.source.ProgressiveMediaSource
import com.google.android.exoplayer2.ui.StyledPlayerView
import com.google.android.exoplayer2.upstream.DefaultDataSource
import com.pnikosis.materialishprogress.ProgressWheel
import kotlinx.android.synthetic.main.list_video.view.iv_list_video
import kotlinx.android.synthetic.main.list_video.view.stylplayerView


class VideoAdapter(
    var context: Context,
    var videos: ArrayList<ContentL>,
    var ll_vdo_ply_like: LinearLayout,
    var ll_vdo_ply_cmmnt: LinearLayout,
    var ll_vdo_ply_share: LinearLayout,
    var videoPreparedListener: OnVideoPreparedListener
) : RecyclerView.Adapter<VideoAdapter.VideoViewHolder>() {


    inner class VideoViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        val playerView: StyledPlayerView = itemView.findViewById(R.id.stylplayerView)
        val tvTitle: TextView = itemView.findViewById(R.id.tvTitle)
        val tvDescrip: TextView = itemView.findViewById(R.id.tvDescrip)
        val pbLoading: ProgressWheel = itemView.findViewById(R.id.progress_wheel)

        lateinit var exoPlayer: ExoPlayer
        lateinit var mediaSource: MediaSource

        fun bind(position: Int) {

            val model = videos[position]
            tvTitle.text = model.content_title
            tvDescrip.text = model.content_description

            if (model.isAllowLike){
                ll_vdo_ply_like.visibility = View.VISIBLE
            }else{
                ll_vdo_ply_like.visibility = View.GONE
            }
            if (model.isAllowComment){
                ll_vdo_ply_cmmnt.visibility = View.VISIBLE
            }else{
                ll_vdo_ply_cmmnt.visibility = View.GONE
            }
            if (model.isAllowShare){
                ll_vdo_ply_share.visibility = View.VISIBLE
            }else{
                ll_vdo_ply_share.visibility = View.GONE
            }
        }

        fun setVideoPath(url: String,position: Int) {
            pbLoading.stopSpinning()
            println("tag_vodeo_position_state pos : $adapterPosition")
            exoPlayer = ExoPlayer.Builder(context)
                .setRenderersFactory(DefaultRenderersFactory(context).setEnableDecoderFallback(true)).build()
            exoPlayer.addListener(object : Player.Listener {
                override fun onPlayerError(error: PlaybackException) {
                    super.onPlayerError(error)
                    Toast.makeText(context, "Can't play this video", Toast.LENGTH_SHORT).show()
                }

                override fun onPlayerStateChanged(playWhenReady: Boolean, playbackState: Int) {

                    var b = exoPlayer.currentPosition //Returns the playback position in the current content
                    var d = exoPlayer.duration //Returns the duration of the current content
                    if(b>0){
                        println("tag_vodeo_position  $b $d")
                    }
                    when (playbackState) {
                        Player.STATE_ENDED -> {
                            println("tag_vodeo_position_state  state ended ")
                        }
                        Player.STATE_READY -> {
                            println("tag_vodeo_position_state  state ready ")
                        }//hideProgressBar() //*Hide progressbar!
                        Player.STATE_BUFFERING ->{
                            println("tag_vodeo_position_state  state buffering ")
                        } //showProgressBar() //*Show progressbar!
                        Player.STATE_IDLE -> {
                            println("tag_vodeo_position_state  state idle ")
                        }
                    }


                    if (playbackState == Player.STATE_BUFFERING) {
                        pbLoading.spin()
                    } else if (playbackState == Player.STATE_READY) {
                        pbLoading.stopSpinning()
                    }
                    else if (playbackState == Player.STATE_ENDED) {
                        (context as DashboardActivity).loadFragment(FragType.LmsQuestionAnswerSet, true, videos.get(position).question_list)
                    }
                }
            })

            itemView.iv_list_video.visibility = View.GONE
            itemView.stylplayerView.visibility = View.VISIBLE

            //playerView.player = exoPlayer

            exoPlayer.seekTo(0)
            exoPlayer.repeatMode = Player.REPEAT_MODE_OFF

            val dataSourceFactory = DefaultDataSource.Factory(context)

            mediaSource = ProgressiveMediaSource.Factory(dataSourceFactory).createMediaSource(MediaItem.fromUri(Uri.parse(url)))

            exoPlayer.setMediaSource(mediaSource)
            exoPlayer.prepare()
            pbLoading.visibility = View.GONE
            if (absoluteAdapterPosition == 0) {
                exoPlayer.playWhenReady = true
                exoPlayer.play()
                pbLoading.stopSpinning()
            }

            videoPreparedListener.onVideoPrepared(ExoPlayerItem(exoPlayer, absoluteAdapterPosition))
            playerView.player = exoPlayer


        }

        fun setGIF(){
            pbLoading.stopSpinning()
            itemView.iv_list_video.visibility = View.GONE
            itemView.stylplayerView.visibility = View.GONE

            videoPreparedListener.onNonVideo()
            itemView.iv_list_video.visibility = View.VISIBLE
            itemView.stylplayerView.visibility = View.GONE

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VideoViewHolder {

        val view = LayoutInflater.from(parent.context).inflate(R.layout.list_video, parent, false)
        return VideoViewHolder(view)
    }

    override fun onBindViewHolder(holder: VideoViewHolder, position: Int) {
        val model = videos[position]
        holder.bind(position)
        if(model.content_url.contains(".mp4",ignoreCase = true)){
            holder.setVideoPath(/*"http://3.7.30.86:8073"+*/model.content_url,position)
        }else{
            holder.setGIF()
        }


    }

    override fun getItemCount(): Int {
        return videos.size
    }

    interface OnVideoPreparedListener {
        fun onVideoPrepared(exoPlayerItem: ExoPlayerItem)
        fun onNonVideo()
    }
}