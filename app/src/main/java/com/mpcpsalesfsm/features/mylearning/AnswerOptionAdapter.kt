package com.mpcpsalesfsm.features.mylearning
import com.mpcpsalesfsm.R
import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.RadioButton
import android.widget.TextView
import androidx.core.content.ContextCompat
import kotlinx.android.synthetic.main.answer_option_item_for_lms.view.radioButton

class AnswerOptionAdapter(private val answerOptions: List<String>) :
    RecyclerView.Adapter<AnswerOptionAdapter.AnswerViewHolder>() {

    private var selectedItemPosition = -1

    inner class AnswerViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val radioButton: RadioButton = itemView.findViewById(R.id.option_radio_button)
        private val textView: TextView = itemView.findViewById(R.id.answer_text)
        private val radioButtonL: LinearLayout = itemView.findViewById(R.id.radioButton)

        fun bind(answerOption: String, isSelected: Boolean) {
            textView.text = answerOption
            radioButton.isChecked = isSelected

            if (isSelected) {
                radioButtonL.background = ContextCompat.getDrawable(itemView.context, R.drawable.back_round_corner_green)
            } else {
                radioButtonL.background = ContextCompat.getDrawable(itemView.context, R.drawable.back_round_corner_7)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AnswerViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.answer_option_item_for_lms, parent, false)
        return AnswerViewHolder(itemView)
    }

    private val selectedPositions = mutableSetOf<Int>()

    override fun onBindViewHolder(holder: AnswerViewHolder, position: Int) {
        val answerOption = answerOptions[position]
        val isSelected = selectedPositions.contains(position)
        holder.bind(answerOption, isSelected)
        holder.itemView.setOnClickListener {
            if (isSelected) {
                selectedPositions.remove(position)
            } else {
                selectedPositions.add(position)
            }
            notifyDataSetChanged()
        }
    }
    override fun getItemCount(): Int {
        return answerOptions.size
    }
}