package com.example.jetrestaurants.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.jetrestaurants.data.entity.Restaurant
import com.example.jetrestaurants.databinding.ItemRestaurantBinding


class AdapterRestaurant() : RecyclerView.Adapter<AdapterRestaurant.ViewHolder>() {
    private var restaurants = ArrayList<Restaurant>()

    inner class ViewHolder(private val binding: ItemRestaurantBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(item: Restaurant) {
            binding.apply {
                binding.item = item
                binding.executePendingBindings()
            }
        }

    }
    fun setDataSource(items: List<Restaurant>) {
        this.apply {
            if (restaurants.isNotEmpty()) {
                restaurants.clear()
            }
            restaurants.addAll(items)
            notifyDataSetChanged()
        }
}


override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
    val inflater = LayoutInflater.from(parent.context)
    val binding = ItemRestaurantBinding.inflate(inflater, parent, false)
    return ViewHolder(binding)
}

override fun getItemCount(): Int {
    return restaurants.size
}

override fun onBindViewHolder(holder: ViewHolder, position: Int) {
    holder.bind(restaurants[position])

}
}