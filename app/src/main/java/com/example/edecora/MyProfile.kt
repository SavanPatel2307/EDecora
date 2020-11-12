package com.example.edecora

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MyProfile : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_my_profile)

        /* NOTE:
        Want to retrive Data from Firebase but not able to do it for right now.
        I did upload data to database in Firebase.
        I can see all the details user put in the MyInformation.kt file
        I will learn to retrive data and will be done this in next assignment
         */
        val HomeBtn = findViewById<Button>(R.id.HomeBtn)

        //Add intent to send homepage
        HomeBtn.setOnClickListener{
            val intent = Intent(applicationContext, MainActivity::class.java)
            startActivity(intent)
        }
    }
}