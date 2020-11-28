 package com.example.edecora

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

 class EventMain : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_event_main)

        val addToCart7 = findViewById<Button>(R.id.addToCart7)

        //create the intent to add the items into the cart
        addToCart7.setOnClickListener {
            val intent = Intent(applicationContext, Cart::class.java)
            startActivity(intent)
        }

        val addToCart8 = findViewById<Button>(R.id.addToCart8)

        //create the intent to add the items into the cart
        addToCart8.setOnClickListener {
            val intent = Intent(applicationContext, Cart::class.java)
            startActivity(intent)
        }

        val addToCart9 = findViewById<Button>(R.id.addToCart9)

        //create the intent to add the items into the cart
        addToCart9.setOnClickListener {
            val intent = Intent(applicationContext, Cart::class.java)
            startActivity(intent)
        }

        val addToCart10 = findViewById<Button>(R.id.addToCart10)

        //create the intent to add the items into the cart
        addToCart10.setOnClickListener {
            val intent = Intent(applicationContext, Cart::class.java)
            startActivity(intent)
        }

    }
}