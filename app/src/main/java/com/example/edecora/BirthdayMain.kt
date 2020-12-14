package com.example.edecora

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.method.ScrollingMovementMethod
import android.widget.Button
import android.widget.ScrollView
import android.widget.TextView
import com.google.firebase.auth.ktx.auth
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.ktx.Firebase
import kotlinx.android.synthetic.main.activity_birthday_main.*
import kotlinx.android.synthetic.main.activity_festival_main.*

class BirthdayMain : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_birthday_main)

        val addToCart = findViewById<Button>(R.id.addToCart)
        addToCart.setOnClickListener {
            val intent = Intent(applicationContext, Cart::class.java)
            startActivity(intent)

            val CartItems = CartItems()
            CartItems.itemName = textView3.text.toString().trim()
            CartItems.itemPrice = price1.text.toString().trim()
            CartItems.iID = Firebase.auth.currentUser?.uid

            val db = FirebaseFirestore.getInstance().collection("CartItems")
            CartItems.itemId = db.document().id
            db.document(CartItems.itemId!!).set(CartItems)
        }

        val addToCart2 = findViewById<Button>(R.id.addToCart2)
        addToCart2.setOnClickListener {
            val intent = Intent(applicationContext, Cart::class.java)
            startActivity(intent)

            val CartItems = CartItems()
            CartItems.itemName = textView4.text.toString().trim()
            CartItems.itemPrice = price2.text.toString().trim()
            CartItems.iID = Firebase.auth.currentUser?.uid

            val db = FirebaseFirestore.getInstance().collection("CartItems")
            CartItems.itemId = db.document().id
            db.document(CartItems.itemId!!).set(CartItems)
        }

        val addToCart3 = findViewById<Button>(R.id.addToCart3)
        addToCart3.setOnClickListener {
            val intent = Intent(applicationContext, Cart::class.java)
            startActivity(intent)

            val CartItems = CartItems()
            CartItems.itemName = textView6.text.toString().trim()
//            CartItems.itemPrice = price50.text.toString().trim()
            CartItems.iID = Firebase.auth.currentUser?.uid

            val db = FirebaseFirestore.getInstance().collection("CartItems")
            CartItems.itemId = db.document().id
            db.document(CartItems.itemId!!).set(CartItems)
        }

        val addToCart4 = findViewById<Button>(R.id.addToCart4)
        addToCart4.setOnClickListener {
            val intent = Intent(applicationContext, Cart::class.java)
            startActivity(intent)

            val CartItems = CartItems()
            CartItems.itemName = textView7.text.toString().trim()
            CartItems.itemPrice = price4.text.toString().trim()
            CartItems.iID = Firebase.auth.currentUser?.uid

            val db = FirebaseFirestore.getInstance().collection("CartItems")
            CartItems.itemId = db.document().id
            db.document(CartItems.itemId!!).set(CartItems)
        }

    }
}