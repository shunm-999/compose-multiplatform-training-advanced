package org.example.project.infra.sqldelight.dao

import com.jetbrains.kotlin.cache.AppDatabase
import org.example.project.infra.sqldelight.com.jetbrains.kotlin.cache.DatabaseDriverFactory

internal class LaunchDao(
    databaseDriverFactory: DatabaseDriverFactory
) {
    private val database = AppDatabase(databaseDriverFactory.createDriver())
    private val dbQuery = database.appDatabaseQueries
}