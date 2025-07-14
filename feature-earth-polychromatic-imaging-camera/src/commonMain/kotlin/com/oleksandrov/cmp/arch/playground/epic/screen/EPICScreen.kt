package com.oleksandrov.cmp.arch.playground.epic.screen

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.oleksandrov.cmp.arch.playground.epic.model.EpicUiModel
import org.koin.compose.viewmodel.koinViewModel

@Composable
fun EPICScreen(navigateToDetails: (EpicUiModel) -> Unit) {

    val viewModel: EPICViewModel = koinViewModel()
    val epicList = viewModel.epicList.collectAsStateWithLifecycle(emptyList())
    val apod = viewModel.apod.collectAsStateWithLifecycle(null)

    EPICContent(
        modifier = Modifier,
        pictureOfDayUiModel = apod.value,
        list = epicList.value ?: emptyList(),
        navigateToDetails = navigateToDetails
    )
}