package uz.ruzibekov.mvi_compose_example.ui.screens.main.intent

sealed class MainEvent {

    object FetchAuthors : MainEvent()
}