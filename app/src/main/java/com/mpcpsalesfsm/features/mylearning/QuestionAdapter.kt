package com.mpcpsalesfsm.features.mylearning
import android.util.Log
import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import com.mpcpsalesfsm.R

class QuestionAdapter(private val setUpQuestionAnswer: ArrayList<QuestionL>) : RecyclerView.Adapter<QuestionAdapter.QuestionViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): QuestionViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.question_item_for_lms, parent, false)
        return QuestionViewHolder(view)
    }

    override fun onBindViewHolder(holder: QuestionViewHolder, position: Int) {
        holder.bind(setUpQuestionAnswer)
    }

    override fun getItemCount(): Int {
        return setUpQuestionAnswer.size
    }

    inner class QuestionViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private lateinit var answerRecyclerView: RecyclerView
        private lateinit var answerAdapter: AnswerOptionAdapter

        init {
            answerRecyclerView = itemView.findViewById(R.id.answer_recycler_view)
            answerRecyclerView.layoutManager = LinearLayoutManager(itemView.context)
        }

        fun bind(question: ArrayList<QuestionL>) {
            Log.d("tag_question",""+question.get(position).question)
            itemView.findViewById<TextView>(R.id.header_text).text = question.get(position).question
            itemView.findViewById<TextView>(R.id.question_text).text = question.get(position).question_description

            // Create an ArrayList to hold the options
            val options = arrayListOf<String>()

            // Extract the options and add them to the ArrayList
            for (i in 0 until question.get(position).option_list.size) {
                val option = question.get(position).option_list.get(0)
                options.add(option.option_no_1)
                options.add(option.option_no_2)
                options.add(option.option_no_3)
                options.add(option.option_no_4)
            }
            answerAdapter = AnswerOptionAdapter(options)
            answerRecyclerView.adapter = answerAdapter
        }
    }
}