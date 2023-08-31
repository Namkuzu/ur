package com.namkuzo.ur.ui

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AddBox
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.namkuzo.ur.R

@Composable
fun AddButton(
    modifier: Modifier = Modifier,
    text: String,
    colorIcon: Color = Color.Unspecified,
    onClick: () -> Unit
) {
    Row(
        modifier = modifier
            .clip(RoundedCornerShape(8.dp))
            .clickable { onClick() },
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(
            modifier = Modifier.padding(8.dp),
            imageVector = Icons.Filled.AddBox,
            contentDescription = stringResource(id = R.string.add),
            tint = colorIcon
        )
        Text(
            modifier = Modifier.padding(end = 8.dp),
            text = text,
            color = MaterialTheme.colorScheme.primary
        )
    }
}

/*
@Preview(showBackground = true, widthDp = 420)
@Composable
fun AddButtonPreview() {
    MaterialTheme() {
        AddButton(
            modifier = Modifier,
            text = title,
            onClick = {}
        )
    }
}
*/
