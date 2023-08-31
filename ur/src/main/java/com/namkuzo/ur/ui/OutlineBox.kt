package com.namkuzo.ur.ui

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

@Composable
fun OutlineBox(
    modifier: Modifier = Modifier,
    colorBackground: Color = MaterialTheme.colorScheme.background,
    borderColor: Color = MaterialTheme.colorScheme.secondary,
    borderWidth: Dp = 2.dp,
    cornerShapeSize: Dp = 28.dp,
    content: @Composable () -> Unit
) {
    Surface(
        modifier = modifier.fillMaxWidth(),
        color = colorBackground,
        shape = RoundedCornerShape(cornerShapeSize),
        border = BorderStroke(borderWidth, borderColor)
    ) {
        content()
    }
}
/*

@Preview(showBackground = true, widthDp = 420)
@Composable
fun OutlineBoxPreview() {
    MaterialTheme {
        OutlineBox(modifier = Modifier.padding(16.dp)) {
            Text(
                modifier = Modifier.padding(16.dp),
                text = title
            )
        }
    }
}
*/
