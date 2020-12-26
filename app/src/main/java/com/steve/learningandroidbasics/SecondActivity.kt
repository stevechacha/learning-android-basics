package com.steve.learningandroidbasics

import android.Manifest
import android.app.Activity
import android.content.Intent
import android.content.pm.PackageManager
import android.database.DatabaseUtils
import android.os.Binder
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import androidx.core.app.ActivityCompat
import androidx.databinding.DataBindingUtil
import com.steve.learningandroidbasics.databinding.ActivitySecondBinding

class SecondActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySecondBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        binding= DataBindingUtil.setContentView(this, R.layout.activity_second)

        binding.button.setOnClickListener {
            Intent(Intent.ACTION_GET_CONTENT).also {
                it.type="image/*"
                startActivityForResult(it,0)
            }
        }

    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (requestCode==Activity.RESULT_OK && requestCode==0){
            val uri=data?.data
//           val image=findViewById<ImageView>(R.id.imageView)
            val image=binding.imageView
            image.setImageURI(uri)
        }
    }
}