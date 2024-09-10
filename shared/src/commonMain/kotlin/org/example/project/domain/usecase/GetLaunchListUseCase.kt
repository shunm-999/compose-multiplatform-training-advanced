package org.example.project.domain.usecase

import org.example.project.domain.model.RocketLaunch
import org.example.project.domain.repository.SpaceXRepository

class GetLaunchListUseCase internal constructor(
    private val repository: SpaceXRepository,
) {
    suspend operator fun invoke(forceReload: Boolean): List<RocketLaunch> =
        repository.getLaunchList(forceReload)
}