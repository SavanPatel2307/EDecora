package com.example.edecora

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.firebase.ui.firestore.FirestoreRecyclerAdapter
import com.firebase.ui.firestore.FirestoreRecyclerOptions
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.Query
import kotlinx.android.synthetic.main.profile_add.view.*
import kotlinx.android.synthetic.main.profile_add.*

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
        val query = db.collection("UserInfo").orderBy("name", Query.Direction.ASCENDING)

        // pass query results to RecyclerAdapter for display in RecyclerView
        val options = FirestoreRecyclerOptions.Builder<UserInfo>().setQuery(query, UserInfo::class.java).build()
        adapter = ProfileAdapter(options)
        profileRecyclerView.adapter = adapter

        val HomeBtn = findViewById<Button>(R.id.HomeBtn)
        HomeBtn.setOnClickListener{
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

            val profileTextView = findViewById<TextView>(R.id.profileTextView)
            val lastNameTextView = findViewById<TextView>(R.id.lastNameTextView)

            //populate the address
            holder.itemView.profileTextView.text = model.addL1
            holder.itemView.lastNameTextView.text = model.addL2
        }
    }
}
