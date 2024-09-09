package org.example.project.di

import org.example.project.infra.di.infraModule
import org.koin.dsl.module

val appModule = module {
    includes(infraModule)
}