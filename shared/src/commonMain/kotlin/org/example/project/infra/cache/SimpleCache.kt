package org.example.project.infra.cache

class SimpleCache<T>(
    private val cacheCleaner: CacheCleaner,
) : CleanableCache {
    private var cache: T? = null

    init {
        cacheCleaner.registerCache(this)
    }

    fun get(forceReload: Boolean = false, updater: () -> T): T {
        val cachedValue = cache

        return if (cachedValue != null && !forceReload) {
            cachedValue
        } else {
            val newValue = updater()
            cache = newValue
            return newValue
        }
    }

    fun getOrNull(): T? = cache

    fun set(value: T) {
        cache = value
    }

    override fun clean() {
        cache = null
    }
}