package org.example.project.infra.api.datasource

import org.example.project.domain.model.RocketLaunch
import org.example.project.infra.api.list.SpaceXApi

internal class SpaceXRemoteDatasource(
    private val spaceXApi: SpaceXApi,
) {

    suspend fun get(): List<RocketLaunch> {
        return spaceXApi.getLaunches()
    }
}