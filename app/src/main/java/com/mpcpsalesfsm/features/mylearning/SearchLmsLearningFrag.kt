package com.mpcpsalesfsm.features.mylearning
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.speech.RecognizerIntent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.WindowManager
import android.widget.EditText
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.mpcpsalesfsm.R
import com.mpcpsalesfsm.app.types.FragType
import com.mpcpsalesfsm.base.presentation.BaseFragment
import com.mpcpsalesfsm.features.dashboard.presentation.DashboardActivity
import com.mpcpsalesfsm.widgets.AppCustomEditText
import com.pnikosis.materialishprogress.ProgressWheel


class SearchLmsLearningFrag : BaseFragment() , View.OnClickListener/*, LmsSearchAdapter.OnItemClickListener*/ {
    private lateinit var mContext: Context
    lateinit var gv_search: RecyclerView
    lateinit var tv_next_afterSearch_lms: LinearLayout
    lateinit var courseList: List<LmsSearchData>
    lateinit var lmsSearchAdapter: LmsSearchAdapter
    lateinit var progress_wheel: ProgressWheel
    private lateinit var ll_lms_performance: LinearLayout
    private lateinit var iv_lms_performance: ImageView
    private lateinit var tv_lms_performance: TextView

    private lateinit var ll_lms_mylearning: LinearLayout
    private lateinit var iv_lms_mylearning: ImageView
    private lateinit var tv_lms_mylearning: TextView

    private lateinit var ll_lms_leaderboard: LinearLayout
    private lateinit var iv_lms_leaderboard: ImageView
    private lateinit var tv_lms_leaderboard: TextView

    private lateinit var ll_lms_knowledgehub: LinearLayout
    private lateinit var iv_lms_knowledgehub: ImageView
    private lateinit var tv_lms_knowledgehub: TextView
    lateinit var ll_search: LinearLayout
    lateinit var ll_voice: LinearLayout
    lateinit var et_search: AppCustomEditText
    private var  suffixText:String = ""


    companion object {
        fun getInstance(objects: Any): SearchLmsLearningFrag {
            val fragment = SearchLmsLearningFrag()
            return fragment
        }
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        mContext = context
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater!!.inflate(R.layout.fragment_search_lms_learning, container, false)
        initView(view)
        return view
    }

    private fun initView(view: View) {
        requireActivity().getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_NOTHING);


        //performance
        ll_lms_performance = view.findViewById(R.id.ll_lms_performance)
        iv_lms_performance = view.findViewById(R.id.iv_lms_performance)
        tv_lms_performance = view.findViewById(R.id.tv_lms_performance)

        //mylearning
        ll_lms_mylearning = view.findViewById(R.id.ll_lms_mylearning)
        iv_lms_mylearning = view.findViewById(R.id.iv_lms_mylearning)
        tv_lms_mylearning = view.findViewById(R.id.tv_lms_mylearning)

        //leaderboard
        ll_lms_leaderboard = view.findViewById(R.id.ll_lms_leaderboard)
        iv_lms_leaderboard = view.findViewById(R.id.iv_lms_leaderboard)
        tv_lms_leaderboard = view.findViewById(R.id.tv_lms_leaderboard)

        //knowledgehub
        ll_lms_knowledgehub = view.findViewById(R.id.ll_lms_knowledgehub)
        iv_lms_knowledgehub = view.findViewById(R.id.iv_lms_knowledgehub)
        tv_lms_knowledgehub = view.findViewById(R.id.tv_lms_knowledgehub)

        iv_lms_mylearning.setImageResource(R.drawable.my_learning_filled_clr)
        iv_lms_leaderboard.setImageResource(R.drawable.leaderboard_new)
        iv_lms_performance.setImageResource(R.drawable.my_performance_new)
        iv_lms_knowledgehub.setImageResource(R.drawable.knowledge_hub_new)
        iv_lms_performance.setColorFilter(ContextCompat.getColor(mContext, R.color.black), android.graphics.PorterDuff.Mode.MULTIPLY)
        iv_lms_leaderboard.setColorFilter(ContextCompat.getColor(mContext, R.color.black), android.graphics.PorterDuff.Mode.MULTIPLY)
        iv_lms_knowledgehub.setColorFilter(ContextCompat.getColor(mContext, R.color.black), android.graphics.PorterDuff.Mode.MULTIPLY)

