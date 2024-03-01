package com.hubert.bookmanagementsystem.book

import com.hubert.bookmanagementsystem.model.bean.Book
import com.hubert.bookmanagementsystem.model.respository.BookRepository
import com.hubert.bookmanagementsystem.ui.BookIntent
import com.hubert.bookmanagementsystem.ui.BookUiState
import com.hubert.bookmanagementsystem.ui.BookViewModel
import org.junit.Assert
import org.junit.Before
import org.junit.Test

class BookViewModelTest {

    private lateinit var bookViewModel: BookViewModel

    @Before
    fun setUp() {
        val bookRepository = BookRepository()
        bookViewModel = BookViewModel(bookRepository)
    }

    @Test
    fun handleGetBookIntent() {
        bookViewModel.sendUiIntent(BookIntent.GetBook)
        Thread.sleep(1000)
        val bookUiState = bookViewModel.uiStateFlow.value.bookUiState
        println(bookUiState)
        Assert.assertTrue(bookUiState is BookUiState.SUCCESS)
    }

    @Test
    fun testGetDetailIntent() {
        bookViewModel.sendUiIntent(BookIntent.GetBookById("1"))
        Thread.sleep(1000)
        val bookUiState = bookViewModel.uiStateFlow.value.bookUiState
        println(bookUiState)
        Assert.assertTrue(bookUiState is BookUiState.GetBookByIdSUCCESS)
    }

    @Test
    fun testAddBook() {
        val book = Book(
            bookTitle = "bookTitle",
            author = "bookAuthor",
            publicationYear = 2024,
            briefInfo = "briefInfo"
        )
        bookViewModel.sendUiIntent(BookIntent.AddBook(book))
        Thread.sleep(1000)
        val bookUiState = bookViewModel.uiStateFlow.value.bookUiState
        println(bookUiState)
        Assert.assertTrue(bookUiState is BookUiState.AddBookSUCCESS)
    }

    @Test
    fun testUpdateBook() {
        val book = Book(
            bookId = 1L,
            bookTitle = "bookTitle",
            author = "bookAuthor",
            publicationYear = 2024,
            briefInfo = "briefInfo"
        )
        bookViewModel.sendUiIntent(BookIntent.UpdateBook(book))
        Thread.sleep(1000)
        val bookUiState = bookViewModel.uiStateFlow.value.bookUiState
        println(bookUiState)
        Assert.assertTrue(bookUiState is BookUiState.UpdateBookSUCCESS)
    }

    @Test
    fun testDeleteBook() {
        val book = Book(bookId = 1L)
        bookViewModel.sendUiIntent(BookIntent.DeleteBook(book))
        Thread.sleep(1000)
        val bookUiState = bookViewModel.uiStateFlow.value.bookUiState
        println(bookUiState)
        Assert.assertTrue(bookUiState is BookUiState.DeleteBookSUCCESS)
    }
}