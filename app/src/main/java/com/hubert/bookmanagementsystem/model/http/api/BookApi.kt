package com.hubert.bookmanagementsystem.model.http.api

import com.hubert.bookmanagementsystem.base.BaseData
import com.hubert.bookmanagementsystem.model.bean.Book
import retrofit2.http.Body
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.PUT
import retrofit2.http.Path

interface BookApi {
    @GET("getBookList")
    suspend fun getBookList(): BaseData<List<Book>>

    @GET("/getBook/{bookId}")
    suspend fun getBookById(@Path("bookId") bookId: String): BaseData<Book>

    @PUT("/addBook")
    suspend fun addBook(@Body book: Book): BaseData<Book>

    @POST("/updateBook")
    suspend fun updateBook(@Body book: Book): BaseData<Book>

    @DELETE("/removeBook")
    suspend fun deleteBook(@Body book: Book): BaseData<Int>
}