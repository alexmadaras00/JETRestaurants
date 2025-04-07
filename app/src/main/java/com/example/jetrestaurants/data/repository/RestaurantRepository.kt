package com.example.jetrestaurants.data.repository

import com.example.jetrestaurants.data.entity.JETRestaurantsResponse
import com.example.jetrestaurants.data.entity.Restaurant
import kotlinx.coroutines.flow.Flow
import retrofit2.Response

interface RestaurantRepository {
    suspend fun parseResponse(initialResponse: Response<JETRestaurantsResponse>): Flow<JETRestaurantsResponse>
    suspend fun filterData(response: JETRestaurantsResponse?): Flow<List<Restaurant>>
}