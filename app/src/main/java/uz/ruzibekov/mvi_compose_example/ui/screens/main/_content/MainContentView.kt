package uz.ruzibekov.mvi_compose_example.ui.screens.main._content

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import uz.ruzibekov.mvi_compose_example.ui.screens.main.MainViewModel
import uz.ruzibekov.mvi_compose_example.ui.screens.main._components.AuthorsContentView
import uz.ruzibekov.mvi_compose_example.ui.screens.main._components.DownloadButtonView
import uz.ruzibekov.mvi_compose_example.ui.screens.main._components.EmptyListView
import uz.ruzibekov.mvi_compose_example.ui.screens.main._components.ErrorView
import uz.ruzibekov.mvi_compose_example.ui.screens.main._components.ProgressView
import uz.ruzibekov.mvi_compose_example.ui.screens.main.intent.MainIntent
import uz.ruzibekov.mvi_compose_example.ui.screens.main.state.MainState

object MainContentView {

    @Composable
    fun Default(viewModel: MainViewModel) {

        val state by viewModel.state.collectAsState()

        when (state) {

            is MainState.Default -> DownloadButtonView.Default {
                viewModel.fetchAuthors()
            }

            is MainState.Loading -> ProgressView.Default()

            is MainState.EmptyList -> EmptyListView.Default()

            is MainState.ResponseData -> AuthorsContentView.Default((state as MainState.ResponseData).items)

            is MainState.Error -> ErrorView.Default((state as MainState.Error).message.toString())
        }
    }

}