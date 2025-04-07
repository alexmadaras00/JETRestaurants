package com.example.jetrestaurants.data.entity

data class Restaurant(var id: String, var name: String, var address: Address, var rating: Rating, var cuisines: List<Cuisine>){

    fun getCuisineNames(): String {
            return cuisines?.joinToString(", ") { it.name } ?: "No cuisines"
        }
}
