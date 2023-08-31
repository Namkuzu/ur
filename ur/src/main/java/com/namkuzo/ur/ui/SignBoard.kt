package com.namkuzo.ur.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

@Composable
fun SignBoard(
    modifier: Modifier = Modifier,
    title: String,
    heightBoard: Dp = heightDefault
) {
    Row(
        modifier = modifier,
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center
    ) {
        Spacer(
            modifier = Modifier
                .weight(1f)
                .padding(vertical = 8.dp)
                .height(heightBoard)
                .background(MaterialTheme.colorScheme.primary),
        )

        Text(
            modifier = Modifier
                .padding(horizontal = 16.dp),
            text = title,
            textAlign = TextAlign.Center,
            fontWeight = FontWeight.SemiBold,
            style = MaterialTheme.typography.titleMedium,
            color = MaterialTheme.colorScheme.primary
        )
        Spacer(
            modifier = Modifier
                .weight(1f)
                .padding(vertical = 8.dp)
                .height(heightBoard)
                .background(MaterialTheme.colorScheme.primary),
        )
    }
}

private val heightDefault = 2.dp

/*
@Preview(showBackground = true, widthDp = 420)
@Composable
fun SignBoardPreview(){
    MaterialTheme {
        SignBoard(
            title = title
        )
    }
}
*/
