package com.example.flossplayer

import android.os.Parcel

class BookList {

    private val myBookList = ArrayList<Book>()

    fun add(book: Book){
        myBookList.add(book)
    }
    fun remove(book: Book){
        myBookList.remove(book)
    }
    fun get(bookID: Int): Book{
        return myBookList[bookID]
    }
    fun size(): Int{
        return myBookList.size
    }

}