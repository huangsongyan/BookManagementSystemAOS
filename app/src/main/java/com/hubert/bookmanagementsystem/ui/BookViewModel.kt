package com.hubert.bookmanagementsystem.ui

import com.hubert.bookmanagementsystem.base.BaseViewModel
import com.hubert.bookmanagementsystem.base.IUiIntent
import com.hubert.bookmanagementsystem.model.respository.BookRepository

class BookViewModel(private val homeRepo: BookRepository) : BaseViewModel<BookState, BookIntent>() {

    override fun initUiState(): BookState {
        return BookState(BookUiState.INIT)
    }

    override fun handleIntent(intent: IUiIntent) {
        when (intent) {
            BookIntent.GetBook -> {
                requestDataWithFlow(showLoading = true,
                    request = { homeRepo.requestBookData() },
                    successCallback = { data ->
                        sendUiState {
                            copy(
                                bookUiState = BookUiState.SUCCESS(
                                    data
                                )
                            )
                        }
                    })
            }

            is BookIntent.GetBookById -> {
                requestDataWithFlow(showLoading = true,
                    request = { homeRepo.requestBookDataById(intent.bookId) },
                    successCallback = { data ->
                        sendUiState {
                            copy(
                                bookUiState = BookUiState.GetBookByIdSUCCESS(
                                    data
                                )
                            )
                        }
                    })
            }

            is BookIntent.AddBook -> {
                requestDataWithFlow(showLoading = true,
                    request = { homeRepo.requestAddBook(intent.book) },
                    successCallback = { data ->
                        sendUiState {
                            copy(
                                bookUiState = BookUiState.AddBookSUCCESS(
                                    data
                                )
                            )
                        }
                    })
            }

            is BookIntent.UpdateBook -> {
                requestDataWithFlow(showLoading = true,
                    request = { homeRepo.requestUpdateBook(intent.book) },
                    successCallback = { data ->
                        sendUiState {
                            copy(
                                bookUiState = BookUiState.UpdateBookSUCCESS(
                                    data
                                )
                            )
                        }
                    })
            }

            is BookIntent.DeleteBook -> {
                requestDataWithFlow(showLoading = true,
                    request = { homeRepo.requestDeleteBook(intent.book) },
                    successCallback = { data ->
                        sendUiState {
                            copy(
                                bookUiState = BookUiState.DeleteBookSUCCESS(
                                    data
                                )
                            )
                        }
                    })
            }
        }
    }
}

