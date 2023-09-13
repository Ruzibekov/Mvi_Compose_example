package uz.ruzibekov.mvi_compose_example.ui.screens.main.state

import uz.ruzibekov.mvi_compose_example.data.model.Author

sealed class MainState {

    object Default : MainState()

    object Loading : MainState()

    object EmptyList : MainState()

    class ResponseData(val items: List<Author>) : MainState()

    class Error(val message: String?) : MainState()
}