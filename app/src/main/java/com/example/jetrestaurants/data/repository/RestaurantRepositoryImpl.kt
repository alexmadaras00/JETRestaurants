package com.example.jetrestaurants.data.repository

import com.example.jetrestaurants.data.entity.Restaurant
import com.google.gson.Gson
import org.json.JSONObject
import retrofit2.Response
import java.util.ArrayList

class RestaurantRepositoryImpl: RestaurantRepository {

    override fun parseResponse(initialResponse: Response<Map<String, Any>>): JETRestaurantsResponse {
        val jsonString = initialResponse.body().toString()
        val jsonObject = JSONObject(jsonString)
        val restaurantsJSON = jsonObject.getJSONArray("restaurants")
        val newJSONObject = JSONObject()
        newJSONObject.put("restaurants",restaurantsJSON)
        val gson = Gson()
        val restaurantsResponse = gson.fromJson(newJSONObject.toString(),JETRestaurantsResponse::class.java)
        restaurantsResponse.restaurants.forEach{
            restaurant -> println("Restaurant ID: ${restaurant.id}, called ${restaurant.name}, located at: ${restaurant.address}, having the rating ${restaurant.rating}")
        }
        return restaurantsResponse
    }

    override fun filterData(response: JETRestaurantsResponse): List<Restaurant> {
        val restaurantList = ArrayList<Restaurant>()
        return restaurantList
    }
}