package org.example.project.di

import org.koin.dsl.module

val appModule = module {
    includes(sharedModule)
    includes(viewModelModule)
}