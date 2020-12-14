package com.example.edecora

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.google.firebase.auth.ktx.auth
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.ktx.Firebase
import kotlinx.android.synthetic.main.activity_birthday_main.*
import kotlinx.android.synthetic.main.activity_other_main.*

class OtherMain : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_other_main)

        val addToCart31 = findViewById<Button>(R.id.addToCart31)
        addToCart31.setOnClickListener {
            val intent = Intent(applicationContext, Cart::class.java)
            startActivity(intent)

            val CartItems = CartItems()
            CartItems.itemName = textView28.text.toString().trim()
            CartItems.itemPrice = price31.text.toString().trim()
            CartItems.iID = Firebase.auth.currentUser?.uid

            val db = FirebaseFirestore.getInstance().collection("CartItems")
            CartItems.itemId = db.document().id
            db.document(CartItems.itemId!!).set(CartItems)
        }

        val addToCart32 = findViewById<Button>(R.id.addToCart32)
        addToCart32.setOnClickListener {
            val intent = Intent(applicationContext, Cart::class.java)
            startActivity(intent)

            val CartItems = CartItems()
            CartItems.itemName = textView29.text.toString().trim()
            CartItems.itemPrice = price32.text.toString().trim()
            CartItems.iID = Firebase.auth.currentUser?.uid

            val db = FirebaseFirestore.getInstance().collection("CartItems")
            CartItems.itemId = db.document().id
            db.document(CartItems.itemId!!).set(CartItems)
        }

        val addToCart33 = findViewById<Button>(R.id.addToCart33)
        addToCart33.setOnClickListener {
            val intent = Intent(applicationContext, Cart::class.java)
            startActivity(intent)

            val CartItems = CartItems()
            CartItems.itemName = textView30.text.toString().trim()
            CartItems.itemPrice = price33.text.toString().trim()
            CartItems.iID = Firebase.auth.currentUser?.uid

            val db = FirebaseFirestore.getInstance().collection("CartItems")
            CartItems.itemId = db.document().id
            db.document(CartItems.itemId!!).set(CartItems)
        }

        val addToCart34 = findViewById<Button>(R.id.addToCart34)
        addToCart34.setOnClickListener {
            val intent = Intent(applicationContext, Cart::class.java)
            startActivity(intent)

            val CartItems = CartItems()
            CartItems.itemName = textView31.text.toString().trim()
            CartItems.itemPrice = price12.text.toString().trim()
            CartItems.iID = Firebase.auth.currentUser?.uid

            val db = FirebaseFirestore.getInstance().collection("CartItems")
            CartItems.itemId = db.document().id
            db.document(CartItems.itemId!!).set(CartItems)
        }
    }
}