package com.namkuzo.ur.ui

import androidx.compose.animation.animateContentSize
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

@Composable fun <T> Spinner(
    modifier: Modifier = Modifier,
    text: String,
    items: List<T> = listOf(),
    cornerShapeSize: Dp = 28.dp,
    isDisabled: Boolean = false,
    showTotal: Boolean = false,
    showIcon: Boolean = true,
    expanded: Boolean = false,
    onExpanded: (Boolean)->Unit,
    onClick: (T) -> Unit,
    content: @Composable (T)->Unit
){
    Spinner(
        modifier = modifier,
        text = text,
        items = items,
        cornerShapeSize = cornerShapeSize,
        isDisabled = isDisabled,
        showTotal = showTotal,
        showIcon = showIcon,
        expanded = expanded,
        onExpanded = onExpanded,
        content = { value ->
            ItemSpinner(
                item = value,
                cornerShapeSize = cornerShapeSize,
                onClick = { onClick(value) },
                content = { content(value) }
            )
        }
    )
}
@Composable
private fun <T> Spinner(
    modifier: Modifier = Modifier,
    text: String,
    items: List<T> = listOf(),
    cornerShapeSize: Dp = 28.dp,
    isDisabled: Boolean = false,
    showTotal: Boolean = false,
    showIcon: Boolean = true,
    expanded: Boolean = false,
    onExpanded: (Boolean)->Unit,
    content: @Composable (T)->Unit
){
    Column(
        modifier = modifier.animateContentSize()
    ) {
        Prompt(
            text = text,
            items = items,
            cornerShapeSize = cornerShapeSize,
            expanded = expanded,
            isDisabled = isDisabled,
            showTotal = showTotal,
            showIcon = showIcon,
            onClickExpanded = { onExpanded(!expanded) })

        if ((expanded and items.isNotEmpty() and !isDisabled)){
            OutlineBox(
                modifier = Modifier.offset(y = (-2).dp),
                cornerShapeSize = cornerShapeSize
            ) {
                Column(
                    modifier = Modifier.padding(vertical = 8.dp)
                ) {
                    items.forEach {item ->
                        content(item)
                    }
                }
            }
        }
    }
}

@Composable
private fun <T> ItemSpinner(
    modifier: Modifier = Modifier,
    cornerShapeSize: Dp = 28.dp,
    item: T,
    content: @Composable ()->Unit,
    onClick: (T) -> Unit
){
    Row(
        modifier = modifier
            .fillMaxWidth()
            .padding(horizontal = 8.dp)
            .clip(RoundedCornerShape(cornerShapeSize))
            .clickable { onClick(item) },
        verticalAlignment = Alignment.CenterVertically
    ) {
        content()
    }
}

/*
@Preview(showBackground = true, widthDp = 420)
@Composable
fun SpinnerPreview(){
    MaterialTheme() {
        Spinner(
            modifier = Modifier.padding(8.dp),
            text = "New",
            items = listOf("Test 1", "Test 2", "Test 3"),
            showTotal = true,
            expanded = false,
            onExpanded = {},
            content = {}
        )
    }
}
*/
