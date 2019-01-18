package com.dev.android.railian.notes

import android.os.Bundle
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity;
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.navigation.NavController
import androidx.navigation.NavOptions
import androidx.navigation.Navigation
import com.dev.android.railian.notes.fragment.notesList.NotesListFragment

import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private lateinit var navigationController: NavController
    private var backAlreadyPressed: Boolean = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        navigationController = Navigation.findNavController(this, R.id.nav_host_fragment)
    }

    override fun onBackPressed() {
        val navHostFragment = supportFragmentManager.findFragmentById(R.id.nav_host_fragment)
        val backStackEntry = navHostFragment?.childFragmentManager?.fragments ?: mutableListOf()

        if (backStackEntry.size == 1 && backStackEntry.first() is NotesListFragment) {
            if (backAlreadyPressed) {
                finish()
            } else {
                backAlreadyPressed = true
                Toast.makeText(this, "Press back one more time to exit application", Toast.LENGTH_SHORT).show()
            }
        } else {
            super.onBackPressed()
        }
    }
}
