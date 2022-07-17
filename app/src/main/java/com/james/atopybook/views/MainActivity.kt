package com.james.atopybook.views

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatDelegate
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.james.atopybook.R
import com.james.atopybook.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private lateinit var binding:ActivityMainBinding
    private lateinit var navController: NavController
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setUpNav()
    }

    private fun setUpNav() {
        navController = findNavController(R.id.main_fragment_container)
        navController.addOnDestinationChangedListener { _, destination, _ ->
            when (destination.id) {
                R.id.recordFragment -> showBottomNav()
                else -> hideBottomNav()
            }
        }
        binding.bottomNavigationView.setupWithNavController(navController)
    }

    private fun showBottomNav(){
        binding.bottomNavigationView.visibility = View.VISIBLE
    }

    private fun hideBottomNav(){
        binding.bottomNavigationView.visibility = View.GONE
    }
}