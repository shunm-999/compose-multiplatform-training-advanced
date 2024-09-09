package org.example.project.infra.sqldelight.com.jetbrains.kotlin.cache

import app.cash.sqldelight.db.SqlDriver

interface DatabaseDriverFactory {
    fun createDriver(): SqlDriver
}