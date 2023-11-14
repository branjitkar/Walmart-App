package com.example.walmart

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.walmart.adapter.CategoryAdapter
import com.example.walmart.model.Product

class ElectronicsCategoryActivity : AppCompatActivity() {
    private val productList = mutableListOf<Product>(
        Product("iPhone \" Phone", "$1099", R.drawable.iphone, 1236L, "Apple iPhone 14 Pro, 256GB, Space Black "),
        Product("Macbook\" Laptop", "$1599", R.drawable.macbook, 123L, "Apple 2023 MacBook Air Laptop with M2 chip: 15.3-inch Liquid Retina Display, 8GB Unified Memory, 256GB SSD Storage, 1080p FaceTime HD Camera, Touch ID. Works with iPhone/iPad; Silver"),
        Product("Apple Watch\" Smartwatch", "$399", R.drawable.applewatch, 1234L, "Apple Watch Series 8 [GPS 41mm] Smart Watch w/Starlight Aluminum Case with Starlight Sport Band - M/L. Fitness Tracker, Blood Oxygen & ECG Apps, Always-On Retina Display, Water Resistant"),
        Product("iPad\" Tablet", "$499", R.drawable.ipad, 1235L, "Apple iPad (9th Generation): with A13 Bionic chip, 10.2-inch Retina Display, 64GB, Wi-Fi, 12MP front/8MP Back Camera, Touch ID, All-Day Battery Life – Silver")
    )
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_electronics_category)

        val rvProductList = findViewById<RecyclerView>(R.id.rvProductList)
        rvProductList.layoutManager = LinearLayoutManager(this)
        val adapter = CategoryAdapter(this,productList )
        rvProductList.adapter = adapter
    }
}