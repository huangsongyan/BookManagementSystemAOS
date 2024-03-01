package com.hubert.bookmanagementsystem.ui

import com.hubert.bookmanagementsystem.base.IUiState
import com.hubert.bookmanagementsystem.model.bean.Book

data class BookState(val bookUiState: BookUiState) : IUiState

sealed class BookUiState {
    data object INIT : BookUiState()
    data class SUCCESS(val models: List<Book>) : BookUiState()
    data class GetBookByIdSUCCESS(val models: Book) : BookUiState()
    data class AddBookSUCCESS(val book: Book) : BookUiState()
    data class UpdateBookSUCCESS(val book: Book) : BookUiState()
    data class DeleteBookSUCCESS(val msg: Int) : BookUiState()
}