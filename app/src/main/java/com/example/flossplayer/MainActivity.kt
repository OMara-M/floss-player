package com.example.flossplayer

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


    }

    private fun createBookList(): BookList{
        val books = resources.getStringArray(R.array.books)
        val authors = resources.getStringArray(R.array.authors)

        val
    }
}