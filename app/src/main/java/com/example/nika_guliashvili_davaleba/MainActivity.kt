package com.example.authentication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.nika_guliashvili_davaleba.R
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        init()
    }
    private fun init() {
        loginButton.setOnClickListener {
            if (email.text.isNotEmpty() && password.text.isNotEmpty()) {
                Toast.makeText(this, "Log In is success", Toast.LENGTH_SHORT).show()
                val intent = Intent(this, ProfilePage::class.java)
                startActivity(intent)
            }else{
                Toast.makeText(this, "Please fill in fields", Toast.LENGTH_SHORT).show()
            }


        }
    }
}
