package com.mpcpsalesfsm.features.mylearning
import android.content.Context
import android.graphics.Typeface
import android.net.Uri
import android.os.Bundle
import android.text.Spannable
import android.text.SpannableString
import android.text.SpannableStringBuilder
import android.text.Spanned
import android.text.style.ForegroundColorSpan
import android.text.style.RelativeSizeSpan
import android.text.style.StyleSpan
import android.view.LayoutInflater
import android.view.View
import android.view.View.OnClickListener
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.activity.OnBackPressedCallback
import androidx.cardview.widget.CardView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.mpcpsalesfsm.R
import com.mpcpsalesfsm.app.types.FragType
import com.mpcpsalesfsm.app.utils.Toaster
import com.mpcpsalesfsm.base.presentation.BaseFragment
import com.mpcpsalesfsm.features.contacts.ViewCrmOpptFrag
import com.mpcpsalesfsm.features.dashboard.presentation.DashboardActivity
import com.etebarian.meowbottomnavigation.MeowBottomNavigation


class MyLearningFragment : BaseFragment(),OnClickListener {
    private lateinit var mContext: Context
    private lateinit var bottomNavigation: MeowBottomNavigation
    private lateinit var cv_lms_learner_space: CardView
    private lateinit var cv_lms_leaderboard: CardView
    private lateinit var ll_knowledgeHub: LinearLayout
    private lateinit var ll_myLearning: LinearLayout
    private lateinit var cv_frag_search_mylearning_root: CardView

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
    private lateinit var tv_content: TextView
    private lateinit var tv_content_learning: TextView
    private lateinit var tv_content_knowledge: TextView


    override fun onAttach(context: Context) {
        super.onAttach(context)
        mContext = context
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        super.onCreateView(inflater, container, savedInstanceState)
        val view = inflater!!.inflate(R.layout.fragment_my_learning, container, false)
        initView(view)
        requireActivity().getOnBackPressedDispatcher()
            .addCallback(object : OnBackPressedCallback(true) {
                @Override
                override fun handleOnBackPressed() {

                }
            });


        return view
    }

