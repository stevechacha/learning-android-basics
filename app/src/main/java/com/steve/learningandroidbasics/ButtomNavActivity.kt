package com.steve.learningandroidbasics

import android.app.Notification
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView

class ButtomNavActivity : AppCompatActivity() {
    lateinit var bottomNavigationView: BottomNavigationView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_buttom_nav)


        val navVieww: BottomNavigationView = findViewById(R.id.bottomNavigationView)
        val homeFragment=HomeFragment()
        val searchFragment=SearchFragment()
        val notificationFragment=NotificationFragment()
        val messageFragment=MessageFragment()

        setCurrentFragment(homeFragment)
        navVieww.setOnNavigationItemSelectedListener{
            when(it.itemId){
                R.id.action_home ->setCurrentFragment(homeFragment)
                R.id.action_search ->setCurrentFragment(searchFragment)
                R.id.action_notification ->setCurrentFragment(notificationFragment)
                R.id.action_message ->setCurrentFragment(messageFragment)
            }
            true
        }
        navVieww.getOrCreateBadge(R.id.action_message).apply {
            number=10
            isVisible=true
        }
    }
    private fun setCurrentFragment(fragment: Fragment)=
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.buttomFragment,fragment)
            commit()
        }
}