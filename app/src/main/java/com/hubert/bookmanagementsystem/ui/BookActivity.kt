package com.hubert.bookmanagementsystem.ui

import android.content.Intent
import android.text.TextUtils
import android.util.Log
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.hubert.bookmanagementsystem.R
import com.hubert.bookmanagementsystem.base.BaseBindingActivity
import com.hubert.bookmanagementsystem.base.LoadUiIntent
import com.hubert.bookmanagementsystem.databinding.ActivityBookBinding
import com.hubert.bookmanagementsystem.model.bean.Book
import com.hubert.bookmanagementsystem.model.respository.BookRepository
import com.hubert.bookmanagementsystem.ui.adapter.BookAdapter
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.launch
import org.koin.androidx.viewmodel.ext.android.viewModel

class BookActivity : BaseBindingActivity<ActivityBookBinding>({
    ActivityBookBinding.inflate(it)
}) {

    companion object {
        private const val TAG = "BookActivity"
    }

    private lateinit var bookAdapter: BookAdapter
    private val mViewModel by viewModel<BookViewModel>()

    override fun initView() {
        R.id.recyclerView
        bookAdapter = BookAdapter()
        val layoutManager = LinearLayoutManager(this)
        layoutManager.orientation = LinearLayoutManager.VERTICAL
        binding.recyclerView.layoutManager = layoutManager
        binding.recyclerView.adapter = bookAdapter
        binding.recyclerView.addItemDecoration(
            DividerItemDecoration(
                this, DividerItemDecoration.VERTICAL
            )
        )
        binding.searchBtn.setOnClickListener {
            val id = binding.editText.text.toString()
            if (TextUtils.isEmpty(id)) {
                mViewModel.sendUiIntent(BookIntent.GetBook)
            } else {
                mViewModel.sendUiIntent(BookIntent.GetBookById(id))
            }
        }
        binding.addBtn.setOnClickListener {
            startActivity(Intent(this, AddBookActivity::class.java))
        }
    }

    override fun initData() {
        lifecycleScope.launch {
            mViewModel.sendUiIntent(BookIntent.GetBook)
        }

        lifecycleScope.launch {
            mViewModel.loadUiIntentFlow.collect { state ->
                Log.d(TAG, "loadUiStateFlow: $state")
                when (state) {
                    is LoadUiIntent.Error -> Log.d(TAG, state.msg)
                    is LoadUiIntent.ShowMainView -> {
                        Log.d(TAG, "show view")
                    }

                    is LoadUiIntent.Loading -> Log.d(TAG, "show loading")
                }
            }
        }
        lifecycleScope.launch {
            mViewModel.uiStateFlow.map { it.bookUiState }
                .collect { bookUiState ->
                    Log.d(TAG, "bookUiState: $bookUiState")
                    when (bookUiState) {
                        is BookUiState.INIT -> {}
                        is BookUiState.SUCCESS -> {
                            var data = ArrayList<Book>()
                            for (model in bookUiState.models) {
                                data.add(model)
                            }
                            bookAdapter.setData(data)
                        }

                        is BookUiState.GetBookByIdSUCCESS -> {
                            var data = ArrayList<Book>()
                            data.add(bookUiState.models)
                            bookAdapter.setData(data)
                        }

                        else -> {

                        }
                    }
                }
        }
    }
}