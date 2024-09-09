package org.example.project.infra.sqldelight.com.jetbrains.kotlin.cache

import app.cash.sqldelight.db.SqlDriver
import app.cash.sqldelight.driver.native.NativeSqliteDriver
import com.jetbrains.kotlin.cache.AppDatabase
import org.example.project.infra.sqldelight.com.jetbrains.kotlin.cache.DatabaseDriverFactory

class IOSDatabaseDriverFactory : DatabaseDriverFactory {
    override fun createDriver(): SqlDriver {
        return NativeSqliteDriver(AppDatabase.Schema, "launch.db")
    }
}