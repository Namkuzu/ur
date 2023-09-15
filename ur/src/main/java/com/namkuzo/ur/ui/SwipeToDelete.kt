package com.namkuzo.ur.ui

import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material3.DismissDirection
import androidx.compose.material3.DismissValue
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.SwipeToDismiss
import androidx.compose.material3.rememberDismissState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.namkuzo.ur.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun <T> SwipeToDelete(
    modifier: Modifier = Modifier,
    items: List<T>,
    itemId: Int,
    onDelete: () -> Unit,
    distanceToSwipe: Float = 0.30f,
    backgroundColor: Color = Color.Red,
    deleteIcon: ImageVector = Icons.Default.Delete,
    deleteIconColor: Color = Color.White,
    content: @Composable (T) -> Unit

) {
    LazyColumn(modifier = modifier.fillMaxSize()) {
        items(items = items, key = { item -> item.hashCode() }) {
            val dismissState = rememberDismissState(
                confirmValueChange = {
                    onDelete()
                    true
                },
                positionalThreshold = { totalDistance ->
                    (totalDistance * distanceToSwipe)
                }
            )
            SwipeToDismiss(
                state = dismissState,
                directions = setOf(DismissDirection.EndToStart),
                background = {

                    val color by animateColorAsState(
                        when (dismissState.targetValue) {
                            DismissValue.DismissedToStart -> backgroundColor
                            else -> Color.Transparent
                        }, label = ""
                    )

                    val scale by animateFloatAsState(
                        if (dismissState.targetValue == DismissValue.Default) 0.75f else 1f,
                        label = ""
                    )

                    Box(
                        Modifier
                            .fillMaxSize()
                            .background(color)
                            .padding(horizontal = 20.dp),
                        contentAlignment = Alignment.CenterEnd
                    ) {
                        Icon(
                            deleteIcon,
                            contentDescription = stringResource(R.string.delete_icon),
                            modifier = Modifier.scale(scale),
                            tint = deleteIconColor
                        )
                    }
                },
                dismissContent = {
                    content
                }
            )
        }
    }
}