package org.example.project.infra.di

import org.example.project.domain.repository.SpaceXRepository
import org.example.project.infra.api.datasource.SpaceXRemoteDatasource
import org.example.project.infra.api.list.SpaceXApi
import org.example.project.infra.repository.SpaceXRepositoryImpl
import org.example.project.infra.sqldelight.com.jetbrains.kotlin.cache.AndroidDatabaseDriverFactory
import org.example.project.infra.sqldelight.dao.LaunchDao
import org.example.project.infra.sqldelight.datasource.SpaceXLocalDatasource
import org.koin.dsl.module

internal actual val infraModule = module {
    single<SpaceXApi> { SpaceXApi() }
    single<LaunchDao> {
        LaunchDao(
            databaseDriverFactory = AndroidDatabaseDriverFactory(
                context = get()
            )
        )
    }
    single<SpaceXLocalDatasource> {
        SpaceXLocalDatasource(
            launchDao = get()
        )
    }
    single<SpaceXRemoteDatasource> {
        SpaceXRemoteDatasource(
            spaceXApi = get()
        )
    }
    single<SpaceXRepository> { SpaceXRepositoryImpl(get(), get()) }
}