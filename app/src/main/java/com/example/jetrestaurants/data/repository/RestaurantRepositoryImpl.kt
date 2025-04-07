package com.example.jetrestaurants.data.repository

import com.example.jetrestaurants.data.entity.JETRestaurantsResponse
import com.example.jetrestaurants.data.entity.Restaurant
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow


import retrofit2.Response


class RestaurantRepositoryImpl : RestaurantRepository {

    override suspend fun parseResponse(initialResponse: Response<JETRestaurantsResponse>): Flow<JETRestaurantsResponse> =
        flow {
            val responseBody = initialResponse.body()
            if(responseBody!=null){
                emit(responseBody)
            }
            else {
                println("Response body is null: $responseBody")
                emit(JETRestaurantsResponse(emptyList()))
            }
        }

    override suspend fun filterData(response: JETRestaurantsResponse?): Flow<List<Restaurant>> =
        flow {
            try {
                val restaurantList = response?.restaurants
                restaurantList?.take(10)?.let { emit(it) }
            } catch (e: Exception) {
                emit(emptyList())
            }
        }


}