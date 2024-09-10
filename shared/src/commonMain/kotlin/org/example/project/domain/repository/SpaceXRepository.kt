package org.example.project.domain.repository

import org.example.project.domain.model.RocketLaunch

internal interface SpaceXRepository {
    suspend fun getLaunchList(forceReload: Boolean): List<RocketLaunch>
}