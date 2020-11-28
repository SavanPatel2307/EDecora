package com.example.edecora

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.method.ScrollingMovementMethod
import android.widget.Button
import android.widget.ScrollView
import android.widget.TextView

class BirthdayMain : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_birthday_main)

        val addToCart = findViewById<Button>(R.id.addToCart)

        //create the intent to add the items into the cart
        addToCart.setOnClickListener {
            val intent = Intent(applicationContext, Cart::class.java)

            startActivity(intent)
        }

        val addToCart2 = findViewById<Button>(R.id.addToCart2)

        //create the intent to add the items into the cart
        addToCart2.setOnClickListener {
            val intent = Intent(applicationContext, Cart::class.java)
            startActivity(intent)
        }

//        val birthdayTextView = findViewById<TextView>(R.id.birthdayTextView)
//
//        birthdayTextView.movementMethod = ScrollingMovementMethod()

        val addToCart3 = findViewById<Button>(R.id.addToCart3)

        //create the intent to add the items into the cart
        addToCart3.setOnClickListener {
            val intent = Intent(applicationContext, Cart::class.java)
            startActivity(intent)
        }

        val addToCart4 = findViewById<Button>(R.id.addToCart4)

        //create the intent to add the items into the cart
        addToCart4.setOnClickListener {
            val intent = Intent(applicationContext, Cart::class.java)
            startActivity(intent)
        }

    }
}