package com.example.jetrestaurants.retrofit

import com.example.jetrestaurants.data.entity.Restaurant
import retrofit2.Response
import retrofit2.http.GET

interface RestaurantsAPI {

    @GET("/restaurants")
    suspend fun getRestaurants(): Response<Map<String,Any>>
}