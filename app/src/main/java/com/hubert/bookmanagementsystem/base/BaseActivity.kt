package com.hubert.bookmanagementsystem.base

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

abstract class BaseActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initView()
        initData()
    }

    abstract fun initView()
    abstract fun initData()


    open fun <VM : ViewModel> createViewModel(vmClass: Class<VM>): VM {
        return ViewModelProvider(this)[vmClass]
    }

}