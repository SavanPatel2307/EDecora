package com.example.edecora

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.google.firebase.auth.ktx.auth
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.ktx.Firebase
import kotlinx.android.synthetic.main.activity_anniversary_main.*
import kotlinx.android.synthetic.main.activity_festival_main.*

class AnniversaryMain : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_anniversary_main)

        val addToCart13 = findViewById<Button>(R.id.addToCart13)
        addToCart13.setOnClickListener {
            val intent = Intent(applicationContext, Cart::class.java)
            startActivity(intent)

            val CartItems = CartItems()
            CartItems.itemName = textView13.text.toString().trim()
            CartItems.itemPrice = price13.text.toString().trim()
            CartItems.iID = Firebase.auth.currentUser?.uid

            val db = FirebaseFirestore.getInstance().collection("CartItems")
            CartItems.itemId = db.document().id
            db.document(CartItems.itemId!!).set(CartItems)
        }

        val addToCart14 = findViewById<Button>(R.id.addToCart14)
        addToCart14.setOnClickListener {
            val intent = Intent(applicationContext, Cart::class.java)
            startActivity(intent)

            val CartItems = CartItems()
            CartItems.itemName = textView14.text.toString().trim()
            CartItems.itemPrice = price14.text.toString().trim()
            CartItems.iID = Firebase.auth.currentUser?.uid

            val db = FirebaseFirestore.getInstance().collection("CartItems")
            CartItems.itemId = db.document().id
            db.document(CartItems.itemId!!).set(CartItems)
        }

        val addToCart15 = findViewById<Button>(R.id.addToCart15)
        addToCart15.setOnClickListener {
            val intent = Intent(applicationContext, Cart::class.java)
            startActivity(intent)

            val CartItems = CartItems()
            CartItems.itemName = textView15.text.toString().trim()
            CartItems.itemPrice = price15.text.toString().trim()
            CartItems.iID = Firebase.auth.currentUser?.uid

            val db = FirebaseFirestore.getInstance().collection("CartItems")
            CartItems.itemId = db.document().id
            db.document(CartItems.itemId!!).set(CartItems)
        }

        val addToCart16 = findViewById<Button>(R.id.addToCart16)
        addToCart16.setOnClickListener {
            val intent = Intent(applicationContext, Cart::class.java)
            startActivity(intent)

            val CartItems = CartItems()
            CartItems.itemName = textView16.text.toString().trim()
            CartItems.itemPrice = price6.text.toString().trim()
            CartItems.iID = Firebase.auth.currentUser?.uid

            val db = FirebaseFirestore.getInstance().collection("CartItems")
            CartItems.itemId = db.document().id
            db.document(CartItems.itemId!!).set(CartItems)
        }
    }
}