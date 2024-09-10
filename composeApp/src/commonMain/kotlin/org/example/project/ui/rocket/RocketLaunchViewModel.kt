package org.example.project.ui.rocket

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import org.example.project.domain.model.RocketLaunch
import org.example.project.domain.usecase.GetLaunchListUseCase


internal sealed interface RocketLaunchScreenUiState {
    data object Loading : RocketLaunchScreenUiState
    data class Success(val launches: List<RocketLaunch>) : RocketLaunchScreenUiState
    data class Error(val message: String) : RocketLaunchScreenUiState
}

internal class RocketLaunchViewModel(
    private val useCase: GetLaunchListUseCase,
) : ViewModel(), RocketLaunchUiStateHolder {

    override var uiState by mutableStateOf<RocketLaunchScreenUiState>(RocketLaunchScreenUiState.Loading)
        private set

    init {
        loadLaunches()
    }

    private fun loadLaunches() {
        viewModelScope.launch {
            loadingScope {
                val launches = useCase(
                    forceReload = true
                )
                RocketLaunchScreenUiState.Success(
                    launches = launches
                )
            }
        }
    }

    private inline fun loadingScope(operate: () -> RocketLaunchScreenUiState) {
        uiState = RocketLaunchScreenUiState.Loading
        uiState = try {
            operate()
        } catch (e: Exception) {
            RocketLaunchScreenUiState.Error(e.message ?: "Unknown Error")
        }
    }
}