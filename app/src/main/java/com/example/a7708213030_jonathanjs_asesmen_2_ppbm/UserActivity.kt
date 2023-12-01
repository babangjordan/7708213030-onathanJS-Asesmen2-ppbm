package com.example.a7708213030_jonathanjs_asesmen_2_ppbm

import android.os.Bundle
import android.view.LayoutInflater
import androidx.appcompat.app.AppCompatActivity
import com.example.a7708213030_jonathanjs_asesmen_2_ppbm.databinding.ActivityMainBinding
import com.example.a7708213030_jonathanjs_asesmen_2_ppbm.databinding.ActivityUserBinding

class UserActivity : AppCompatActivity() {

    private lateinit var binding: ActivityUserBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityUserBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val name = intent.getStringExtra("Name")
        val phone = intent.getStringExtra("Phone")
        val country = intent.getStringExtra("Country")
        val imageId = intent.getIntExtra("ImageId", R.drawable.profil_1)

        binding.nameProfile.text = name
        binding.phoneProfile.text = phone
        binding.countryProfile.text = country
        binding.profileImage.setImageResource(imageId)
    }
}
