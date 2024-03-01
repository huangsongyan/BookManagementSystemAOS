package com.hubert.bookmanagementsystem.respository

import android.util.Log
import com.hubert.bookmanagementsystem.model.bean.Book
import com.hubert.bookmanagementsystem.model.respository.BookRepository
import kotlinx.coroutines.runBlocking
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.ArgumentMatchers.anyString
import org.mockito.Mockito
import org.powermock.modules.junit4.PowerMockRunner

@RunWith(PowerMockRunner::class)
class HomeRepositoryTest {

    private val repository = BookRepository()

    @Before
    fun setUp() {
        Mockito.`when`(Log.d(anyString(), anyString())).thenReturn(1)
        val result = Log.d("tag", "msg")
        assertEquals(1, result)
    }

    @Test
    fun testRequestBookData() = runBlocking {
        val result = repository.requestBookData()
        println(result)
        assertEquals(3, result.data?.size)
    }

    @Test
    fun testRequestBookDataById() = runBlocking {
        val result = repository.requestBookDataById("1")
        println(result)
        assertEquals(0, result.code)
    }

    @Test
    fun testRequestAddBook() = runBlocking {
        val book = Book(
            bookTitle = "bookTitle",
            author = "bookAuthor",
            publicationYear = 2024,
            briefInfo = "briefInfo"
        )
        val result = repository.requestAddBook(book)
        println(result)
        assertEquals(0, result.code)
    }

    @Test
    fun testRequestUpdateBook() = runBlocking {
        val book = Book(
            bookId = 1L,
            bookTitle = "bookTitle2",
            author = "bookAuthor2",
            publicationYear = 2024,
            briefInfo = "briefInfo2"
        )
        val result = repository.requestUpdateBook(book)
        println(result)
        assertEquals(0, result.code)
    }

    @Test
    fun testRequestDeleteBook() = runBlocking {
        val book = Book(bookId = 2L)
        val result = repository.requestDeleteBook(book)
        println(result)
        assertEquals(0, result.code)
    }
}
