package com.example.faceit.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.faceit.R
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun onBackPressed() {
        if (getFragmentManager().getBackStackEntryCount() > 0){
            getFragmentManager().popBackStack()
        }else{
            super.onBackPressed()
        }
    }
}