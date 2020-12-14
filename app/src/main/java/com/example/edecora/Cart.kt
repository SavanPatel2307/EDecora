package com.example.edecora

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.method.ScrollingMovementMethod
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.firebase.ui.firestore.FirestoreRecyclerAdapter
import com.firebase.ui.firestore.FirestoreRecyclerOptions
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.ktx.Firebase
import kotlinx.android.synthetic.main.activity_cart.*
import kotlinx.android.synthetic.main.cart_items.view.*
import kotlinx.android.synthetic.main.profile_add.view.*

class Cart : AppCompatActivity() {

    val db = FirebaseFirestore.getInstance()
    private var adapter: CartAdapter? = null
    var finalTotal = 0.00

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cart)

        val cartRecyclerView: RecyclerView = findViewById<RecyclerView>(R.id.cartRecyclerView)

        cartRecyclerView.layoutManager = LinearLayoutManager(this)

        val query = db.collection("CartItems").whereEqualTo("iid", Firebase.auth.currentUser?.uid)

        val options = FirestoreRecyclerOptions.Builder<CartItems>().setQuery(query, CartItems::class.java).build()
        adapter = CartAdapter(options)
        cartRecyclerView.adapter = adapter
    }
        override fun onStart() {
            super.onStart()
            adapter!!.startListening()
        }

        override fun onStop() {
            super.onStop()
            if (adapter != null) {
                adapter!!.stopListening()
            }

    }

    private inner class CartViewHolder internal constructor(private val view: View) : RecyclerView.ViewHolder(view) {}

    private inner class CartAdapter internal constructor(options: FirestoreRecyclerOptions<CartItems>) :
            FirestoreRecyclerAdapter<CartItems, CartViewHolder>(options) {
        override fun onCreateViewHolder(
                parent: ViewGroup,
                viewType: Int): CartViewHolder {

            val view = LayoutInflater.from(parent.context).inflate(R.layout.cart_items, parent, false)
            return CartViewHolder(view)
        }


        override fun onBindViewHolder(holder: CartViewHolder, position: Int, model: CartItems) {
            holder.itemView.cartName1.text = "Item:" + " " + model.itemName
            holder.itemView.cartPrice1.text = "Price:" + " " + model.itemPrice


            var itemPrice = model.itemPrice?.toFloat()

            if (itemPrice != null && finalTotal != null) {
                finalTotal += itemPrice
                finalTotal = Math.round(finalTotal * 100.0) / 100.0
                cartTotal.text = "$" + finalTotal.toString()
                adapter!!.startListening()
            }

            holder.itemView.cartDelete.setOnClickListener{
                val cartItem = db.collection("CartItems").document("${model.itemId}")
                if (cartItem != null){
                    cartItem.delete()
                    finalTotal -= itemPrice!!
                    finalTotal = Math.round(finalTotal * 100.0) / 100.0
                    cartTotal.text = finalTotal.toString()
                    adapter!!.startListening()
                }
                else throw NullPointerException()
            }


            btnCheckout.setOnClickListener{
                val intent = Intent(applicationContext, CheckOut::class.java)


                intent.putExtra("FinalTotal", finalTotal.toString())
                startActivity(intent)
            }
        }

        

    }
}