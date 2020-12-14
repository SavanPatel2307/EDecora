package com.example.edecora

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_check_out.*

class CheckOut : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_check_out)

        var checkoutTotal = intent.getStringExtra("FinalTotal")
        totalCheckout.text = "Your Final Total :$ ${checkoutTotal}"
//        checkoutTotal = (Math.round(checkoutTotal * 100.0) / 100.0).toString()

        homeCheckout.setOnClickListener{
            val intent = Intent(applicationContext, MainActivity::class.java)
            startActivity(intent)
        }
    }
}