package com.namkuzo.ur.ui

import androidx.compose.foundation.LocalIndication
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ExpandLess
import androidx.compose.material.icons.filled.ExpandMore
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.namkuzo.ur.R

@Composable
fun <T> Prompt(
    modifier: Modifier = Modifier,
    text: String,
    items: List<T>,
    cornerShapeSize: Dp = 28.dp,
    expanded: Boolean,
    isDisabled: Boolean = false,
    showTotal: Boolean = false,
    showIcon: Boolean = true,
    onClickExpanded: () -> Unit
) {
    val colorDisabled = if (isDisabled)
        MaterialTheme.colorScheme.outline
    else MaterialTheme.colorScheme.onPrimary

    OutlineBox(
        modifier = modifier,
        colorBackground = if (isDisabled)
            MaterialTheme.colorScheme.outlineVariant
        else MaterialTheme.colorScheme.primary,
        borderColor = if (isDisabled)
            MaterialTheme.colorScheme.outline
        else MaterialTheme.colorScheme.secondary,
        cornerShapeSize = cornerShapeSize
    ){
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .clip(RoundedCornerShape(8.dp))
                .clickable(
                    indication = if (!isDisabled) LocalIndication.current else null,
                    interactionSource = remember { MutableInteractionSource() }
                ) { onClickExpanded() },
            verticalAlignment = Alignment.CenterVertically
        ) {
            Row(
                modifier = Modifier
                    .padding(top = 16.dp, bottom = 16.dp, start = 16.dp, end = 8.dp)
                    .weight(1f)
            ) {
                Text(
                    text = text,
                    color = colorDisabled
                )
                if (items.isNotEmpty()) {
                    Text(
                        modifier = Modifier.padding(horizontal = 4.dp),
                        text = if (showTotal) "(${items.size})" else "",
                        color = colorDisabled
                    )
                }
            }
            if(showIcon){
                Icon(
                    modifier = Modifier.padding(horizontal = 16.dp),
                    imageVector =
                    if (expanded && !isDisabled)
                        Icons.Filled.ExpandLess
                    else
                        Icons.Filled.ExpandMore,
                    contentDescription = stringResource(R.string.expandable),
                    tint = if (!isDisabled) MaterialTheme.colorScheme.onPrimary else colorDisabled
                )
            }
        }
    }
}

/*
@Preview(showBackground = true, widthDp = 420)
@Composable
fun PromptPreview() {
    MaterialTheme() {
        Prompt(
            modifier = Modifier.padding(8.dp),
            text = "New",
            items = listOf("Test 1", "Test 2", "Test 3"),
            expanded = false,
            isDisabled = true,
            showTotal = true,
            onClickExpanded = {}
        )
    }
}*/
