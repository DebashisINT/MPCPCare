package com.mpcpsalesfsm.features.mylearning

import android.content.Context
import android.os.Bundle
import android.text.TextUtils
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.mpcpsalesfsm.R
import com.mpcpsalesfsm.app.types.FragType
import com.mpcpsalesfsm.base.presentation.BaseFragment
import com.mpcpsalesfsm.features.dashboard.presentation.DashboardActivity

class LmsQuestionAnswerSet : BaseFragment() , View.OnClickListener {
    private lateinit var mContext: Context
    private lateinit var questionRecyclerView: RecyclerView
    private lateinit var tv_save_qstn_answr_set: TextView
    private lateinit var questionAdapter: QuestionAdapter

    companion object{
        var questionlist: ArrayList<QuestionL> = ArrayList()
        var previousFrag: String = ""
        fun getInstance(objects: Any): LmsQuestionAnswerSet {
            val lmsQuestionAnswerSet = LmsQuestionAnswerSet()
            if (!TextUtils.isEmpty(objects.toString())) {
                questionlist=objects as ArrayList<QuestionL>
            }else{
                questionlist = ArrayList()
            }
            println("tag_questionlist"+ questionlist)
            return lmsQuestionAnswerSet
        }
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        mContext = context
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater!!.inflate(R.layout.fragment_lms_question_answer_set, container, false)
        initView(view)
        return view
    }

    private fun initView(view: View) {

        // Initialize adapters and set them to RecyclerViews
        questionRecyclerView = view.findViewById(R.id.question_answer_recycler_view)
        tv_save_qstn_answr_set = view.findViewById(R.id.tv_save_qstn_answr_set)
        questionRecyclerView.layoutManager = LinearLayoutManager(mContext)

        /*val setUpQuestionAnswer = SetUpQuestionAnswer(
            listOf(
                QuestionForLms(
                    "Question-1",
                    "What is the total combined customer lifetime values of all of the company's customers?",
                    listOf(
                        AnswerOptionForLms("A. Customer equity", false),
                        AnswerOptionForLms("B. Customer-perceived value", false),
                        AnswerOptionForLms("C. Customer Lifetime value", false),
                        AnswerOptionForLms("D. Customer share", false)
                    )
                ),
                QuestionForLms(
                    "Question-2",
                    "Promotion mix includes Sales Promotion, Personal Selling, Advertising and",
                    listOf(
                        AnswerOptionForLms("A. Marketing", false),
                        AnswerOptionForLms("B. Sales", false),
                        AnswerOptionForLms("C. Publicity", false),
                        AnswerOptionForLms("D. None of these", false)
                    )
                )
            )
        )*/

        tv_save_qstn_answr_set.setOnClickListener {
            (context as DashboardActivity).loadFragment(FragType.VideoPlayLMS, true, "")
        }

        questionAdapter = QuestionAdapter(/*setUpQuestionAnswer*/ questionlist)
        questionRecyclerView.adapter = questionAdapter
    }

    override fun onClick(p0: View?) {
        when (p0?.id) {

        }
    }

}