package com.example.edecora

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class WeddingMain : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_wedding_main)

        val addToCart19 = findViewById<Button>(R.id.addToCart19)

        //create the intent to add the items into the cart
        addToCart19.setOnClickListener {
            val intent = Intent(applicationContext, Cart::class.java)
            startActivity(intent)
        }

        val addToCart20 = findViewById<Button>(R.id.addToCart20)

        //create the intent to add the items into the cart
        addToCart20.setOnClickListener {
            val intent = Intent(applicationContext, Cart::class.java)
            startActivity(intent)
        }

        val addToCart21 = findViewById<Button>(R.id.addToCart21)

        //create the intent to add the items into the cart
        addToCart21.setOnClickListener {
            val intent = Intent(applicationContext, Cart::class.java)
            startActivity(intent)
        }

        val addToCart22 = findViewById<Button>(R.id.addToCart22)

        //create the intent to add the items into the cart
        addToCart22.setOnClickListener {
            val intent = Intent(applicationContext, Cart::class.java)
            startActivity(intent)
        }
    }
}