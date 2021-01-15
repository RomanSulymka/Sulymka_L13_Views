package com.example.sulymka_l13_views

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.example.sulymka_l13_views.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setupBinding()
        setupListeners()
    }

    private fun visibleProgressBar() {
        binding.progressBar.visibility = View.VISIBLE
    }

    private fun invisibleProgressBar() {
        binding.progressBar.visibility = View.GONE
    }

    private fun visibleTvAndButton() {
        binding.btn1.visibility = View.VISIBLE
        binding.textView.visibility = View.VISIBLE
    }

    private fun invisibleTvAndButton() {
        binding.btn1.visibility = View.GONE
        binding.textView.visibility = View.GONE
    }

    private fun runTimer() {
        visibleProgressBar()

        val currentCounterValue: Long = binding.textView.text.toString().toLong()
        val timeOfAnimationInMillis: Long = (currentCounterValue + 1) * 1000
        binding.textView.text = "${(currentCounterValue + 1)}"

        Handler(Looper.getMainLooper()).postDelayed(
                {
                    invisibleProgressBar()
                    visibleTvAndButton()
                },
                (timeOfAnimationInMillis)
        )

    }

    private fun setupBinding(){
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    private fun setupListeners() {
        binding.btn1.setOnClickListener {
            invisibleTvAndButton()
            runTimer()
        }
    }

}