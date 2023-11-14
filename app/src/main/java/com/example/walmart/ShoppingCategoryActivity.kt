package com.example.walmart

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import android.widget.Toast
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
    fun categoryClicked(view: View){
        when (view.id) {
            R.id.imgElectronics -> {
//                Toast.makeText(this, "You chose Electronics category", Toast.LENGTH_LONG).show()
                startActivity(Intent(this, ElectronicsCategoryActivity::class.java))
            }
            R.id.imgClothing -> {
                Toast.makeText(this, "You chose Clothing category", Toast.LENGTH_LONG).show()
            }
            R.id.imgBeauty -> {
                Toast.makeText(this, "You chose Beauty category", Toast.LENGTH_LONG).show()
            }
            R.id.imgFood -> {
                Toast.makeText(this, "You chose Food category", Toast.LENGTH_LONG).show()
            }
        }
    }
}