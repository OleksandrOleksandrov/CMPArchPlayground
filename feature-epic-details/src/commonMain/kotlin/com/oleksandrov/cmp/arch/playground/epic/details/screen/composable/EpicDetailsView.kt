package com.oleksandrov.cmp.arch.playground.epic.details.screen.composable

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import coil3.ImageLoader
import coil3.compose.AsyncImage
import coil3.compose.LocalPlatformContext
import coil3.compose.setSingletonImageLoaderFactory
import coil3.network.ktor3.KtorNetworkFetcherFactory
import coil3.request.ImageRequest
import coil3.request.crossfade
import com.oleksandrov.cmp.arch.playground.epic.details.Platform
import com.oleksandrov.cmp.arch.playground.presentation.core.model.EpicUiModel

@Composable
fun EpicDetailsView(
    modifier: Modifier,
    model: EpicUiModel? = null,
) {
    val context = LocalPlatformContext.current
//    val imageLoader = ImageLoader.Builder(context)
//        .components {
//            add(
//                OkHttpNetworkFetcherFactory(
//                    callFactory = {
//                        OkHttpClient()
//                    }
//                )
//            )
//        }
//        .build()
    Column(
        modifier = modifier,
    ) {
        setSingletonImageLoaderFactory { context ->
            ImageLoader.Builder(context)
                .components {
//                    add(Platform().httpClientEngine)
//                    add(KtorNetworkFetcherFactory())
                }
                .build()
        }
        Text(
            model?.caption.orEmpty() + model?.date,
        )
        val imageRequest = ImageRequest.Builder(LocalPlatformContext.current)
            .data("https://static.vecteezy.com/system/resources/thumbnails/057/068/323/small/single-fresh-red-strawberry-on-table-green-background-food-fruit-sweet-macro-juicy-plant-image-photo.jpg")
            .build()
        AsyncImage(
            imageRequest,
//            model = "https://static.vecteezy.com/system/resources/thumbnails/057/068/323/small/single-fresh-red-strawberry-on-table-green-background-food-fruit-sweet-macro-juicy-plant-image-photo.jpg",
            contentScale = ContentScale.FillWidth,
            contentDescription = null,
            alignment = Alignment.CenterStart,
            onError = { error ->
                println(error)
            },
            modifier = Modifier
                .fillMaxWidth()
        )
    }
}