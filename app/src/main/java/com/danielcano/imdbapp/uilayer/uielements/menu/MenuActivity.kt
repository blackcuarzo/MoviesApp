package com.danielcano.imdbapp.uilayer.uielements.menu

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.navArgs
import androidx.navigation.ui.setupWithNavController
import com.danielcano.imdbapp.R
import com.danielcano.imdbapp.databinding.ActivityMenuBinding

class MenuActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMenuBinding
    private val args: MenuActivityArgs by navArgs()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMenuBinding.inflate(layoutInflater)
        val view = binding.root

        val editor = getSharedPreferences(
            getString(R.string.preferences),
            MODE_PRIVATE
        )
        editor.edit().putString("userName", args.userName).apply()

        setContentView(view)
        val navController = findNavController(R.id.nav_host_fragment2)
        val bottomNavigationMenu = binding.bottomNavigationView
        bottomNavigationMenu.menu.findItem(R.id.profileFragment).title = args.userName
        bottomNavigationMenu.setupWithNavController(navController)
    }
}