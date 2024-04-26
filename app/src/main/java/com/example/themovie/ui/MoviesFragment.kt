package com.example.themovie.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.themovie.R
import com.example.themovie.domain.model.MovieEntity

class MoviesFragment : Fragment(), View.OnClickListener {
    private lateinit var viewModel: MoviesViewModel
    private lateinit var recyclerView: RecyclerView
    private lateinit var textView: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = ViewModelProvider(this)[MoviesViewModel::class.java]
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_movies, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        recyclerView = view.findViewById(R.id.recyclerView)
        textView = view.findViewById(R.id.textViewTitle)
        recyclerView.layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
        viewModel.fetchMovies().observe(viewLifecycleOwner) {
            initMovies(it)
        }

        arguments?.getString(ARG_TITLE)?.let {
            textView.text = it
        }
    }

    private fun initMovies(movies: List<MovieEntity>) {
        recyclerView.adapter = MoviesAdapter(movies, this)
    }

    override fun onClick(v: View?) {

    }

    companion object {
        private const val ARG_TITLE = "title"

        @JvmStatic
        fun newInstance(title: String) = MoviesFragment().apply {
            arguments = Bundle().apply {
                putString(ARG_TITLE, title)
            }
        }
    }
}