package com.hubert.bookmanagementsystem.respository

import com.hubert.bookmanagementsystem.model.bean.Book
import com.hubert.bookmanagementsystem.model.respository.BookRepository
import kotlinx.coroutines.runBlocking
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test

class BookRepositoryTest {

    private val repository = BookRepository()

    @Before
    fun setUp() {

    }

    @Test
    fun requestBookData() = runBlocking {
        val result = repository.requestBookData()
        println(result)
        assertEquals(0, result.code)
        assertEquals(3, result.data?.size)
    }

    @Test
    fun requestBookDataById() = runBlocking {
        val result = repository.requestBookDataById("1")
        println(result)
        assertEquals(0, result.code)
        assertEquals("红楼梦", result.data?.bookTitle)
    }

    @Test
    fun requestUpdateBook() = runBlocking {
        val book = Book(
            bookId = 1L,
            bookTitle = "bookTitle",
            author = "bookAuthor",
            publicationYear = 2024,
            briefInfo = "briefInfo"
        )
        val result = repository.requestUpdateBook(book)
        println(result)
        assertEquals(0, result.code)
    }

    @Test
    fun requestDeleteBook() = runBlocking {
        val book = Book(bookId = 1L)
        val result = repository.requestDeleteBook(book)
        println(result)
        assertEquals(0, result.code)
    }
}