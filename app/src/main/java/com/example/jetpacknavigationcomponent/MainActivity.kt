package com.example.jetpacknavigationcomponent

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.NavigationUI

class MainActivity : AppCompatActivity() {
    private lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // initialize controller
        // navController = Navigation.findNavController(this, R.id.hostFragment) ERROR
        val navHostFragment = supportFragmentManager.findFragmentById(R.id.hostFragment) as NavHostFragment
        val navController = navHostFragment.navController
        // https://stackoverflow.com/questions/58703451/fragmentcontainerview-as-navhostfragment
        NavigationUI.setupActionBarWithNavController(this, navController)
    }

    override fun onSupportNavigateUp(): Boolean {
        // ketika tombol back di toolbar hp, maka ini adalah perintah backstack / keluar app
        return NavigationUI.navigateUp(navController, null)
    }

    // Homework ada di QuizActivity
}