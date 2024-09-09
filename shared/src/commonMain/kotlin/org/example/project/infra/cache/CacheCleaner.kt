package org.example.project.infra.cache

class CacheCleaner {

    private val caches = mutableListOf<CleanableCache>()
    private val suspendedCaches = mutableListOf<SuspendedCleanableCache>()

    fun registerCache(cache: CleanableCache) {
        caches.add(cache)
    }

    fun registerCache(cache: SuspendedCleanableCache) {
        suspendedCaches.add(cache)
    }

    suspend fun clean() {
        caches.forEach { it.clean() }
        suspendedCaches.forEach { it.clean() }
    }
}