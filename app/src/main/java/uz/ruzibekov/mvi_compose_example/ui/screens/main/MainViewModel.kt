package uz.ruzibekov.mvi_compose_example.ui.screens.main

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import uz.ruzibekov.mvi_compose_example.data.api.ApiService
import uz.ruzibekov.mvi_compose_example.ui.screens.main.intent.MainEvent
import uz.ruzibekov.mvi_compose_example.ui.screens.main.state.MainState
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val service: ApiService
) : ViewModel() {

    private val _state: MutableStateFlow<MainState> = MutableStateFlow(MainState.Default)
    val state: StateFlow<MainState> = _state

    fun send(event: MainEvent.FetchAuthors) {

        when(event){

            is MainEvent.FetchAuthors -> fetchAuthors()
        }
    }

    private fun fetchAuthors() = viewModelScope.launch {
        _state.value = MainState.Loading

        try {
            val data = service.getAuthors()

            _state.value = if (data.data.isNotEmpty())
                MainState.ResponseData(data.data)
            else
                MainState.EmptyList

        } catch (e: Exception) {

            _state.value = MainState.Error(e.message)
        }
    }
}