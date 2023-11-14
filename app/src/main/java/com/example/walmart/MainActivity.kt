package com.example.walmart

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import com.example.walmart.model.Product
import com.example.walmart.model.User

class MainActivity : AppCompatActivity() {
    val users = mutableListOf<User>(
        User("Bipul", "Ranjitkar", "br@test.com", "pass"),
        User("Harry", "Potter", "hp@test.com", "pass"),
        User("Ron", "Weasley", "rw@test.com", "pass"),
        User("Hermione", "Grainger", "hg@test.com", "pass"),
        User("Bruce", "Wayne", "bw@test.com", "pass")
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnSignin = findViewById<Button>(R.id.btnSignin)
        val btnCreateAccount = findViewById<Button>(R.id.btnCreateAccount)
        val etEmail = findViewById<EditText>(R.id.etEmail)
        val etPassword = findViewById<EditText>(R.id.etPassword)
        val txtForgotPassword = findViewById<TextView>(R.id.txtForgotPassword)

        var resultContracts = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) {
            result ->
            run {
                if (result.resultCode == RESULT_OK) {
                    val newUser = result.data?.extras?.getSerializable("NEW_USER")
                    users.add(newUser as User)
                    Toast.makeText(this, "Account created successfully", Toast.LENGTH_LONG).show()
                }
            }
        }

        btnSignin.setOnClickListener {
            val email = etEmail.text.toString()
            val password = etPassword.text.toString()

            //validating user
            if(email.isNullOrBlank() || password.isNullOrBlank()){
                Toast.makeText(this, "Email and password cannot be empty", Toast.LENGTH_LONG).show()
                return@setOnClickListener
            }
            val selectedUser = users.find{user ->
                user.username.equals(email) && user.password.equals(password)
            }
            if(selectedUser == null) {
                Toast.makeText(this, "Invalid email or password", Toast.LENGTH_LONG).show()
                return@setOnClickListener
            }

            //opening intent
            val intent = Intent(this, ShoppingCategoryActivity::class.java)
            intent.putExtra("USER_DATA", selectedUser)
            startActivity(intent)
        }

        btnCreateAccount.setOnClickListener {
            val intent = Intent(this, RegisterActivity::class.java)
            resultContracts.launch(intent)
        }

        txtForgotPassword.setOnClickListener {
            val email = etEmail.text.toString()
            val selectedUser = users.find { user -> user.username == email }

            if(selectedUser == null){
                Toast.makeText(this, "Invalid email", Toast.LENGTH_LONG).show()
                return@setOnClickListener
            }

            //invoking implicit intent
            val intent = Intent(Intent.ACTION_SEND)
            intent.type = "text/plain"
            intent.putExtra(Intent.EXTRA_SUBJECT, "Password Recovery")
            intent.putExtra(Intent.EXTRA_TEXT, "Your password is: ${selectedUser.password}")
            intent.putExtra(Intent.EXTRA_EMAIL, arrayOf(selectedUser.username))

            startActivity(Intent.createChooser(intent, "Send Email"))
        }
    }
}