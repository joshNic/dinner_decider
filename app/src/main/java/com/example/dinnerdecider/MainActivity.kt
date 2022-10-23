package com.example.dinnerdecider

import android.app.Activity
import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.inputmethod.InputMethodManager
import com.example.dinnerdecider.databinding.ActivityMainBinding
import kotlin.random.Random

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    var foodList = arrayListOf("Hamburger", "Pizza", "Mexican", "American", "Chinese")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        binding.decideBtn.setOnClickListener {
            val randomNumber = Random.nextInt(0, foodList.size)
            binding.foodTv.text = foodList[randomNumber];

        }


        binding.addFoodBtn.setOnClickListener {
            foodList.add(binding.addFoodTv.text.toString())
            binding.addFoodTv.text.clear()
            val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
            imm.hideSoftInputFromWindow(view.windowToken, 0);
        }
    }


}