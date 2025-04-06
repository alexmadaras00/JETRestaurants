package com.example.jetrestaurants.ui.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import androidx.lifecycle.viewModelScope
import com.example.jetrestaurants.data.entity.Restaurant
import com.example.jetrestaurants.data.repository.RestaurantRepositoryImpl
import com.example.jetrestaurants.retrofit.RetrofitInstance
import kotlinx.coroutines.Dispatchers

class RestaurantsViewModel : ViewModel() {

    fun getRestaurants(): LiveData<List<Restaurant>> =
        liveData(Dispatchers.IO + viewModelScope.coroutineContext) {
            try {
                val postCode = "EC4M7RF"
                val response = RetrofitInstance.api.getRestaurants(postCode)
                println("Initial response Retrofit is: $response")
                val restaurantsRepository = RestaurantRepositoryImpl()
                restaurantsRepository.parseResponse(response).collect{
                    queriedResponse -> restaurantsRepository.filterData(queriedResponse).collect { filteredResponse ->
                        println(filteredResponse)
                    emit(filteredResponse) // Emit only the first 10 restaurants
                }}
            } catch (e: Exception) {
                emit(emptyList())
                println("Initial response Retrofit is: $e")
            }
        }
}
