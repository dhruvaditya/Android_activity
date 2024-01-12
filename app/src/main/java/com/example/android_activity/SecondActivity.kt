package com.example.android_activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class SecondActivity : AppCompatActivity() {
    //declaring the constraints which is used in second activity page
    private lateinit var textViewSecond: TextView
    private lateinit var btn_second:Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)
        //finding by id of both the constraints
        textViewSecond=findViewById(R.id.textViewSecond)
        btn_second=findViewById(R.id.btn_second)
        //this is getting the data from the first page
        val number =intent.getStringExtra("number")
        val result=Integer.parseInt(number)// converting the string into integer to perform multiplication
        //this is used for reflecting the data on the second page
        textViewSecond.text="Received number is :"+number
        btn_second.setOnClickListener {
            val answer = result * 2 // Calculate the result by multiplying the received number by 2
            val returnIntent = Intent() // Intent created to return the result to the calling activity
            returnIntent.putExtra("RESULT", answer)
            setResult(RESULT_OK, returnIntent) // Set the result with RESULT_OK and the return Intent
            finish()
        }
    }
}