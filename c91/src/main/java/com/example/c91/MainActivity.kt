package com.example.c91

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.c91.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val oneFragment = OneFragment()
        val twoFragment = TwoFragment()

        val manager = supportFragmentManager
        val transaction = manager.beginTransaction()

        transaction.add(R.id.fragment_content, oneFragment)
        transaction.commit()

        binding.oneButton.setOnClickListener{
            val tran = manager.beginTransaction()
            tran.replace(R.id.fragment_content, oneFragment)
            tran.commit()
        }
        binding.twoButton.setOnClickListener{
            val tran = manager.beginTransaction()
            tran.replace(R.id.fragment_content, twoFragment)
            tran.commit()
        }

    }
}