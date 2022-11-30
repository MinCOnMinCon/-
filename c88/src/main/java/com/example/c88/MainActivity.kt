package com.example.c88

import android.os.Bundle
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val imageView = findViewById<ImageView>(R.id.resultView)

        Glide.with(this)
            .load("https://w.namu.la/s/597fd331cfc9bb77651d54e7df4d9f6dc8b65a262863ad2c1b4631fe8a3ba7d6933d6ea2981f1a42c080780bc5ab868209afdd3604178f97e0b4bde1f1808e6e3d6f295acdcdf29b2f6a09126500aac0eda220dfb7561b45748c147d3d57c1a5")
            .override(200,200)
            .placeholder(R.drawable.loading)
            .error(R.drawable.error)
            .into(imageView)
    }
}