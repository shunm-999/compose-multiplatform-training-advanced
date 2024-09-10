package org.example.project.di

import org.example.project.ui.rocket.RocketLaunchViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.module.Module
import org.koin.dsl.module

internal actual val viewModelModule: Module = module {
    viewModel {
        RocketLaunchViewModel(get())
    }
}