package com.namkuzo.ur.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.sizeIn
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.rememberVectorPainter
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp


@Composable
fun CardButton(
    modifier: Modifier = Modifier,
    icon: ImageVector,
    iconDescription: String,
    text: String,
    onClick: () -> Unit,
){
    CardButton(
        modifier = modifier,
        icon = rememberVectorPainter(icon),
        iconDescription = iconDescription,
        text = text,
        onClick = onClick)
}

@Composable
fun CardButton(
    modifier: Modifier = Modifier,
    icon: Painter,
    iconDescription: String,
    text: String,
    onClick: () -> Unit,
){
    FloatingActionButton(
        modifier = modifier.defaultMinSize(minWidth = 128.dp),
        onClick = onClick
    ) {
        Column(
            modifier = Modifier
                .sizeIn(minWidth = 128.dp, maxWidth = 160.dp)
                .padding(vertical = 16.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Icon(
                painter = icon,
                contentDescription = iconDescription
            )
            Text(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 8.dp, horizontal = 8.dp),
                text = text,
                textAlign = TextAlign.Center
            )
        }
    }
}