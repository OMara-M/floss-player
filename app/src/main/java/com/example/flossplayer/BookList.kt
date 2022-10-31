package com.example.flossplayer

import android.os.Parcel
import android.os.Parcelable

class BookList() : Parcelable {

    private val myBookList = ArrayList<Book>()

    constructor(parcel: Parcel) : this(){
    }

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

    override fun describeContents(): Int {
        return 0
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {

    }

    companion object CREATOR : Parcelable.Creator<BookList> {
        override fun createFromParcel(parcel: Parcel): BookList {
            return BookList(parcel)
        }

        override fun newArray(size: Int): Array<BookList?> {
            return arrayOfNulls(size)
        }
    }

}