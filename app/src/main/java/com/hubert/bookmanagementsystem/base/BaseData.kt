package com.hubert.bookmanagementsystem.base

class BaseData<T> {
    var code = -1
    var message: String? = null
    var data: T? = null
    var state: ReqState = ReqState.Error
}

enum class ReqState {
    Success, Error
}