package com.example.jetrestaurants

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.lifecycleScope
import androidx.navigation.NavController
import androidx.navigation.NavDestination
import androidx.navigation.NavHost
import androidx.navigation.fragment.NavHostFragment
import com.example.jetrestaurants.databinding.ActivityMainBinding
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch


class MainActivity : AppCompatActivity() {
    private lateinit var job: Job
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        job = lifecycleScope.launch(Dispatchers.Main) {
        }

        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.flMain)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        setContentView(view)
    }

    override fun onStart() {
        super.onStart()
        binding.apply{
            val navHostFragment = navHostFragment.getFragment<NavHostFragment>()
            val navController = navHostFragment.navController
            navController.navigate(R.id.splashFragment)
        }
    }

}