        tv_lms_performance.setTextColor(getResources().getColor(R.color.black))
        tv_lms_mylearning.setTextColor(getResources().getColor(R.color.toolbar_lms))
        tv_lms_leaderboard.setTextColor(getResources().getColor(R.color.black))
        tv_lms_knowledgehub.setTextColor(getResources().getColor(R.color.black))

        val rv_mylearning_progress: RecyclerView = view.findViewById(R.id.rv_mylearning_progress)
        val et_frag_learning_search: EditText = view.findViewById(R.id.et_frag_learning_search)
        val iv_frag_spk: LinearLayout = view.findViewById(R.id.iv_frag_spk)
        val ll_frag_search_root: LinearLayout = view.findViewById(R.id.ll_frag_search_root)
        val progress_wheel: ProgressWheel = view.findViewById(R.id.ll_frag_my_learning_progress_wheel)

        progress_wheel.stopSpinning()

        rv_mylearning_progress.layoutManager = LinearLayoutManager(mContext)

        val data = listOf(
            MyLearningData("The Basics of Product Knowledge Training","http://3.7.30.86:8073/Commonfolder/LMS/ContentUpload/Sell Me This Pen.mp4",  "Sales Training Basics Beginners Master","Debashis Das", 15),
            MyLearningData("The Basics of Product Knowledge Training","http://3.7.30.86:8073/Commonfolder/DocumentSharing/d9533eaf-9cd7-4b4f-b24d-c54b32d413ce.mp4",  "Sales Training Basics Beginners Master","Debashis Das", 50),
            MyLearningData("The Basics of Product Knowledge Training", "http://3.7.30.86:8073/Commonfolder/LMS/ContentUpload/nature shorts video.mp4","Sales Training Basics Beginners Master", "Debashis Das" ,100),
            MyLearningData("The Basics of Product Knowledge Training", "http://3.7.30.86:8073/Commonfolder/DocumentSharing/EXTREME PARKOUR JUMP over death gap.mp4","Sales Training Basics Beginners Master", "Debashis Das" ,35)
        )

        Handler().postDelayed(Runnable {
            val adapter = MyLearningProgressAdapter(mContext , data)
            rv_mylearning_progress.adapter = adapter
        }, 500)

        ll_lms_performance.setOnClickListener(this)
        ll_lms_mylearning.setOnClickListener(this)
        ll_lms_leaderboard.setOnClickListener(this)
        ll_lms_knowledgehub.setOnClickListener(this)
        iv_frag_spk.setOnClickListener(this)
        ll_frag_search_root.setOnClickListener(this)

    }

    data class MyLearningData(
        val videoname: String,
        val thumbnail: String,
        val title: String,
        val subtitle: String,
        val progress: Int
    )

    override fun onClick(p0: View?) {
        when (p0?.id) {
            ll_lms_mylearning.id -> {
                (mContext as DashboardActivity).loadFragment(
                    FragType.SearchLmsLearningFrag,
                    true,
                    ""
                )
            }

            ll_lms_leaderboard.id -> {
                (mContext as DashboardActivity).loadFragment(
                    FragType.LeaderboardLmsFrag,
                    true,
                    ""
                )
            }

            ll_lms_knowledgehub.id -> {
                (mContext as DashboardActivity).loadFragment(
                    FragType.SearchLmsKnowledgeFrag,
                    true,
                    ""
                )
            }

            ll_lms_performance.id -> {
                (mContext as DashboardActivity).loadFragment(
                    FragType.MyPerformanceFrag,
                    true,
                    ""
                )
            }
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?){
        super.onActivityResult(requestCode, resultCode, data)
        if(requestCode == 7009){
            try{
                val result = data!!.getStringArrayListExtra(RecognizerIntent.EXTRA_RESULTS)
                var t= result!![0]
                if(suffixText.length>0 && !suffixText.equals("")){
                    var setFullText = suffixText+t
                    et_search.setText(suffixText+t)
                    et_search.setSelection(setFullText.length);
                }else{
                    var SuffixPostText = t+et_search.text.toString()
                    et_search.setText(SuffixPostText)
                    et_search.setSelection(SuffixPostText.length);
                }
            }
            catch (ex:Exception) {
                ex.printStackTrace()
            }
        }
    }

}