package com.example.quizappsimple

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import java.util.jar.Attributes.Name

class MainActivity : AppCompatActivity() {
    private var StartBtn : Button? = null
    private var NameUser : EditText? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //Get View For StartButton And NameUser
        StartBtn = findViewById(R.id.BtnStart)
        NameUser = findViewById(R.id.EtName)
        //Check Event For Button If Empty We Print Notification
        StartBtn?.setOnClickListener{
            if (NameUser?.text.toString().isNotEmpty() ) {
                Toast.makeText(this,"SUSCESSFULL",Toast.LENGTH_SHORT).show()
                val intent = Intent(this,QuizQuestionActivity::class.java)
                intent.putExtra(Constraint.USER_NAME, NameUser?.text.toString())
                startActivity(intent)
                finish()
            } else {
                Toast.makeText(this,"PLEASE ENTER YOUR NAME!!",Toast.LENGTH_SHORT).show()
            }
        }
    }
}