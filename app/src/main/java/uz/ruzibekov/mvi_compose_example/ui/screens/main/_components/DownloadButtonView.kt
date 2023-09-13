package uz.ruzibekov.mvi_compose_example.ui.screens.main._components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

object DownloadButtonView {

    @Composable
    fun Default(onClick: () -> Unit) {

        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(bottom = 30.dp),
            contentAlignment = Alignment.BottomCenter
        ) {

            Button(onClick = onClick) {

                Text(text = "Download authors")
            }
        }
    }
}