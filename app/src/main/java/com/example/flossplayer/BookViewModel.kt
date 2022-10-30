package com.example.flossplayer

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class BookViewModel: ViewModel() {

    private val selectedBook: MutableLiveData<Book> by lazy {
        MutableLiveData<Book>()
    }

    fun setSelectedBook(book:Book){
        selectedBook.value + book
    }

    fun getSelectedBook(): LiveData<Book>{
        return selectedBook
    }

}