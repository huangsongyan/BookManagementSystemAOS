package com.hubert.bookmanagementsystem.model.respository

import com.hubert.bookmanagementsystem.model.http.BookRetrofitClient
import com.hubert.bookmanagementsystem.model.http.api.BookApi
import com.hubert.bookmanagementsystem.base.BaseData
import com.hubert.bookmanagementsystem.base.BaseRepository
import com.hubert.bookmanagementsystem.model.bean.Book

class BookRepository : BaseRepository() {

    private val service = BookRetrofitClient.getService(BookApi::class.java)

    suspend fun requestBookData(): BaseData<List<Book>> {
        return executeRequest { service.getBookList() }
    }

    suspend fun requestBookDataById(bookId: String): BaseData<Book> {
        return executeRequest { service.getBookById(bookId) }
    }

    suspend fun requestAddBook(book: Book): BaseData<Book> {
        return executeRequest { service.addBook(book) }
    }

    suspend fun requestUpdateBook(book: Book): BaseData<Book> {
        return executeRequest { service.updateBook(book) }
    }

    suspend fun requestDeleteBook(book: Book): BaseData<Int> {
        return executeRequest { service.deleteBook(book) }
    }

}