package com.example.yannalakl_mb1_tp1

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.yannalakl_mb1_tp1.databinding.ActivityMainBinding
import com.example.yannalakl_mb1_tp1.databinding.ActivitySecondBinding

class SecondActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySecondBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivitySecondBinding.inflate(layoutInflater)
        setContentView(R.layout.activity_second)
        val msg = intent.getStringExtra("message")
        binding.welcomeText.text = msg
        }
    }
