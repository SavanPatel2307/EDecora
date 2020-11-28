package com.example.edecora

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.widget.Button
import android.widget.ImageButton
import android.widget.TextView
import android.widget.Toast
import com.google.firebase.firestore.FirebaseFirestore

class MyInformation : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_my_information)

        //creating variable for the each items
        val firstName = findViewById<TextView>(R.id.firstName)
        val lastName = findViewById<TextView>(R.id.lastName)
        val email = findViewById<TextView>(R.id.email)
        val addLine1 = findViewById<TextView>(R.id.addLine1)
        val addLine2 = findViewById<TextView>(R.id.addLine2)
        val city = findViewById<TextView>(R.id.city)
        val province = findViewById<TextView>(R.id.province)
        val postalCode = findViewById<TextView>(R.id.postalCode)
        val country = findViewById<TextView>(R.id.country)
        val InfoSubmitBtn = findViewById<Button>(R.id.InfoSubmitBtn)

        //creating onclick listner for submit button
        InfoSubmitBtn.setOnClickListener {

        //creating if else method for accurate sign in details

        //validate inputs
        if ((TextUtils.isEmpty(firstName.text)) || (TextUtils.isEmpty(lastName.text)) || (TextUtils.isEmpty(email.text)) || (TextUtils.isEmpty(addLine1.text)) || (TextUtils.isEmpty(city.text)) || (TextUtils.isEmpty(province.text)) || (TextUtils.isEmpty(postalCode.text)) || (TextUtils.isEmpty(country.text))) {

            Toast.makeText(this, "Please Fill All Details", Toast.LENGTH_LONG).show()
        }
        else{
            val intent = Intent(applicationContext, MyProfile::class.java)
            startActivity(intent)


                //Add all the inputs UserInfo class
                val userInfo = UserInfo()

                userInfo.fName = firstName.text.toString().trim()
                userInfo.lName = lastName.text.toString().trim()
                userInfo.emailTextView = email.text.toString().trim()
                userInfo.addL1 = addLine1.text.toString().trim()
                userInfo.addL2 = addLine2.text.toString().trim()
                userInfo.cityTextView = city.text.toString().trim()
                userInfo.provinceTextView = province.text.toString().trim()
                userInfo.postalCodeTextView = postalCode.text.toString().trim()
                userInfo.countryTextView = country.text.toString().trim()

                //connect to firebase database
                val db = FirebaseFirestore.getInstance().collection("UserInfo")
                userInfo.id = db.document().id
                db.document(userInfo.id!!).set(userInfo)

                //clear fields
                firstName.setText("")
                lastName.setText("")
                email.setText("")
                addLine1.setText("")
                addLine2.setText("")
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