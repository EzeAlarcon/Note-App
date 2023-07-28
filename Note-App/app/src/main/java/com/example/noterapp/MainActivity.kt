package com.example.noterapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController

class MainActivity : AppCompatActivity() {

    lateinit var navController: NavController
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // navController = findNavController(R.id.nav_host_fragment)

        //configurarActionBarWithNavController(navController)
    }

// anula la diversión onNavigateUp(): Boolean {
//
// // devuelve navController.navigateUp() y super.onNavigateUp()
// }




}