package com.example.android_research

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.LiveData
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.bottomnavigation.BottomNavigationView
import kotlinx.android.synthetic.main.activity_main.*
import setupWithNavController


class MainActivity : AppCompatActivity() {
    lateinit var controller: NavController
    private var currentNavController: LiveData<NavController>? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
//        setUpBottomNavigationBar()
        setUp()
    }


    //Navigation use new version, it auto handle mutil backstack
    //use version  ext.navigationVersion = "2.4.0-alpha01"
    private fun setUpBottomNavigationBar() {
        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment
        controller = navHostFragment.navController
        val bottomNavigationView = findViewById<BottomNavigationView>(R.id.bnvMain)
        bottomNavigationView.setupWithNavController(controller)
    }

    //Navigation use old version, So it must handle mutil backstack
    //use version  ext.navigationVersion = "2.3.0-alpha01"
    private fun setUp() {
        val bottomNavigationView = findViewById<BottomNavigationView>(R.id.bnvMain)
        bottomNavigationView.itemIconTintList = null
        var navGrapId = listOf(
            R.navigation.root_navigation_home,
            R.navigation.root_navigation_search,
            R.navigation.root_navigation_more,
            R.navigation.root_navigation_link
        )
        var controller = bottomNavigationView.setupWithNavController(
            navGrapId,
            supportFragmentManager,
            R.id.nav_host_fragment
        )
        currentNavController = controller
    }

    override fun onSupportNavigateUp(): Boolean {
        return currentNavController?.value?.navigateUp() ?: false
    }

    override fun onBackPressed() {
    /*      controller.popBackStack()
        currentNavController?.value?.popBackStack()
  */
        super.onBackPressed()
    }
}