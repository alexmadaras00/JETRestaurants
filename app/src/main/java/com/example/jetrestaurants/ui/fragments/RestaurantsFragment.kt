package com.example.jetrestaurants.ui.fragments

import androidx.fragment.app.viewModels
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.jetrestaurants.databinding.FragmentRestaurantsBinding
import com.example.jetrestaurants.ui.adapter.RestaurantsAdapter
import com.example.jetrestaurants.ui.viewmodel.RestaurantsViewModel

class RestaurantsFragment : Fragment() {

    private var _binding: FragmentRestaurantsBinding? = null
    private val binding get()  = _binding

    private val viewModel: RestaurantsViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentRestaurantsBinding.inflate(inflater)
        binding?.executePendingBindings()
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding?.apply {
            val recyclerViewRestaurants = rvRestaurants
            val adapterRestaurants = RestaurantsAdapter()
            viewModel.getRestaurants().observe(viewLifecycleOwner){
                restaurants -> println("Restaurants are: $restaurants")
            }
        }
    }

}