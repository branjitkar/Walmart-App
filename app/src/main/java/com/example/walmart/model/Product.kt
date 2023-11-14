package com.example.walmart.model

import java.io.Serializable

data class Product (val productName: String, val cost: String, val image: Int, val itemId: Long,
                    val desc: String) : Serializable