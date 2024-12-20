package com.example.movie.movie_popular_feature.presentation.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.DisabledByDefault
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import androidx.compose.ui.zIndex
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.rememberVectorPainter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import coil.compose.AsyncImage
import coil.request.ImageRequest

@Composable
fun MovieItem(
    modifier: Modifier = Modifier,
    voteAVerage:Double,
    imageUrl:String,
    id:Int,
    onclick:(id:Int)->Unit,
) {
    Box(modifier=modifier){
        MovieRate(
            rate = voteAVerage,
            modifier= Modifier
                .align(alignment = Alignment.Center)
                .zIndex(2f)
                .padding(start = 6.dp, bottom = 8.dp)
                .background(Color.Black)
        )
        Card(
            modifier = Modifier
                .fillMaxSize()
                .height(200.dp)
                .padding(6.dp)
                .clickable {
                    onclick(id)
                },
            shape = RoundedCornerShape(8.dp),
            elevation = CardDefaults.cardElevation(defaultElevation = 8.dp)
        ) {
            Box{
                AsyncImage(
                    model = ImageRequest.Builder(LocalContext.current)
                        .data(imageUrl)
                        .crossfade( true)
                        .build(),
                    contentDescription = "",
                    error = rememberVectorPainter(image = Icons.Default.DisabledByDefault),
                    contentScale = ContentScale.FillHeight,
                    modifier = Modifier
                        .fillMaxWidth()
                        .align(Alignment.BottomCenter)
                        .background(Color.Black)
                        .clip(RoundedCornerShape(8.dp))

                )
            }
        }
    }

}

