package com.mpcpsalesfsm.features.mylearning

import android.content.Context
import android.os.Bundle
import android.text.TextUtils
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.ProgressBar
import android.widget.Toast
import androidx.viewpager2.widget.ViewPager2
import com.mpcpsalesfsm.R
import com.mpcpsalesfsm.app.NetworkConstant
import com.mpcpsalesfsm.app.utils.AppUtils
import com.mpcpsalesfsm.base.presentation.BaseActivity
import com.mpcpsalesfsm.base.presentation.BaseFragment
import com.mpcpsalesfsm.features.dashboard.presentation.DashboardActivity
import com.mpcpsalesfsm.features.mylearning.apiCall.LMSRepoProvider
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import timber.log.Timber

class VideoPlayLMS : BaseFragment() {
    private lateinit var mContext:Context
    private lateinit var adapter: VideoAdapter
    private lateinit var adapter1: VideoAdapter1
    //private val videos = ArrayList<VideoLMS>()
    private val videos = ArrayList<VideoLMS>()
    private val exoPlayerItems = ArrayList<ExoPlayerItem>()
    lateinit var viewPager2: ViewPager2

    private lateinit var progressWheel: ProgressBar
    private lateinit var ll_vdo_ply_like: LinearLayout
    private lateinit var ll_vdo_ply_cmmnt: LinearLayout
    private lateinit var ll_vdo_ply_share: LinearLayout
    private lateinit var ll_video_not_found: LinearLayout

    var contentL : ArrayList<ContentL> = ArrayList()

    companion object{
        var topic_id: String = ""
        var previousFrag: String = ""
        fun getInstance(objects: Any): VideoPlayLMS {
            val videoPlayLMS = VideoPlayLMS()
            if (!TextUtils.isEmpty(objects.toString())) {
                topic_id=objects.toString()
            }else{
                topic_id = ""
            }
            println("tag_topic_id"+ topic_id)
            return videoPlayLMS
        }
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        mContext=context
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater!!.inflate(R.layout.fragment_video_play_l_m_s, container, false)
        initView(view)
        return view
    }

