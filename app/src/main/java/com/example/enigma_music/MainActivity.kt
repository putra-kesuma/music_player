package com.example.enigma_music

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.navigation.Navigation

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

//    fun toFormMusic(view: View) {
//        Navigation.findNavController(view)
//            .navigate(R.id.action_fragmentListMusic_to_fragmentFormMusic)
//    }
}