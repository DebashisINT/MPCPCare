package com.mpcpsalesfsm.features.mylearning

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.mpcpsalesfsm.DialogLoading.getResources
import com.mpcpsalesfsm.R
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import kotlinx.android.synthetic.main.performance_item.view.learning_progress_status
import kotlinx.android.synthetic.main.performance_item.view.perform_thumbnail
import kotlinx.android.synthetic.main.performance_item.view.tv_perform_subtitle
import kotlinx.android.synthetic.main.performance_item.view.tv_perform_title
import kotlinx.android.synthetic.main.performance_item.view.tv_progressStatus
import kotlinx.android.synthetic.main.performance_item.view.tv_progressText


class MyLearningProgressAdapter(
    private val mContext: Context,
    private val mList: List<SearchLmsLearningFrag.MyLearningData>,
    /*private val listener: OnItemClickListener*/
) : RecyclerView.Adapter<MyLearningProgressAdapter.MyLearningProgressViewHolder>() {


    inner class MyLearningProgressViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)/*, View.OnClickListener*/ {

        fun bindItem(){
            //itemView.idIVCourse.setImageBitmap(retriveVideoFrameFromVideo(mList.get(adapterPosition).videoImg))
            itemView.tv_perform_title.text = mList.get(adapterPosition).title
            itemView.tv_perform_subtitle.text = mList.get(adapterPosition).subtitle
            itemView.learning_progress_status.progress = mList.get(absoluteAdapterPosition).progress
            itemView.tv_progressText.text = mList.get(absoluteAdapterPosition).progress.toString()+"% complete"
            if (mList.get(absoluteAdapterPosition).progress.toString().equals("100")){
                itemView.tv_progressStatus.text = "Completed"
                itemView.tv_progressStatus.setTextColor(mContext.getResources().getColor(R.color.approved_green));

            }else{
                itemView.tv_progressStatus.text = "Continue"
                itemView.tv_progressStatus.setTextColor(mContext.getResources().getColor(R.color.toolbar_lms));

            }
            itemView.tv_progressText.text = mList.get(absoluteAdapterPosition).progress.toString()+"% complete"
            val thumb: Long = (getLayoutPosition() * 1000).toLong()
            val options = RequestOptions().frame(thumb)
            Glide.with(mContext).load(mList.get(adapterPosition).thumbnail).apply(options).into(itemView.perform_thumbnail)
        }

       /* override fun onClick(v: View?) {
            val position = adapterPosition
            if (position != RecyclerView.NO_POSITION) {
                listener.onItemClick(mList[position])
            }
        }*/
    }
   /* interface OnItemClickListener {
        fun onItemClick(item: SearchLmsLearningFrag.MyLearningData)
    }*/

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyLearningProgressViewHolder {
        val v = LayoutInflater.from(mContext).inflate(R.layout.performance_item, parent, false)
        return MyLearningProgressViewHolder(v)
    }

    override fun getItemCount(): Int {
        return mList.size
    }

    override fun onBindViewHolder(holder: MyLearningProgressViewHolder, position: Int) {
        holder.bindItem()
    }

}
