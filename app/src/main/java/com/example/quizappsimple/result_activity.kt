package com.example.quizappsimple

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ProgressBar
import android.widget.TextView


class result_activity : AppCompatActivity() {
    private var TvScore : TextView? = null
    private var PlayerName : TextView? = null
    private var PbScore : ProgressBar? = null
    private var BtnRestart : Button? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)
        TvScore = findViewById(R.id.TvScore)
        PbScore = findViewById(R.id.PbScore)
        PlayerName = findViewById(R.id.TPlayer)
        BtnRestart = findViewById(R.id.BtnResrart)
        val Score = intent.getIntExtra(Constraint.SCORE,0)
        val Total_Quest = intent.getIntExtra(Constraint.TOTAL_QUEST,0).toString()
        val UserName = intent.getStringExtra(Constraint.USER_NAME)
        PlayerName?.text = "PLAYER, $UserName"
        PbScore?.progress = Score
        TvScore?.text =  "${Score}0/${Total_Quest}0"
        BtnRestart?.setOnClickListener{
            val intent = Intent (this,MainActivity::class.java)
            startActivity(intent)
        }


    }
}