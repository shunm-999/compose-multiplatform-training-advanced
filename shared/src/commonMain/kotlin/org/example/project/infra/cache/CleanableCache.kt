package org.example.project.infra.cache

interface CleanableCache {
    fun clean()
}

interface SuspendedCleanableCache {
    suspend fun clean()
}