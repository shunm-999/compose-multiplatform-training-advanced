package org.example.project.domain.di

import org.example.project.domain.usecase.GetLaunchListUseCase
import org.koin.dsl.module

internal actual val domainModule = module {
    single<GetLaunchListUseCase> {
        GetLaunchListUseCase(get())
    }
}