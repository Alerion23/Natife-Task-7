package com.example.natifetask7

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.LinearLayout
import android.widget.TextView
import androidx.core.view.setPadding
import com.example.natifetask7.custom.CustomLinearLayout
import com.example.natifetask7.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private var binding: ActivityMainBinding? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater).also {
            setContentView(it.root)
        }
        onButtonClick()
    }

    private fun onButtonClick() {
        binding?.button?.setOnClickListener {
            binding?.customView?.addTextView("ANY TEXT")
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        binding = null
    }
}