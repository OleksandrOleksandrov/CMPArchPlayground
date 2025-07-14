package com.oleksandrov.cmp.arch.playground.epic.screen.composable

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.oleksandrov.cmp.arch.playground.epic.model.PictureOfDayUiModel

@Composable
fun PictureOfDay(
    modifier: Modifier = Modifier,
    pictureOfDayUiModel: PictureOfDayUiModel,
) {
//    val placeholder = android.R.drawable.ic_menu_gallery // TODO release placeholder
    Box(
        modifier = modifier.padding(8.dp),
    ) {
        ElevatedCard(
            elevation = CardDefaults.cardElevation(
                defaultElevation = 6.dp
            ),
        ) {
            Column(
                modifier = Modifier,
            ) {
//                AsyncImage(
//                    model = pictureOfDayUiModel.url.toUri(),
//                    contentScale = ContentScale.FillWidth,
//                    contentDescription = null,
//                    alignment = Alignment.CenterStart,
//                    placeholder = painterResource(id = placeholder),
//                    modifier = Modifier
//                        .fillMaxWidth()
//                )
            }
        }
    }
}
