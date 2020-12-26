package com.steve.learningandroidbasics

import android.database.DatabaseUtils
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.databinding.DataBindingUtil
import androidx.databinding.DataBindingUtil.setContentView
import androidx.drawerlayout.widget.DrawerLayout
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.navigation.NavigationView
import com.steve.learningandroidbasics.databinding.ActivityNavigationDrawerBinding

class NavigationDrawerActivity : AppCompatActivity() {
    private lateinit var binding: ActivityNavigationDrawerBinding
    private lateinit var toggle: ActionBarDrawerToggle


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding= setContentView(this,R.layout.activity_navigation_drawer)

        val homeFragment=HomeFragment()
        val messageFragment=MessageFragment()
        val searchFragment=SearchFragment()

        setCurrentFragment(homeFragment)
        toggle=ActionBarDrawerToggle(this, binding.drawerlayout,R.string.open, R.string.close)
        binding.drawerlayout.addDrawerListener(toggle)
        toggle.syncState()

        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        binding.navView.setNavigationItemSelectedListener {
            when(it.itemId){
                R.id.action_home ->Toast.makeText(applicationContext,"selected home",Toast.LENGTH_LONG).show()
                R.id.action_search -> Toast.makeText(applicationContext,"clicked search",Toast.LENGTH_LONG).show()
                R.id.action_message ->Toast.makeText(applicationContext,"clicked message",Toast.LENGTH_LONG).show()

            }
            true
        }


        binding.bottomNavigationView.setOnNavigationItemSelectedListener {
            when(it.itemId){
                R.id.action_home->setCurrentFragment(homeFragment)
                R.id.action_search->setCurrentFragment(searchFragment)
                R.id.action_message->setCurrentFragment(messageFragment)
            }

            true
        }


    }

    private fun setCurrentFragment(fragment: Fragment) =
            supportFragmentManager.beginTransaction().apply{
                replace(R.id.bottomFragment,fragment)
                commit()

            }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (toggle.onOptionsItemSelected(item)){
            return true
        }
        return super.onOptionsItemSelected(item)
    }


}