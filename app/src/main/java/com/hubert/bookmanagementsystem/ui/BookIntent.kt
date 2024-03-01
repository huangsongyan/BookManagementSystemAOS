package com.hubert.bookmanagementsystem.ui

import com.hubert.bookmanagementsystem.base.IUiIntent
import com.hubert.bookmanagementsystem.model.bean.Book

sealed class BookIntent : IUiIntent {
    data object GetBook : BookIntent()
    data class GetBookById(val bookId: String) : BookIntent()
    data class AddBook(val book: Book) : BookIntent()
    data class UpdateBook(val book: Book) : BookIntent()
    data class DeleteBook(val book: Book) : BookIntent()
}