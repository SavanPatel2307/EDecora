package com.example.edecora

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class OtherMain : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_other_main)

        val addToCart31 = findViewById<Button>(R.id.addToCart31)

        //create the intent to add the items into the cart
        addToCart31.setOnClickListener {
            val intent = Intent(applicationContext, Cart::class.java)
            startActivity(intent)
        }

        val addToCart32 = findViewById<Button>(R.id.addToCart32)

        //create the intent to add the items into the cart
        addToCart32.setOnClickListener {
            val intent = Intent(applicationContext, Cart::class.java)
            startActivity(intent)
        }

        val addToCart33 = findViewById<Button>(R.id.addToCart33)

        //create the intent to add the items into the cart
        addToCart33.setOnClickListener {
            val intent = Intent(applicationContext, Cart::class.java)
            startActivity(intent)
        }

        val addToCart34 = findViewById<Button>(R.id.addToCart34)

        //create the intent to add the items into the cart
        addToCart34.setOnClickListener {
            val intent = Intent(applicationContext, Cart::class.java)
            startActivity(intent)
        }
    }
}