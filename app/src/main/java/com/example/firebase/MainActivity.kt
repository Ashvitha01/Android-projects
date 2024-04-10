package com.example.firebase

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.ContactsContract.CommonDataKinds.Email
import android.widget.Toast
import com.example.firebase.databinding.ActivityMainBinding
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var database: DatabaseReference
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.Login.setOnClickListener {
            val Name = binding.name.text.toString()
            val  Email = binding.email.text.toString()
            val  Phonenumber = binding.phonenumber.text.toString()
            val Username = binding.username.text.toString()

            database = FirebaseDatabase.getInstance().getReference("Users")
            val User = Users(Name,Email,Phonenumber,Username)
            database.child(Username).setValue(User).addOnSuccessListener {

                binding.name.text.clear()
                binding.email.text.clear()
                binding.phonenumber.text.clear()
                binding.username.text.clear()

                Toast.makeText(this,"Successfully Saved",Toast.LENGTH_SHORT).show()
            }.addOnFailureListener {
                Toast.makeText(this,"Failed",Toast.LENGTH_SHORT).show()
            }
        }
    }
}