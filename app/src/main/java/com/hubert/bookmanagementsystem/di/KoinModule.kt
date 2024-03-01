package com.hubert.bookmanagementsystem.di

import com.hubert.bookmanagementsystem.model.respository.BookRepository
import com.hubert.bookmanagementsystem.ui.BookViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module


val repoModule = module {
    single { BookRepository() }
}

val viewModelModule = module {
    viewModel { BookViewModel(get()) }
}

val appModule = listOf(viewModelModule, repoModule)