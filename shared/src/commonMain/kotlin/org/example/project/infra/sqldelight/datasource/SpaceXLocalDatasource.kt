package org.example.project.infra.sqldelight.datasource

import kotlinx.coroutines.sync.Mutex
import kotlinx.coroutines.sync.withLock
import org.example.project.domain.model.RocketLaunch
import org.example.project.infra.sqldelight.dao.LaunchDao

internal class SpaceXLocalDatasource(
    private val launchDao: LaunchDao,
) {
    private val mutex = Mutex()

    suspend inline fun get(forceReload: Boolean, updater: () -> List<RocketLaunch>): List<RocketLaunch> {
        mutex.withLock {
            val cachedLaunches = launchDao.getAllLaunches()
            return if (cachedLaunches.isEmpty() && !forceReload) {
                cachedLaunches
            } else {
                val newLaunches = updater()
                launchDao.clearAndCreateLaunches(newLaunches)
                return newLaunches
            }
        }
    }
}