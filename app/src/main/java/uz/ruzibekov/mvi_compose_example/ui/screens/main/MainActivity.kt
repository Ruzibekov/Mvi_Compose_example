package uz.ruzibekov.mvi_compose_example.ui.screens.main

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import dagger.hilt.android.AndroidEntryPoint
import uz.ruzibekov.mvi_compose_example.ui.screens.base.BaseActivity
import uz.ruzibekov.mvi_compose_example.ui.screens.main._content.MainContentView
import uz.ruzibekov.mvi_compose_example.ui.theme.Mvi_Compose_exampleTheme

@AndroidEntryPoint
class MainActivity : BaseActivity() {

    private val viewModel: MainViewModel by viewModels()

    override val content: @Composable () -> Unit = {
        MainContentView.Default(viewModel = viewModel)
    }

    override fun initialize() {}

}