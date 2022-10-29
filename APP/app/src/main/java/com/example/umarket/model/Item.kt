package com.example.umarket.model
import com.squareup.moshi.Json

data class Item (@Json(name = "id") val id: Int, @Json(name = "title") val title: String,@Json(name = "price") val price: Double, @Json(name = "description") val description: String, @Json(name = "category") val category: String){
    val imageUrlFront: String get() = "https://dummyjson.com/image/i/products/$id/1.jpg"
    val imageUrlBack: String get() = "https://dummyjson.com/image/i/products/$id/2.jpg"
    val imageUrlShinnyFront: String get() = "https://dummyjson.com/image/i/products/$id/3.jpg"
    val imageUrlShinnyBack: String get() = "https://dummyjson.com/image/i/products/$id/4.jpg"
}

data class ProductResponse(@Json(name="products") val result : List<Item>)