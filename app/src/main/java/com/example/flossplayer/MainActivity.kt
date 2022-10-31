package com.example.flossplayer

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val myBookList = createBookList()

        val bookViewModel = ViewModelProvider(this).get(BookViewModel::class.java)

        if(supportFragmentManager.findFragmentById(R.id.container1) !is BookListFragment){
            supportFragmentManager
                .beginTransaction()
                .replace(R.id.container1, BookListFragment.newInstance(myBookList))
                .commit()
        }

    }

    private fun createBookList(): BookList{
        val books = resources.getStringArray(R.array.books)
        val authors = resources.getStringArray(R.array.authors)

        val myBookList = BookList()
        for (item in books.indices){
            myBookList.add(Book(books[item], authors[item]))
        }
        return myBookList
    }
}