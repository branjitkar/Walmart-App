package com.example.walmart

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.example.walmart.model.User

class ShoppingCategoryActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_shopping_category)

        val txtWelcomeMsg = findViewById<TextView>(R.id.txtWelcomeMsg)

        //geting data from intent
        val rdata = intent.getSerializableExtra("USER_DATA")
        val user = rdata as User

        val welcomeMessage = "Welcome ${user.username}"
        txtWelcomeMsg.text = welcomeMessage

    }
}