    private fun initView(view: View) {
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

        iv_lms_leaderboard.setImageResource(R.drawable.leaderboard_new)
        iv_lms_performance.setImageResource(R.drawable.my_performance_new)
        iv_lms_mylearning.setImageResource(R.drawable.my_learning_new)
        iv_lms_knowledgehub.setImageResource(R.drawable.knowledge_hub_new)
        iv_lms_leaderboard.setColorFilter(ContextCompat.getColor(mContext, R.color.black), android.graphics.PorterDuff.Mode.MULTIPLY)
        iv_lms_performance.setColorFilter(ContextCompat.getColor(mContext, R.color.black), android.graphics.PorterDuff.Mode.MULTIPLY)
        iv_lms_mylearning.setColorFilter(ContextCompat.getColor(mContext, R.color.black), android.graphics.PorterDuff.Mode.MULTIPLY)
        iv_lms_knowledgehub.setColorFilter(ContextCompat.getColor(mContext, R.color.black), android.graphics.PorterDuff.Mode.MULTIPLY)

        tv_lms_performance.setTextColor(getResources().getColor(R.color.black))
        tv_lms_mylearning.setTextColor(getResources().getColor(R.color.black))
        tv_lms_leaderboard.setTextColor(getResources().getColor(R.color.black))
        tv_lms_knowledgehub.setTextColor(getResources().getColor(R.color.black))


        cv_lms_learner_space = view.findViewById(R.id.cv_lms_learner_space)
        ll_knowledgeHub = view.findViewById(R.id.ll_frag_search_knowledge_hub_root)
        ll_myLearning = view.findViewById(R.id.ll_frag_search_mylearning_root)
        cv_frag_search_mylearning_root = view.findViewById(R.id.cv_frag_search_mylearning_root)
        cv_lms_leaderboard = view.findViewById(R.id.cv_lms_leaderboard)
        tv_content = view.findViewById(R.id.tv_content)
        tv_content_learning = view.findViewById(R.id.tv_content_learning)
        tv_content_knowledge = view.findViewById(R.id.tv_content_knowledge)

        val fullText = tv_content.text.toString()
        val parts = fullText.split("\n")

        val largeText = parts[0]
        val smallText = parts[1]
        val spannableString = SpannableString(fullText)
        // Set the size of "1000"
        spannableString.setSpan(
            RelativeSizeSpan(1.2f), // 4 times the default size
            0,
            largeText.length,
            Spanned.SPAN_EXCLUSIVE_EXCLUSIVE
        )
        // Make "1000" bold
        spannableString.setSpan(
            StyleSpan(Typeface.BOLD),
            0,
            largeText.length,
            Spanned.SPAN_EXCLUSIVE_EXCLUSIVE
        )
        // Set the size of "Contents"
        spannableString.setSpan(
            RelativeSizeSpan(0.98f), // default size
            largeText.length + 1, // +1 to account for the newline character
            smallText.length,
            Spanned.SPAN_EXCLUSIVE_EXCLUSIVE
        )
        tv_content.text = spannableString

        val fullText1 = tv_content_learning.text.toString()
        val parts1 = fullText1.split("\n")

        val largeText1 = parts1[0]
        val smallText1 = parts1[1]
        val spannableString1 = SpannableString(fullText1)
        spannableString1.setSpan(
            RelativeSizeSpan(1.2f), // 4 times the default size
            0,
            largeText1.length,
            Spanned.SPAN_EXCLUSIVE_EXCLUSIVE
        )
        spannableString1.setSpan(
            StyleSpan(Typeface.BOLD),
            0,
            largeText1.length,
            Spanned.SPAN_EXCLUSIVE_EXCLUSIVE
        )
        spannableString1.setSpan(
            RelativeSizeSpan(0.98f), // default size
            largeText.length + 1, // +1 to account for the newline character
            smallText1.length,
            Spanned.SPAN_EXCLUSIVE_EXCLUSIVE
        )
        tv_content_learning.text = spannableString1

        val fullText2 = tv_content_knowledge.text.toString()
        val parts2 = fullText2.split("\n")

        val largeText2 = parts2[0]
        val smallText2 = parts2[1]
        val spannableString2 = SpannableString(fullText2)
        spannableString2.setSpan(
            RelativeSizeSpan(1.2f), // 4 times the default size
            0,
            largeText2.length,
            Spanned.SPAN_EXCLUSIVE_EXCLUSIVE
        )
        spannableString2.setSpan(
            StyleSpan(Typeface.BOLD),
            0,
            largeText2.length,
            Spanned.SPAN_EXCLUSIVE_EXCLUSIVE
        )
        spannableString2.setSpan(
            RelativeSizeSpan(0.98f), // default size
            largeText2.length + 1, // +1 to account for the newline character
            smallText2.length,
            Spanned.SPAN_EXCLUSIVE_EXCLUSIVE
        )
        tv_content_knowledge.text = spannableString2


        cv_lms_learner_space.setOnClickListener {
            (mContext as DashboardActivity).loadFragment(FragType.SearchLmsFrag, true, "")
        }

        ll_knowledgeHub.setOnClickListener(this)
        cv_lms_leaderboard.setOnClickListener(this)
        ll_lms_performance.setOnClickListener(this)
        ll_lms_mylearning.setOnClickListener(this)
        ll_lms_leaderboard.setOnClickListener(this)
        ll_lms_knowledgehub.setOnClickListener(this)
        ll_myLearning.setOnClickListener(this)
        cv_frag_search_mylearning_root.setOnClickListener(this)

    }


    fun getURLForResource(resourceId: Int): String {
        return Uri.parse("android.resource://" + com.mpcpsalesfsm.R::class.java.getPackage().name + "/" + resourceId)
            .toString()
    }

    companion object {
        fun getInstance(objects: Any): MyLearningFragment {
            val fragment = MyLearningFragment()
            return fragment
        }
    }

    override fun onClick(v: View?) {
        when(v?.id){
            ll_knowledgeHub.id -> {
                (mContext as DashboardActivity).loadFragment(FragType.SearchLmsKnowledgeFrag, true, "")
            }

            ll_myLearning.id -> {
                (mContext as DashboardActivity).loadFragment(FragType.SearchLmsLearningFrag, true, "")
            }

            cv_lms_leaderboard.id -> {
                (mContext as DashboardActivity).loadFragment(FragType.LeaderboardLmsFrag, true, "")
            }

            ll_lms_mylearning.id -> {
                (mContext as DashboardActivity).loadFragment(FragType.SearchLmsLearningFrag, true, "")
            }

            ll_lms_leaderboard.id -> {
                (mContext as DashboardActivity).loadFragment(FragType.LeaderboardLmsFrag, true, "")
            }

            ll_lms_knowledgehub.id -> {
                (mContext as DashboardActivity).loadFragment(FragType.SearchLmsKnowledgeFrag, true, "")
            }
            ll_lms_performance.id -> {
                (mContext as DashboardActivity).loadFragment(FragType.MyPerformanceFrag, true, "")

            }
            cv_frag_search_mylearning_root.id -> {
                (mContext as DashboardActivity).loadFragment(FragType.MyPerformanceFrag, true, "")
            }
        }
    }



}