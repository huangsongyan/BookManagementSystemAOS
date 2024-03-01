package com.hubert.bookmanagementsystem.ui

import android.content.Intent
import android.widget.Toast
import androidx.lifecycle.lifecycleScope
import com.bumptech.glide.Glide
import com.hubert.bookmanagementsystem.base.BaseBindingActivity
import com.hubert.bookmanagementsystem.databinding.ActivityBookDetailBinding
import com.hubert.bookmanagementsystem.model.bean.Book
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.launch
import org.koin.androidx.viewmodel.ext.android.viewModel

class BookDetailActivity : BaseBindingActivity<ActivityBookDetailBinding>({
    ActivityBookDetailBinding.inflate(it)
}) {

    private val mViewModel by viewModel<BookViewModel>()

    override fun initView() {
        val book = intent.getSerializableExtra("data") as Book

        binding.deleteBtn.setOnClickListener {
            val book = Book(bookId = book.bookId)
            mViewModel.sendUiIntent(BookIntent.DeleteBook(book))
        }
        binding.updateBtn.setOnClickListener {
            startActivity(Intent(this@BookDetailActivity, UpdateBookActivity::class.java))
            finish()
        }

        binding.tvName.text = book.bookTitle
        binding.tvAuthor.text = book.author
        binding.tvYear.text = book.publicationYear.toString()
        Glide
            .with(binding.bookImg.context)
            .load(book.cover)
            .into(binding.bookImg)

        binding.tvContent.text = book.briefInfo
    }

    override fun initData() {
        lifecycleScope.launch {
            mViewModel.uiStateFlow.map { it.bookUiState }
                .collect { bookUiState ->
                    when (bookUiState) {
                        is BookUiState.INIT -> {}
                        is BookUiState.DeleteBookSUCCESS -> {
                            Toast.makeText(this@BookDetailActivity, "删除成功", Toast.LENGTH_SHORT)
                                .show()
                        }

                        else -> {

                        }
                    }
                }
        }
    }
}