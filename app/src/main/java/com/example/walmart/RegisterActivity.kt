package com.example.walmart

import android.app.Activity
import android.net.Uri
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.walmart.model.User

class RegisterActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_create_account)

        val btnSignup = findViewById<Button>(R.id.btnSignup)
        val etSignupFirstname = findViewById<EditText>(R.id.etSignupFirstname)
        val etSignupLastname = findViewById<EditText>(R.id.etSignupLastname)
        val etSignupEmail = findViewById<EditText>(R.id.etSignupEmail)
        val etSignupPassword = findViewById<EditText>(R.id.etSignupPassword)

        btnSignup.setOnClickListener {
            val firstname = etSignupFirstname.text.toString()
            val lastname = etSignupLastname.text.toString()
            val email = etSignupEmail.text.toString()
            val password = etSignupPassword.text.toString()

            if(firstname.isNullOrBlank() || lastname.isNullOrBlank() || email.isNullOrBlank() || password.isNullOrBlank()){
                Toast.makeText(this, "* required fields cannot be blank", Toast.LENGTH_LONG).show()
                return@setOnClickListener
            }

            val newUser = User(firstname, lastname, email, password)
            val rintent = intent
            rintent.putExtra("NEW_USER", newUser)
            setResult(Activity.RESULT_OK, rintent)
            finish()
        }
    }
}