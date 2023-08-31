package com.namkuzo.ur.ui

import androidx.compose.foundation.LocalIndication
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.namkuzo.ur.R

@Composable
fun ActionButton(
    modifier: Modifier = Modifier,
    text: String,
    iconRight: Painter = painterResource(id = R.drawable.ic_arrow_right),
    description: String = stringResource(R.string.arrow_right),
    cornerShapeSize: Dp = 28.dp,
    isDisabled: Boolean = false,
    isCompleted: Boolean = false,
    isInProcess: Boolean = false,
    onClick: () -> Unit
) {
    OutlineBox(
        modifier = modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(cornerShapeSize))
            .clickable(
                indication = if (!isDisabled) LocalIndication.current else null,
                interactionSource = remember { MutableInteractionSource() }
            ) { if (!isDisabled) onClick() },
        colorBackground = when {
            isInProcess -> MaterialTheme.colorScheme.tertiary
            isDisabled -> MaterialTheme.colorScheme.outlineVariant
            isCompleted -> MaterialTheme.colorScheme.primary
            else -> MaterialTheme.colorScheme.surface
        },
        borderColor = when {
            isInProcess -> MaterialTheme.colorScheme.tertiary
            isDisabled -> MaterialTheme.colorScheme.outline
            isCompleted -> MaterialTheme.colorScheme.primary
            else -> MaterialTheme.colorScheme.primary
        },
        cornerShapeSize = cornerShapeSize
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                modifier = Modifier
                    .weight(1f)
                    .padding(16.dp),
                text = text,
                color = when {
                    isInProcess -> MaterialTheme.colorScheme.onTertiary
                    isDisabled -> MaterialTheme.colorScheme.outline
                    isCompleted -> MaterialTheme.colorScheme.onPrimary
                    else -> MaterialTheme.colorScheme.primary
                }
            )

            Icon(
                modifier = Modifier.padding(horizontal = 16.dp),
                painter = iconRight,
                contentDescription = description,
                tint = when {
                    isInProcess -> MaterialTheme.colorScheme.onTertiary
                    isDisabled -> MaterialTheme.colorScheme.outline
                    isCompleted -> MaterialTheme.colorScheme.onPrimary
                    else -> MaterialTheme.colorScheme.primary
                }
            )
        }
    }
}

/*
@Preview(showBackground = true, widthDp = 420)
@Composable
fun ActionButtonEnabledPreview() {
    MaterialTheme() {
        ActionButton(
            modifier = Modifier,
            text = title,
            iconRight = painterResource(id = R.drawable.ic_arrow_right),
            description = stringResource(R.string.arrow_right),
            onClick = {}
        )
    }
}

@Preview(showBackground = true, widthDp = 420)
@Composable
fun ActionButtonCompletedPreview() {
    MaterialTheme() {
        ActionButton(
            modifier = Modifier,
            text = title,
            iconRight = painterResource(id = R.drawable.ic_arrow_right),
            description = stringResource(R.string.arrow_right),
            isCompleted = true,
            onClick = {},
        )
    }
}

@Preview(showBackground = true, widthDp = 420)
@Composable
fun ActionButtonInProcessPreview() {
    MaterialTheme() {
        ActionButton(
            modifier = Modifier,
            text = title,
            iconRight = painterResource(id = R.drawable.ic_arrow_right),
            description = stringResource(R.string.arrow_right),
            isInProcess = true,
            onClick = {}
        )
    }
}

@Preview(showBackground = true, widthDp = 420)
@Composable
fun ActionButtonDisabledPreview() {
    MaterialTheme() {
        ActionButton(
            modifier = Modifier,
            text = title,
            iconRight = painterResource(id = R.drawable.ic_arrow_right),
            description = stringResource(R.string.arrow_right),
            isDisabled = true,
            onClick = {},
        )
    }
}
*/
