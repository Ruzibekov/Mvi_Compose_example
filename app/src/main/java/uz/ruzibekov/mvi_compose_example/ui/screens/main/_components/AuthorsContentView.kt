package uz.ruzibekov.mvi_compose_example.ui.screens.main._components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import uz.ruzibekov.mvi_compose_example.data.model.Author
import uz.ruzibekov.mvi_compose_example.ui.screens.main._content.MainContentView

object AuthorsContentView {

    @Composable
    fun Default(list: List<Author>) {

        LazyColumn(
            modifier = Modifier.fillMaxSize(),
            contentPadding = PaddingValues(top = 20.dp, start = 20.dp, end = 20.dp, bottom = 10.dp)
        ) {

            items(list) {

                Item(data = it)
            }
        }
    }

    @Composable
    private fun Item(data: Author) {

        Card(
            modifier = Modifier.padding(bottom = 10.dp),
            shape = RoundedCornerShape(10.dp),
            colors = CardDefaults.cardColors(containerColor = Color.White),
            elevation = CardDefaults.cardElevation(2.dp)
        ) {

            Row(
                modifier = Modifier.padding(10.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {

                AsyncImage(
                    model = data.avatar,
                    contentDescription = "avatar image",
                    modifier = Modifier
                        .size(48.dp)
                        .clip(CircleShape)
                )

                Spacer(modifier = Modifier.width(10.dp))

                Column {

                    Text(text = data.first_name)

                    Text(text = data.last_name)
                }

                Spacer(modifier = Modifier.weight(1f))

                Text(text = data.email)
            }
        }
    }
}