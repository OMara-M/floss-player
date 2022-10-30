package com.example.flossplayer

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val myBookList = createBookList()



    }

    private fun createBookList(): BookList{
        val books = resources.getStringArray(R.array.books)
        val authors = resources.getStringArray(R.array.authors)

        val myBookList = BookList(parcel)
        for (item in books.indices){
            myBookList.add(Book(books[item], authors[item]))
        }
        return myBookList
    }
}