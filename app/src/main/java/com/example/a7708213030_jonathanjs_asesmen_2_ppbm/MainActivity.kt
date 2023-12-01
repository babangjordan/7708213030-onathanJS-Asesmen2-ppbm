package com.example.a7708213030_jonathanjs_asesmen_2_ppbm

import android.content.Intent
import android.os.Bundle
import android.widget.AdapterView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.a7708213030_jonathanjs_asesmen_2_ppbm.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var userArrayList: ArrayList<User>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val imageId = intArrayOf(
            R.drawable.profil_1, R.drawable.profil_2, R.drawable.profil_3, R.drawable.profil_4, R.drawable.profil_5
        )

        val name = arrayOf(
            "Jason",
            "Statham",
            "Sergio",
            "Ramos",
            "David"
        )

        val lastMessage = arrayOf(
            "let's Go",
            "what's going on?",
            "where?",
            "What the hell is going on",
            "Killingspree"
        )

        val lastMsgTime = arrayOf(
            "19.15 pm",
            "21.25 pm",
            "10.00 am",
            "13.45 pm",
            "14.00 pm"
        )

        val phoneNo = arrayOf(
            "928291mi2717",
            "287261mi9292",
            "182828727mi3",
            "118181818mi2",
            "2828288mi112"
        )

        val country = arrayOf(
            "Vegas",
            "Los santos",
            "Kaleanmu",
            "Ocean",
            "greemland"
        )

        userArrayList = ArrayList()

        for (i in name.indices) {
            val user = User(name[i], lastMessage[i], lastMsgTime[i], phoneNo[i], country[i], imageId[i])
            userArrayList.add(user)
        }

        binding.listview.isClickable = true
        val adapter = MyAdapter(this, userArrayList)
        binding.listview.adapter = adapter

        binding.listview.setOnItemClickListener { parent: AdapterView<*>, view, position: Int, id: Long ->
            val selectedUser = userArrayList[position]

            // Example: Creating an intent to start UserActivity and passing data
            val intent = Intent(this@MainActivity, UserActivity::class.java)
            intent.putExtra("Name", selectedUser.name)
            intent.putExtra("Phone", selectedUser.phoneNo)
            intent.putExtra("Country", selectedUser.country)
            intent.putExtra("ImageId", selectedUser.imageId)

            startActivity(intent)
        }
    }
}
