package com.example.edecora

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class AnniversaryMain : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_anniversary_main)

        val addToCart13 = findViewById<Button>(R.id.addToCart13)

        //create the intent to add the items into the cart
        addToCart13.setOnClickListener {
            val intent = Intent(applicationContext, Cart::class.java)
            startActivity(intent)
        }

        val addToCart14 = findViewById<Button>(R.id.addToCart14)

        //create the intent to add the items into the cart
        addToCart14.setOnClickListener {
            val intent = Intent(applicationContext, Cart::class.java)
            startActivity(intent)
        }

        val addToCart15 = findViewById<Button>(R.id.addToCart15)

        //create the intent to add the items into the cart
        addToCart15.setOnClickListener {
            val intent = Intent(applicationContext, Cart::class.java)
            startActivity(intent)
        }

        val addToCart16 = findViewById<Button>(R.id.addToCart16)

        //create the intent to add the items into the cart
        addToCart16.setOnClickListener {
            val intent = Intent(applicationContext, Cart::class.java)
            startActivity(intent)
        }
    }
}