package com.example.jpinfotech

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.example.jpinfotech.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
//    lateinit var Username : EditText
//    lateinit var password_toggle : EditText
//    lateinit var  loginbtn : Button


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityMainBinding.inflate(layoutInflater)

        setContentView(binding.root)


        binding.login.setOnClickListener(){
            binding.Username.text.toString()=="user" && binding.passwordToggle.text.toString() == "1234"
            Toast.makeText(this,"welcome",Toast.LENGTH_SHORT).show()
        }
    }
}