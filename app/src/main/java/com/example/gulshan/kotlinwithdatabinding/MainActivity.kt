package com.example.gulshan.kotlinwithdatabinding


import android.databinding.DataBindingUtil
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.example.gulshan.kotlinwithdatabinding.adpaters.LandingViewModel
import com.example.gulshan.kotlinwithdatabinding.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this,R.layout.activity_main)
        binding.lvm= LandingViewModel()
        binding.executePendingBindings()
    }


}
