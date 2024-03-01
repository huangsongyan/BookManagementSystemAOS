package com.hubert.bookmanagementsystem.model.bean

import java.io.Serializable

data class Book(
    var bookId: Long? = null,
    var bookTitle: String = "",
    var author: String = "",
    var publicationYear: Int = 0,
    var isbn: String = "xxxx",
//    var cover: String = "https://img9.doubanio.com/view/subject/s/public/s26018275.jpg",
    var cover: String = "",
    var briefInfo: String = "",
):Serializable