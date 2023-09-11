package com.namkuzo.ur.ui

import androidx.annotation.DrawableRes
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.semantics.testTag
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun TemplateScreen(
    modifier: Modifier = Modifier,
    horizontalAlignment: Alignment.Horizontal = Alignment.CenterHorizontally,
    textHeader: String = "",
    onBackPressed: () -> Unit = {},
    content: @Composable () -> Unit
) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp)
            .background(color = MaterialTheme.colorScheme.background)
            .semantics { testTag = "$textHeader-screen" },
        horizontalAlignment = horizontalAlignment
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .clip(shape = RoundedCornerShape(8.dp))
        ) {
            TopBar(
                text = textHeader,
                style = titleTextStyle,
                onBackPressed = { onBackPressed() }
            )
        }
        Column(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(rememberScrollState()),
            horizontalAlignment = horizontalAlignment
        ) {
            content()
        }
    }
}

@Composable
private fun TopBar(
    modifier: Modifier = Modifier,
    text: String,
    style: TextStyle,
    @DrawableRes icon: Int? = null,
    onBackPressed: () -> Unit = {},
){
    Row(
        modifier = modifier
            .fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically
    ) {
        if (icon != null) {
            IconButton(
                modifier = Modifier.padding(horizontal = 8.dp),
                onClick = onBackPressed
            ) {
                Icon(
                    painter = painterResource(id = icon),
                    contentDescription = text,
                    tint = MaterialTheme.colorScheme.primary,
                )
            }

        }else {
            IconButton(
                modifier = Modifier.padding(horizontal = 8.dp),
                onClick = onBackPressed
            ) {
                Icon(
                    imageVector = Icons.Filled.ArrowBack,
                    contentDescription = text,
                    tint = MaterialTheme.colorScheme.primary,
                )
            }

        }
        Text(
            modifier = Modifier
                .fillMaxWidth(),
            text = text,
            style = style,
            color = MaterialTheme.colorScheme.primary,
            fontWeight = FontWeight.Medium
        )
    }
}

private val titleTextStyle = TextStyle(fontSize = 20.sp, fontWeight = FontWeight.Bold)
