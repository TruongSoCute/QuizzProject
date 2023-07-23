package com.example.quizappsimple

import android.content.Context
import android.content.Intent
import android.graphics.Color
import android.graphics.Typeface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.View.OnClickListener
import android.widget.Button
import android.widget.ProgressBar
import android.widget.TextView
import android.widget.Toast
import androidx.core.content.ContextCompat

class QuizQuestionActivity : AppCompatActivity(), View.OnClickListener {

    var Quest : TextView? = null
    var OptionOne : TextView? = null
    var OptionTwo : TextView? = null
    var OptionThree : TextView? = null
    var OptionFour : TextView? = null
    var SumbitBtn : Button? = null
    var PbText : TextView? = null
    var PbBar : ProgressBar? = null
    var CurrentPoint = 0
    var mListQuestion : ArrayList<Question>? = null
    var CorrectSelect : Int? = null
    var Option = ArrayList<TextView>()
    var ChooseAnswer : Int? = null
    var Clicked : Boolean = false
    var Score = 0
    var UName : String? = null
    var HistoryChoose : ArrayList<History>? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quiz_question)
        UName = intent.getStringExtra(Constraint.USER_NAME)
        HistoryChoose = ArrayList<History>()

        GetViewDef()
        InitVar()
        SetDefault()
    }
    private fun GetViewDef(){
        //Get View For UI
        Quest = findViewById(R.id.TvQuest)
        OptionOne = findViewById(R.id.TvOptionOne)
        OptionTwo = findViewById(R.id.TvOptionTwo)
        OptionThree = findViewById(R.id.TvOptionThree)
        OptionFour = findViewById(R.id.TvOptionFour)
        SumbitBtn = findViewById(R.id.BtnSumbit)
        PbBar = findViewById(R.id.PbBar)
        PbText = findViewById(R.id.PbText)
    }

    private fun InitVar(){
        //Initilizer
        mListQuestion = Constraint.getQuestion()
        mListQuestion?.shuffle()
        val CurrentQuestion = mListQuestion!![CurrentPoint]
        //RandomQuest
        CorrectSelect = CurrentQuestion.CorectAnswer
        val Tmp = ArrayList<String>()
        Tmp.add(CurrentQuestion.OptionOne)
        Tmp.add(CurrentQuestion.OptionTwo)
        Tmp.add(CurrentQuestion.OptionThree)
        Tmp.add(CurrentQuestion.OptionFour)
        val CrAnswer = when (CorrectSelect) {
                1 -> CurrentQuestion.OptionOne
                2 -> CurrentQuestion.OptionTwo
                3 -> CurrentQuestion.OptionThree
                4 -> CurrentQuestion.OptionFour
                else -> ""
        }
        Tmp.shuffle()
        when (CrAnswer) {
            Tmp[0] -> CorrectSelect = 1
            Tmp[1] -> CorrectSelect = 2
            Tmp[2] -> CorrectSelect = 3
            Tmp[3] -> CorrectSelect = 4
        }
        //EndRandom
        Quest?.text = "Q${CurrentPoint+1}." + CurrentQuestion.Question
        OptionOne?.text = "A." + Tmp[0]
        OptionTwo?.text = "B." + Tmp[1]
        OptionThree?.text ="C." +Tmp[2]
        OptionFour?.text = "D." +Tmp[3]
        PbBar?.progress =CurrentPoint+1
        PbText?.text = "${CurrentPoint+1}/${mListQuestion?.size} "
        OptionOne?.setOnClickListener(this)
        OptionTwo?.setOnClickListener(this)
        OptionThree?.setOnClickListener(this)
        OptionFour?.setOnClickListener(this)
        SumbitBtn?.setOnClickListener(this)
        if (CurrentPoint+1 == mListQuestion?.size) {
            SumbitBtn?.text = "FINISH!!"
        } else {
            SumbitBtn?.text ="SUMBIT"
        }
    }

    fun SetDefault(){
        OptionOne?.let{
            Option.add(0,it)
        }
        OptionTwo?.let{
            Option.add(1,it)
        }
        OptionThree?.let{
            Option.add(2,it)
        }
        OptionFour?.let{
            Option.add(3,it)
        }
    }
    fun ReDrawText(){
        SetDefault()
        for (option in Option) {
            option.setTextColor(Color.parseColor("#FF323232"))
            option.background = ContextCompat.getDrawable(this, R.drawable.unselected_outline)
        }
    }
    fun DrawSelected(SelectView: TextView){
        ReDrawText()
        SelectView.background = ContextCompat.getDrawable(this, R.drawable.selected_outline)
        SelectView.setTextColor(Color.parseColor("#FF000000"))
    }
    override fun onClick(view: View?) {
        when (view?.id) {
            R.id.TvOptionOne -> {
                OptionOne?.let {
                    ChooseAnswer = 1
                    DrawSelected(it)
                }
            }

            R.id.TvOptionTwo -> {
                OptionTwo?.let {
                    ChooseAnswer = 2
                    DrawSelected(it)
                }
            }

            R.id.TvOptionThree -> {
                OptionThree?.let {
                    ChooseAnswer = 3
                    DrawSelected(it)
                }
            }

            R.id.TvOptionFour -> {
                OptionFour?.let {
                    ChooseAnswer = 4
                    DrawSelected(it)
                }
            }
            R.id.BtnSumbit -> {
                if (ChooseAnswer != 0) {
                    if (ChooseAnswer == CorrectSelect) {
                        DrawAnswer(ChooseAnswer, R.drawable.correct_but)
                        ++Score
                    } else {
                        DrawAnswer(CorrectSelect, R.drawable.correct_but)
                        DrawAnswer(ChooseAnswer, R.drawable.un_correct_but)
                    }
                    if (!Clicked) {
                        var Fns = String()
                        if (CurrentPoint + 1 == mListQuestion?.size) {
                            Fns = "FINISH"
                        } else {
                            Fns = "NEXT"
                        }
                        SumbitBtn?.text = "CLICK TO $Fns!!"
                        Clicked = !Clicked
                    } else {
                        CurrentPoint++
                        Clicked = !Clicked
                        if (CurrentPoint + 1 == mListQuestion!!.size) {
                            val intent = Intent(this, result_activity::class.java)
                            intent.putExtra(Constraint.SCORE,Score)
                            intent.putExtra(Constraint.TOTAL_QUEST,mListQuestion?.size)
                            intent.putExtra(Constraint.USER_NAME,UName)
                            intent.putExtra(Constraint.TOTAL_QUEST,HistoryChoose)
                            startActivity(intent)
                            finish()
                        }
                        val HistoryQuest = mListQuestion!![CurrentPoint].Question
                        val HistoryCorrect  = when (CorrectSelect) {
                            1 -> OptionOne.toString()
                            2 -> OptionTwo.toString()
                            3 -> OptionThree.toString()
                            4 -> OptionFour.toString()
                            else -> ""
                        }
                        val HistoryChs = when (ChooseAnswer) {
                            1 -> OptionOne.toString()
                            2 -> OptionTwo.toString()
                            3 -> OptionThree.toString()
                            4 -> OptionFour.toString()
                            else -> ""
                        }
                        HistoryChoose?.add(History(HistoryQuest,HistoryCorrect,HistoryChs))
                        ChooseAnswer = 0
                        InitVar()
                        SetDefault()
                        ReDrawText()
                    }
                } else {
                    Toast.makeText(this,"PLEASE SELECT!!",Toast.LENGTH_SHORT).show()
                }
            }
        }
    }
    fun DrawAnswer(Choose : Int?, DrawableView : Int) {
            when (Choose) {
                1 -> {
                    OptionOne?.background = ContextCompat.getDrawable(this, DrawableView)
                    OptionOne?.setTextColor(Color.parseColor("#000000"))
                }

                2 -> {
                    OptionTwo?.background = ContextCompat.getDrawable(this, DrawableView)
                    OptionTwo?.setTextColor(Color.parseColor("#000000"))
                }

                3 -> {
                    OptionThree?.background = ContextCompat.getDrawable(this, DrawableView)
                    OptionThree?.setTextColor(Color.parseColor("#000000"))
                }

                4 -> {
                    OptionFour?.background = ContextCompat.getDrawable(this, DrawableView)
                    OptionFour?.setTextColor(Color.parseColor("#000000"))
                }
            }
    }
 }