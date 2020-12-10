package com.example.edecora

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import kotlinx.android.synthetic.main.activity_festival_main.*
import kotlinx.android.synthetic.main.profile_add.*

class FestivalMain : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_festival_main)


        val addToCart25 = findViewById<Button>(R.id.addToCart25)

        //create the intent to add the items into the cart
        addToCart25.setOnClickListener {
            val intent = Intent(applicationContext, Cart::class.java)
            intent.putExtra("name", textView23.text.toString() )
            startActivity(intent)
        }

        val addToCart26 = findViewById<Button>(R.id.addToCart26)

        //create the intent to add the items into the cart
        addToCart26.setOnClickListener {
            val intent = Intent(applicationContext, Cart::class.java)
            startActivity(intent)
        }

        val addToCart27 = findViewById<Button>(R.id.addToCart27)

        //create the intent to add the items into the cart
        addToCart27.setOnClickListener {
            val intent = Intent(applicationContext, Cart::class.java)
            startActivity(intent)
        }

        val addToCart28 = findViewById<Button>(R.id.addToCart28)

        //create the intent to add the items into the cart
        addToCart28.setOnClickListener {
            val intent = Intent(applicationContext, Cart::class.java)
            startActivity(intent)
        }
    }
}