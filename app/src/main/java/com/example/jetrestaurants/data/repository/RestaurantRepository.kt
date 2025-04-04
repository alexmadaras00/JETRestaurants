package com.example.jetrestaurants.data.repository

import com.example.jetrestaurants.data.entity.Restaurant
import retrofit2.Response

interface RestaurantRepository {
    fun parseResponse(initialResponse: Response<Map<String, Any>>): JETRestaurantsResponse
    fun filterData(response: JETRestaurantsResponse): List<Restaurant>
}