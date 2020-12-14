package com.example.edecora

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.google.firebase.auth.ktx.auth
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.ktx.Firebase
import kotlinx.android.synthetic.main.activity_festival_main.*
import kotlinx.android.synthetic.main.activity_wedding_main.*

class WeddingMain : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_wedding_main)

        val addToCart19 = findViewById<Button>(R.id.addToCart19)
        addToCart19.setOnClickListener {
            val intent = Intent(applicationContext, Cart::class.java)
            startActivity(intent)

            val CartItems = CartItems()
            CartItems.itemName = textView18.text.toString().trim()
            CartItems.itemPrice = price19.text.toString().trim()
            CartItems.iID = Firebase.auth.currentUser?.uid

            val db = FirebaseFirestore.getInstance().collection("CartItems")
            CartItems.itemId = db.document().id
            db.document(CartItems.itemId!!).set(CartItems)
        }

        val addToCart20 = findViewById<Button>(R.id.addToCart20)
        addToCart20.setOnClickListener {
            val intent = Intent(applicationContext, Cart::class.java)
            startActivity(intent)

            val CartItems = CartItems()
            CartItems.itemName = textView19.text.toString().trim()
            CartItems.itemPrice = price20.text.toString().trim()
            CartItems.iID = Firebase.auth.currentUser?.uid

            val db = FirebaseFirestore.getInstance().collection("CartItems")
            CartItems.itemId = db.document().id
            db.document(CartItems.itemId!!).set(CartItems)
        }

        val addToCart21 = findViewById<Button>(R.id.addToCart21)
        addToCart21.setOnClickListener {
            val intent = Intent(applicationContext, Cart::class.java)
            startActivity(intent)

            val CartItems = CartItems()
            CartItems.itemName = textView20.text.toString().trim()
            CartItems.itemPrice = price5.text.toString().trim()
            CartItems.iID = Firebase.auth.currentUser?.uid

            val db = FirebaseFirestore.getInstance().collection("CartItems")
            CartItems.itemId = db.document().id
            db.document(CartItems.itemId!!).set(CartItems)
        }

        val addToCart22 = findViewById<Button>(R.id.addToCart22)
        addToCart22.setOnClickListener {
            val intent = Intent(applicationContext, Cart::class.java)
            startActivity(intent)

            val CartItems = CartItems()
            CartItems.itemName = textView21.text.toString().trim()
            CartItems.itemPrice = price11.text.toString().trim()
            CartItems.iID = Firebase.auth.currentUser?.uid

            val db = FirebaseFirestore.getInstance().collection("CartItems")
            CartItems.itemId = db.document().id
            db.document(CartItems.itemId!!).set(CartItems)
        }
    }
}