    private fun initView(view: View) {
        progressWheel = view.findViewById(R.id.pb_frag_video_player)
        ll_vdo_ply_like = view.findViewById(R.id.ll_vdo_ply_like)
        ll_vdo_ply_cmmnt = view.findViewById(R.id.ll_vdo_ply_cmmnt)
        ll_vdo_ply_share = view.findViewById(R.id.ll_vdo_ply_share)
        ll_video_not_found = view.findViewById(R.id.ll_video_not_found)
        progressWheel.visibility = View.GONE
        ll_video_not_found.visibility = View.GONE

        viewPager2 = view.findViewById(R.id.viewPager2)

        contentL = ArrayList()

        if (topic_id!="") {
            getVideoTopicWise()
            return
        }else {

            videos.add(
                VideoLMS(
                    "Sales","Sales description content",
                    "http://3.7.30.86:8073/Commonfolder/LMS/ContentUpload/Sell Me This Pen.mp4"
                )
            )
            videos.add(
                VideoLMS(
                    "Reimbursement","Reimbursement description content",
                    "http://3.7.30.86:8073/Commonfolder/DocumentSharing/d9533eaf-9cd7-4b4f-b24d-c54b32d413ce.mp4"
                )
            )
            videos.add(
                VideoLMS(
                    "jif","Description content", "gif"
                )
            )
            videos.add(
                VideoLMS(
                    "Marketing","Marketing description content",
                    "http://3.7.30.86:8073/Commonfolder/DocumentSharing/EXTREME PARKOUR JUMP over death gap.mp4"
                )
            )

        }

        adapter1 = VideoAdapter1(mContext, videos, ll_vdo_ply_like , ll_vdo_ply_cmmnt , ll_vdo_ply_share ,object : VideoAdapter1.OnVideoPreparedListener {
            override fun onVideoPrepared(exoPlayerItem: ExoPlayerItem) {
                exoPlayerItems.add(exoPlayerItem)
            }

            override fun onNonVideo() {
                //Toaster.msgShort(mContext,"Not video")
            }
        })

        viewPager2.adapter = adapter1

        viewPager2.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
            override fun onPageSelected(position: Int) {
                //progressWheel.visibility = View.VISIBLE
                val previousIndex = exoPlayerItems.indexOfFirst { it.exoPlayer.isPlaying }
                if (previousIndex != -1) {
                    val player = exoPlayerItems[previousIndex].exoPlayer
                    player.pause()
                    player.playWhenReady = false
                }
                val newIndex = exoPlayerItems.indexOfFirst { it.position == position }
                if (newIndex != -1) {
                    val player = exoPlayerItems[newIndex].exoPlayer
                    player.playWhenReady = true
                    player.play()
                    //progressWheel.visibility = View.GONE
                }
            }
        })

      /*  adapter = VideoAdapter(mContext, videos, object : VideoAdapter.OnVideoPreparedListener {
            override fun onVideoPrepared(exoPlayerItem: ExoPlayerItem) {
                exoPlayerItems.add(exoPlayerItem)
            }

            override fun onNonVideo() {
                //Toaster.msgShort(mContext,"Not video")
            }
        })

        viewPager2.adapter = adapter */



    }

    fun getVideoTopicWise(){
        try {
            progressWheel.visibility = View.VISIBLE
            Timber.d("deleteImei call" + AppUtils.getCurrentDateTime())
            val repository = LMSRepoProvider.getTopicList()
            BaseActivity.compositeDisposable.add(
                repository.getTopicsWiseVideo(topic_id)
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribeOn(Schedulers.io())
                    .subscribe({ result ->
                        val response = result as VideoTopicWiseResponse
                        if (response.status == NetworkConstant.SUCCESS) {
                            progressWheel.visibility = View.GONE
                            try {
                                if (response.content_list!=null && response.content_list.size>0) {
                                    ll_video_not_found.visibility =View.GONE
                                    contentL = response.content_list
                                    // Sort the content list by content_play_sequence
                                    val sortedList = contentL.sortedBy { it.content_play_sequence }
                                        .toCollection(ArrayList())
                                    Log.d("sortedList", "" + sortedList)
                                    setVideoAdapter(
                                        sortedList,
                                        ll_vdo_ply_like,
                                        ll_vdo_ply_cmmnt,
                                        ll_vdo_ply_share
                                    )
                                }else{
                                    Toast.makeText(mContext, "No video found", Toast.LENGTH_SHORT).show()
                                    ll_video_not_found.visibility =View.VISIBLE
                                }
                            }catch (ex:Exception){
                                ex.printStackTrace()
                            }
                        }else{
                            progressWheel.visibility = View.GONE
                            ll_video_not_found.visibility =View.VISIBLE
                            (mContext as DashboardActivity).showSnackMessage(getString(R.string.no_data_found))

                        }
                    }, { error ->
                        progressWheel.visibility = View.GONE
                        ll_video_not_found.visibility =View.GONE
                        (mContext as DashboardActivity).showSnackMessage(getString(R.string.something_went_wrong))
                    })
            )
        } catch (ex: Exception) {
            ex.printStackTrace()
            progressWheel.visibility = View.GONE
            ll_video_not_found.visibility =View.GONE
            (mContext as DashboardActivity).showSnackMessage(getString(R.string.something_went_wrong))
        }
    }

    fun setVideoAdapter(
        contentL: ArrayList<ContentL>,
        ll_vdo_ply_like: LinearLayout,
        ll_vdo_ply_cmmnt: LinearLayout,
        ll_vdo_ply_share: LinearLayout
    ) {
        adapter = VideoAdapter(mContext, contentL, ll_vdo_ply_like , ll_vdo_ply_cmmnt , ll_vdo_ply_share ,object : VideoAdapter.OnVideoPreparedListener {
            override fun onVideoPrepared(exoPlayerItem: ExoPlayerItem) {
                exoPlayerItems.add(exoPlayerItem)
            }

            override fun onNonVideo() {
                //Toaster.msgShort(mContext,"Not video")
            }
        })

        viewPager2.adapter = adapter

        viewPager2.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
            override fun onPageSelected(position: Int) {
                //progressWheel.visibility = View.VISIBLE
                val previousIndex = exoPlayerItems.indexOfFirst { it.exoPlayer.isPlaying }
                if (previousIndex != -1) {
                    val player = exoPlayerItems[previousIndex].exoPlayer
                    player.pause()
                    player.playWhenReady = false
                }
                val newIndex = exoPlayerItems.indexOfFirst { it.position == position }
                if (newIndex != -1) {
                    val player = exoPlayerItems[newIndex].exoPlayer
                    player.playWhenReady = true
                    player.play()
                    //progressWheel.visibility = View.GONE
                }
            }
        })
    }

    override fun onPause() {
        super.onPause()

        val index = exoPlayerItems.indexOfFirst { it.position == viewPager2.currentItem }
        if (index != -1) {
            val player = exoPlayerItems[index].exoPlayer
            player.pause()
            player.playWhenReady = false
        }
    }

    override fun onResume() {
        super.onResume()

        val index = exoPlayerItems.indexOfFirst { it.position == viewPager2.currentItem }
        if (index != -1) {
            val player = exoPlayerItems[index].exoPlayer
            player.playWhenReady = true
            player.play()
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        if (exoPlayerItems.isNotEmpty()) {
            for (item in exoPlayerItems) {
                val player = item.exoPlayer
                player.stop()
                player.clearMediaItems()
            }
        }
    }


}