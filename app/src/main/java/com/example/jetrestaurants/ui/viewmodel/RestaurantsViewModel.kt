package com.example.jetrestaurants.ui.viewmodel

import androidx.lifecycle.ViewModel
import com.example.jetrestaurants.data.entity.Restaurant
import com.example.jetrestaurants.data.repository.JETRestaurantsResponse
import com.example.jetrestaurants.data.repository.RestaurantRepositoryImpl
import com.example.jetrestaurants.retrofit.RetrofitInstance

class RestaurantsViewModel : ViewModel() {
    suspend fun getResponse(): List<Restaurant>{
        val response = RetrofitInstance.api.getRestaurants()
        val restaurantsRepository= RestaurantRepositoryImpl()
        val queriedResponse = restaurantsRepository.parseResponse(response)
        val filteredResponse = restaurantsRepository.filterData(queriedResponse)
        return filteredResponse
    }

}