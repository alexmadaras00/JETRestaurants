package com.example.jetrestaurants.retrofit

import com.example.jetrestaurants.data.entity.Restaurant
import com.example.jetrestaurants.data.repository.JETRestaurantsResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface RestaurantsAPI {

    @GET("discovery/uk/restaurants/enriched/bypostcode/{postcode}")
    suspend fun getRestaurants(
        @Path("postcode") postcode: String
    ): Response<JETRestaurantsResponse>

}