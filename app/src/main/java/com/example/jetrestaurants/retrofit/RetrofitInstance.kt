package com.example.jetrestaurants.retrofit

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitInstance {
    val api: RestaurantsAPI by lazy{
        Retrofit.Builder().baseUrl("https://uk.api.just-eat.io/discovery/uk/restaurants/enriched/bypostcode/EC4M7RF")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(RestaurantsAPI::class.java)
    }
}