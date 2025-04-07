package com.example.jetrestaurants.ui.fragments

import androidx.fragment.app.viewModels
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.jetrestaurants.data.entity.Restaurant
import com.example.jetrestaurants.databinding.FragmentRestaurantsBinding
import com.example.jetrestaurants.ui.adapter.AdapterRestaurant
import com.example.jetrestaurants.ui.adapter.IOnClickListener
import com.example.jetrestaurants.ui.viewmodel.RestaurantsViewModel
import retrofit2.Response

class RestaurantsFragment : Fragment() {

    private var _binding: FragmentRestaurantsBinding? = null
    private val binding get() = _binding

    private val viewModel: RestaurantsViewModel by viewModels()


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
            viewModel.getRestaurants().observe(viewLifecycleOwner) { restaurants ->
                restaurants?.let {
                    binding.apply {
                        println("Restaurants are here: $restaurants")
                        val recyclerViewRestaurants = rvRestaurants
                        val adapterRestaurant = AdapterRestaurant()
                        adapterRestaurant.setDataSource(restaurants)
                        recyclerViewRestaurants.adapter = adapterRestaurant
                        recyclerViewRestaurants.layoutManager = LinearLayoutManager(context)
                        recyclerViewRestaurants.setHasFixedSize(true)
                        recyclerViewRestaurants.isScrollContainer = true
                        recyclerViewRestaurants.hasNestedScrollingParent()
                    }
                }
            }
        }
    }
}