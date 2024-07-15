package com.mpcpsalesfsm.features.mylearning

import android.content.SyncRequest
import com.mpcpsalesfsm.base.BaseResponse

data class GridDashboard(var imagepath:String = "" , var name :String = "")

data class TopicListResponse(var user_id:String="",var topic_list:ArrayList<TopicList>):BaseResponse()


data class VideoTopicWiseResponse(var topic_id:String="",var topic_name:String="",var content_list:ArrayList<ContentL>):BaseResponse()
data class ContentL(var content_id:String="",var content_url:String="",var content_title:String="",var content_description:String="",var content_play_sequence:String="",
    var isAllowLike:Boolean = false,var isAllowComment:Boolean = false,var isAllowShare:Boolean=false,var question_list:ArrayList<QuestionL> = ArrayList()
)
data class QuestionL(var topic_id:String="",var content_id:String="",var question_id:String="",var question:String="",var question_description:String="",
                     var option_list:ArrayList<OptionL> = ArrayList()
)
data class OptionL(var question_id:String="",var option_id:String="",
                   var option_no_1:String="",var option_point_1:String="",var isCorrect_1:Boolean=false,
                   var option_no_2:String="",var option_point_2:String="",var isCorrect_2:Boolean=false,
                   var option_no_3:String="",var option_point_3:String="",var isCorrect_3:Boolean=false,
                   var option_no_4:String="",var option_point_4:String="",var isCorrect_4:Boolean=false,var isSelected: Boolean)

data class TopicList(var topic_id:Int=0,var topic_name:String="")

data class QuestionForLms(val headerText: String, val questionText: String, val answerOptions: List<AnswerOptionForLms>)
data class AnswerOptionForLms(val text: String, var isSelected: Boolean)
data class SetUpQuestionAnswer(val questions: List<QuestionForLms>)

