package com.example.mcdonalds.model

data class MenuItem(
    val id: Long,
    val name: String,
    val description: String,
    val image: String,
    val price: Double,
    val categoryId: Long,
    //
    var quantity: Int = 0
)