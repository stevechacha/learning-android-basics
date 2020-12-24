package com.steve.learningandroidbasics

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.drawerlayout.widget.DrawerLayout
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.navigation.NavigationView

class NavigationDrawerActivity : AppCompatActivity() {
    private lateinit var toggle:ActionBarDrawerToggle
    private lateinit var drawerLayout: DrawerLayout
    lateinit var navigation: NavigationView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_navigation_drawer)

             //buttomNavigationView
        val navVieww: BottomNavigationView = findViewById(R.id.bottomNavigationView)
        val homeFragment=HomeFragment()
        val searchFragment=SearchFragment()
        val notificationFragment=NotificationFragment()
        val messageFragment=MessageFragment()
        setCurrentFragment(homeFragment)

            //Drawer NavigationView
        drawerLayout=findViewById(R.id.drawerlayout)
        toggle=ActionBarDrawerToggle(this,drawerLayout,R.string.open, R.string.close)
        drawerLayout.addDrawerListener(toggle)
        toggle.syncState()
        navigation=findViewById(R.id.navView)

        navVieww.setOnNavigationItemSelectedListener{
            when(it.itemId){
                R.id.action_home ->setCurrentFragment(homeFragment)
                R.id.action_search ->setCurrentFragment(searchFragment)
                R.id.action_notification ->setCurrentFragment(notificationFragment)
                R.id.action_message ->setCurrentFragment(messageFragment)
            }
            true
        }
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        navigation.setNavigationItemSelectedListener { when(it.itemId){
            R.id.action_home ->Toast.makeText(applicationContext,"selected home",Toast.LENGTH_LONG).show()
            R.id.action_search -> Toast.makeText(applicationContext,"clicked search",Toast.LENGTH_LONG).show()
            R.id.action_notification ->Toast.makeText(applicationContext,"clicked notification",Toast.LENGTH_LONG).show()
            R.id.action_message ->Toast.makeText(applicationContext,"clicked message",Toast.LENGTH_LONG).show()
        }
            true
        }
    }
    private fun setCurrentFragment(fragment: Fragment)=
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.buttomFragment,fragment)
            commit()
        }
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (toggle.onOptionsItemSelected(item)){
           return true
        }
        return super.onOptionsItemSelected(item)
    }
}