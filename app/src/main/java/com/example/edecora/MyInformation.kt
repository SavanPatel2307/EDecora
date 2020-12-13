package com.example.edecora

import android.content.Intent
import android.os.Bundle
import android.text.TextUtils
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.ktx.Firebase


class MyInformation : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_my_information)

        //creating variable for the each items
        val addLine1 = findViewById<TextView>(R.id.addLine1)
        val city = findViewById<TextView>(R.id.city)
        val province = findViewById<TextView>(R.id.province)
        val postalCode = findViewById<TextView>(R.id.postalCode)
        val country = findViewById<TextView>(R.id.country)
        val InfoSubmitBtn = findViewById<Button>(R.id.InfoSubmitBtn)

        //creating onclick listner for submit button
        InfoSubmitBtn.setOnClickListener {

            //creating if else method for accurate sign in details

            //validate inputs
            if ( (TextUtils.isEmpty(addLine1.text)) || (TextUtils.isEmpty(city.text)) || (TextUtils.isEmpty(province.text)) || (TextUtils.isEmpty(postalCode.text)) || (TextUtils.isEmpty(country.text))) {

                Toast.makeText(this, "Please Fill All Details", Toast.LENGTH_LONG).show()
            }
            else{
                val intent = Intent(applicationContext, MyProfile::class.java)
                startActivity(intent)

                //Add all the inputs UserInfo class
                val userInfo = UserInfo()

                userInfo.addL1 = addLine1.text.toString().trim()
                userInfo.cityTextView = city.text.toString().trim()
                userInfo.provinceTextView = province.text.toString().trim()
                userInfo.postalCodeTextView = postalCode.text.toString().trim()
                userInfo.countryTextView = country.text.toString().trim()
                userInfo.uID = Firebase.auth.currentUser!!.uid.trim()

                //connect to firebase database
                val db = FirebaseFirestore.getInstance().collection("UserInfo")
                userInfo.id = db.document().id
                db.document(userInfo.id!!).set(userInfo)

                addLine1.setText("")
                city.setText("")
                province.setText("")
                postalCode.setText("")
                country.setText("")

                //toast message when user hot submit button
                Toast.makeText(this, "Information Added", Toast.LENGTH_LONG).show()
            }
        }
    }
}