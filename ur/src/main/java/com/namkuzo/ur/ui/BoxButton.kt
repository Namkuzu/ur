package com.namkuzo.ur.ui

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.unit.dp

@Composable
fun BoxButton(
    modifier: Modifier = Modifier,
    icon: Painter,
    iconDescription: String,
    text: String,
    placeholder: String = "",
    isCompleted: Boolean = false,
    onClick: () -> Unit,
) {
    OutlineBox(
        modifier = modifier,
        borderWidth = 1.dp,
        cornerShapeSize = 4.dp
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .clip(RoundedCornerShape(8.dp))
                .clickable { onClick() }
        ) {
            Row(
                modifier = Modifier
                    .padding(vertical = 16.dp, horizontal = 16.dp)
                    .weight(1f),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Icon(
                    modifier = Modifier,
                    painter = icon,
                    contentDescription = iconDescription,
                    tint = when (isCompleted) {
                        true -> MaterialTheme.colorScheme.primary
                        false -> MaterialTheme.colorScheme.outline
                    }
                )

                if (isCompleted) {
                    Text(
                        modifier = Modifier.padding(start = 8.dp),
                        text = text,
                        color = MaterialTheme.colorScheme.primary
                    )
                } else {
                    Text(
                        modifier = Modifier.padding(start = 8.dp),
                        text = placeholder,
                        color = MaterialTheme.colorScheme.outline
                    )
                }

            }
        }
    }
}
