package uz.ruzibekov.mvi_compose_example.ui.screens.base

import android.os.Bundle
import android.os.PersistableBundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import uz.ruzibekov.mvi_compose_example.ui.theme.Mvi_Compose_exampleTheme

abstract class BaseActivity : ComponentActivity() {

    abstract val content: @Composable () -> Unit

    abstract fun initialize()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            Mvi_Compose_exampleTheme {
                content()
            }
        }

        initialize()
    }
}