package org.example.project.infra.repository

import org.example.project.domain.model.RocketLaunch
import org.example.project.domain.repository.SpaceXRepository
import org.example.project.infra.api.datasource.SpaceXRemoteDatasource
import org.example.project.infra.sqldelight.datasource.SpaceXLocalDatasource

internal class SpaceXRepositoryImpl(
    private val localDatasource: SpaceXLocalDatasource,
    private val remoteDatasource: SpaceXRemoteDatasource,
): SpaceXRepository {
    override suspend fun getLaunchList(forceReload: Boolean): List<RocketLaunch> = localDatasource.get(forceReload) {
        remoteDatasource.get()
    }
}