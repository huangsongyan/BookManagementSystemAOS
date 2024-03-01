package com.hubert.bookmanagementsystem.ui

import android.widget.Toast
import androidx.lifecycle.lifecycleScope
import com.hubert.bookmanagementsystem.base.BaseBindingActivity
import com.hubert.bookmanagementsystem.databinding.ActivityUpdateBookBinding
import com.hubert.bookmanagementsystem.model.bean.Book
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.launch
import org.koin.androidx.viewmodel.ext.android.viewModel

class UpdateBookActivity : BaseBindingActivity<ActivityUpdateBookBinding>({
    ActivityUpdateBookBinding.inflate(it)
}) {

    private val mViewModel by viewModel<BookViewModel>()

    override fun initView() {
        binding.btnSubmit.setOnClickListener {
            val bookTitle = binding.tvBookTitle.text.toString()
            val bookAuthor = binding.tvBookAuthor.text.toString()
            val bookPublishYear = binding.tvBookPublishYear.text.toString()
            val bookBrief = binding.tvBookBrief.text.toString()
            val book = Book(
                bookTitle = bookTitle,
                author = bookAuthor,
                publicationYear = bookPublishYear.toInt(),
                briefInfo = bookBrief
            )
            mViewModel.sendUiIntent(BookIntent.UpdateBook(book))
        }
    }

    override fun initData() {
        lifecycleScope.launch {
            mViewModel.uiStateFlow.map { it.bookUiState }
                .collect { bookUiState ->
                    when (bookUiState) {
                        is BookUiState.INIT -> {}
                        is BookUiState.UpdateBookSUCCESS -> {
                            Toast.makeText(this@UpdateBookActivity, "修改成功", Toast.LENGTH_SHORT)
                                .show()
                            finish()
                        }

                        else -> {

                        }
                    }
                }
        }
    }
}