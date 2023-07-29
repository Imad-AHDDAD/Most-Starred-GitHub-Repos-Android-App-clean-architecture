package com.a7dev.moststarredgithubrepos_cleanarchitecture

import android.content.Context
import android.content.SharedPreferences
import android.content.pm.PackageManager
import android.content.res.Configuration
import android.content.res.Resources
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.app.AppCompatDelegate
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.a7dev.moststarredgithubrepos_cleanarchitecture.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint
import java.util.*

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var navController: NavController
    private lateinit var appBarConfiguration: AppBarConfiguration

    override fun onCreate(savedInstanceState: Bundle?) {
        loadPreferences()
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setupNavigation()
    }

    /**
     * setupNavigation: sets up bottom navigation menu
     * and top toolbar
     *
     */
    private fun setupNavigation() {
        navController = findNavController(R.id.navController)
        appBarConfiguration = AppBarConfiguration(setOf(R.id.reposFragment, R.id.settingsFragment2))
        binding.navigationView.setupWithNavController(navController)
        setSupportActionBar(binding.myToolbar)
        setupActionBarWithNavController(navController, appBarConfiguration)
    }
    private fun loadPreferences(){
        val sharedPreferences: SharedPreferences? = getSharedPreferences("sharedPref", Context.MODE_PRIVATE)
        val language = sharedPreferences?.getString("language", "en")
        val theme = sharedPreferences?.getString("mode", "light")
        if(language.equals("fr")) setLocale(this, language)
        applyDisplayMode(theme)
    }
    private fun applyDisplayMode(theme: String?) {
        when (theme) {
            "light" -> {
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
            }
            "dark" -> {
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
            }
        }
    }
    private fun setLocale(activity: Context, languageCode: String?) {
        val locale = languageCode?.let { Locale(it) }
        Locale.setDefault(locale)
        val resources: Resources = activity.resources
        val config: Configuration = resources.configuration
        config.setLocale(locale)
        resources.updateConfiguration(config, resources.displayMetrics)
    }
}