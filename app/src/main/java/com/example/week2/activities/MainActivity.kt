package com.example.week2.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.week2.R
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //Set onclick listener to button 1 to open the first implementation screen on each button click
        btn_1.setOnClickListener {
            startActivity(
                Intent(this, Implementation1Activity::class.java)
            )
        }

        //Set onclick listener to button 2 to open the second implementation screen each on button click
        btn_2.setOnClickListener {
            startActivity(
                Intent(this, Implementation2Activity::class.java)
            )
        }
    }
}