package com.example.authentication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.util.Patterns
import android.widget.Toast
import com.example.nika_guliashvili_davaleba.R
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.activity_main.*

class Registration : AppCompatActivity() {

    private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registration)
        auth = FirebaseAuth.getInstance()

        loginButton.setOnClickListener {
            LogInUser()

        }
    }
    private fun LogInUser(){
        if(email.text.toString().isEmpty()){
            email.error = "Please enter email"
            email.requestFocus()
            return
        }
        if(!Patterns.EMAIL_ADDRESS.matcher(email.text.toString()).matches()){
            email.error = "Please enter email"
            email.requestFocus()
            return
        }
        if(password.text.toString().isEmpty()) {
            password.error = "Please enter email"
            password.requestFocus()
            return
        }
        auth.createUserWithEmailAndPassword(email.text.toString(), password.text.toString())
            .addOnCompleteListener(this) { task ->
                if (task.isSuccessful) {
                    startActivity(Intent(this,ProfilePage::class.java))
                    finish()

                } else {
                    Toast.makeText(baseContext, "Registration failed. Try again after some time.",
                        Toast.LENGTH_SHORT).show()

                }

                // ...
            }

    }
}

