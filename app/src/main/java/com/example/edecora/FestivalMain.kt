package com.example.edecora

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.google.firebase.auth.ktx.auth
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.ktx.Firebase
import kotlinx.android.synthetic.main.activity_festival_main.*

class FestivalMain : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_festival_main)

        val addToCart25 = findViewById<Button>(R.id.addToCart25)
        addToCart25.setOnClickListener{
            val intent = Intent(applicationContext, Cart::class.java)
            startActivity(intent)

            val CartItems = CartItems()
            CartItems.itemName = textView23.text.toString().trim()
            CartItems.itemPrice = price25.text.toString().trim()
            CartItems.iID = Firebase.auth.currentUser?.uid

            val db = FirebaseFirestore.getInstance().collection("CartItems")
            CartItems.itemId = db.document().id
            db.document(CartItems.itemId!!).set(CartItems)
        }

        val addToCart26 = findViewById<Button>(R.id.addToCart26)
        addToCart26.setOnClickListener {
            val intent = Intent(applicationContext, Cart::class.java)
            startActivity(intent)

            val CartItems = CartItems()
            CartItems.itemName = textView24.text.toString().trim()
            CartItems.itemPrice = price26.text.toString().trim()
            CartItems.iID = Firebase.auth.currentUser?.uid

            val db = FirebaseFirestore.getInstance().collection("CartItems")
            CartItems.itemId = db.document().id
            db.document(CartItems.itemId!!).set(CartItems)
        }

        val addToCart27 = findViewById<Button>(R.id.addToCart27)
        addToCart27.setOnClickListener {
            val intent = Intent(applicationContext, Cart::class.java)
            startActivity(intent)

            val CartItems = CartItems()
            CartItems.itemName = textView25.text.toString().trim()
            CartItems.itemPrice = price28.text.toString().trim()
            CartItems.iID = Firebase.auth.currentUser?.uid

            val db = FirebaseFirestore.getInstance().collection("CartItems")
            CartItems.itemId = db.document().id
            db.document(CartItems.itemId!!).set(CartItems)
        }

        val addToCart28 = findViewById<Button>(R.id.addToCart28)
        addToCart28.setOnClickListener {
            val intent = Intent(applicationContext, Cart::class.java)
            startActivity(intent)

            val CartItems = CartItems()
            CartItems.itemName = textView26.text.toString().trim()
            CartItems.itemPrice = price50.text.toString().trim()
            CartItems.iID = Firebase.auth.currentUser?.uid

            val db = FirebaseFirestore.getInstance().collection("CartItems")
            CartItems.itemId = db.document().id
            db.document(CartItems.itemId!!).set(CartItems)
        }
    }
}