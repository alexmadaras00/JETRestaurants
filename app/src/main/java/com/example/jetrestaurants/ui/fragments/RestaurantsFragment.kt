package com.example.jetrestaurants.ui.fragments

import androidx.fragment.app.viewModels
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.jetrestaurants.R
import com.example.jetrestaurants.ui.viewmodel.RestaurantsViewModel

class RestaurantsFragment : Fragment() {

    companion object {
        fun newInstance() = RestaurantsFragment()
    }

    private val viewModel: RestaurantsViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // TODO: Use the ViewModel
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return inflater.inflate(R.layout.fragment_restaurants, container, false)
    }

}