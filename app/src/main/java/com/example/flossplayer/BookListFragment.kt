package com.example.flossplayer

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"


class BookListFragment : Fragment() {

    private var books: BookList? = null
    private lateinit var bookViewModel: BookViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        bookViewModel = ViewModelProvider(requireActivity()).get(BookViewModel::class.java)

        arguments?.let {
            books = it.getParcelable(ARG_PARAM1)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_book_list, container, false) as RecyclerView
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        with(view as RecyclerView) {
            books?.run {
                val clickEvent = { book: Book ->
                    bookViewModel.setSelectedBook(book)
                }
                layoutManager = LinearLayoutManager(requireContext())
                adapter = BookListAdapter(this, clickEvent)
            }
        }
    }

    class BookListAdapter(_bookList: BookList, _clickEvent: (Book) -> Unit) :
        RecyclerView.Adapter<BookListAdapter.BookListViewHolder>() {
        private val bookList = _bookList
        val clickEvent = _clickEvent

        inner class BookListViewHolder(_view: View) : RecyclerView.ViewHolder(_view) {
            val bookName: TextView = _view.findViewById(R.id.bookTextView)
            val bookAuthor: TextView = _view.findViewById(R.id.authorTextView)
            lateinit var bookObject: Book

            init {
                _view.setOnClickListener { clickEvent(bookObject) }
            }
        }

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BookListViewHolder {

            val layout = LayoutInflater.from(parent.context)
                .inflate(R.layout.book_list_layout, parent, false)

            return BookListViewHolder(layout)
        }

        override fun onBindViewHolder(holder: BookListViewHolder, position: Int) {
            holder.bookName.text = bookList.get(position).title
            holder.bookAuthor.text = bookList.get(position).author
            holder.bookObject = bookList.get(position)
        }

        override fun getItemCount(): Int {
            return bookList.size()
        }
    }

    companion object {

        @JvmStatic
        fun newInstance(books: BookList) =
            BookListFragment().apply {
                arguments = Bundle().apply {
                    putParcelable(ARG_PARAM1, books)
                }
            }
    }
}