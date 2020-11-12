package com.example.edecora

import android.content.Intent
import android.graphics.drawable.Icon
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton
import android.view.Menu
import com.google.firebase.auth.FirebaseAuth


@Suppress("UNREACHABLE_CODE")
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val BtnProfile = findViewById<ImageButton>(R.id.BtnProfile)

        //create the intent to send the MyInformation activity via Profile button
        BtnProfile.setOnClickListener{
            val intent = Intent(applicationContext, MyInformation::class.java)
            startActivity(intent)
        }

        //logout button
        val BtnLogout = findViewById<ImageButton>(R.id.BtnLogout)

        BtnLogout.setOnClickListener{
            FirebaseAuth.getInstance().signOut()
            finish()

            //get the sign in page after logout
            val intent = Intent(applicationContext, SignInActivity::class.java)
            startActivity(intent)
        }

    }
//    override fun onCreateOptionsMenu(menu: Menu): Boolean {
//        val inflater = menuInflater
//        inflater.inflate(R.menu.menu_main, menu)
//        return super.onCreateOptionsMenu(menu)
//
//        val ProfileBtn = findViewById<Button>(R.id.ProfileBtn)
////
//        ProfileBtn.setOnClickListener {
//            val intent = Intent(applicationContext, MyInformation::class.java)
//            startActivity(intent)
//        }
}