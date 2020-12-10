package com.example.edecora

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.firebase.ui.firestore.FirestoreRecyclerAdapter
import com.firebase.ui.firestore.FirestoreRecyclerOptions
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.ktx.Firebase
import kotlinx.android.synthetic.main.profile_add.view.*


class MyProfile : AppCompatActivity() {

    //connect to database
    val db = FirebaseFirestore.getInstance()
    private var adapter: ProfileAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_my_profile)

        //set our recyclerView to use LinearLayout
        val profileRecyclerView: RecyclerView = findViewById<RecyclerView>(R.id.profileRecyclerView)

        profileRecyclerView.layoutManager = LinearLayoutManager(this)

        // query the db for address
//        val query = db.collection("UserInfo").orderBy("fname", Query.Direction.ASCENDING)

        val query = db.collection("UserInfo").whereEqualTo("uid", Firebase.auth.currentUser?.uid)

        // pass query results to RecyclerAdapter for display in RecyclerView
        val options = FirestoreRecyclerOptions.Builder<UserInfo>().setQuery(query, UserInfo::class.java).build()
        adapter = ProfileAdapter(options)
        profileRecyclerView.adapter = adapter

        val address = findViewById<Button>(R.id.address)
        address.setOnClickListener{
            val intent = Intent(applicationContext, MyInformation::class.java)
            startActivity(intent)
        }

        val homeBtn = findViewById<Button>(R.id.homeBtn)
        homeBtn.setOnClickListener{
            val intent = Intent(applicationContext, MainActivity::class.java)
            startActivity(intent)
        }

    }

    //tell adapter to start data for changes
    override fun onStart() {
        super.onStart()
        adapter!!.startListening()
    }

    override fun onStop() {
        super.onStop()
        if (adapter != null){
            adapter!!.stopListening()
        }
    }

    // create inner classes needed to bind the data to the recyclerview
    private inner class ProfileViewHolder internal constructor(private val view: View) : RecyclerView.ViewHolder(view) {}

    private inner class ProfileAdapter internal constructor(options: FirestoreRecyclerOptions<UserInfo>) :
        FirestoreRecyclerAdapter<UserInfo, ProfileViewHolder>(options) {
        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProfileViewHolder {

            val view = LayoutInflater.from(parent.context).inflate(R.layout.profile_add, parent, false)
            return ProfileViewHolder(view)
        }

        override fun onBindViewHolder(holder: ProfileViewHolder, position: Int, model: UserInfo) {
            //get the Name & email from database Firestore
            val mFirebaseAuth = FirebaseAuth.getInstance()
            val mFirebaseUser = mFirebaseAuth.currentUser

            holder.itemView.nameTextView.text = "Name: " + " " +mFirebaseUser!!.displayName
            holder.itemView.emailTextView.text = "Email: " + " " +mFirebaseUser!!.email
            holder.itemView.addL1TextView.text = "Address: " + " " +  model.addL1
            holder.itemView.cityTextView.text = "City: " +  " " + model.cityTextView
            holder.itemView.provinceTextView.text = "Province: " + " " + model.provinceTextView
            holder.itemView.postalCodeTextView.text = "Postal Code: " + " " + model.postalCodeTextView
            holder.itemView.countryTextView.text = "Country: " + " " + model.countryTextView
        }
    }
}


