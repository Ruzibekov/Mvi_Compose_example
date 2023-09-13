package uz.ruzibekov.mvi_compose_example.ui.screens.main.intent

sealed class MainIntent {

    object FetchAuthors : MainIntent()
}