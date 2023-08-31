package com.namkuzo.ur.screen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.namkuzo.ur.R
import com.namkuzo.ur.buttonsScreen
import com.namkuzo.ur.dialogsScreen
import com.namkuzo.ur.spinnerScreen
import com.namkuzo.ur.ui.ActionButton
import com.namkuzo.ur.ui.SignBoard

@Composable
fun MenuScreen(
    onPageSelected: (String) -> Unit,
) {
    Column {
        SignBoard(
            modifier = Modifier.padding(top = 8.dp),
            title = stringResource(id = R.string.buttons).uppercase()
        )
        ActionButton(
            modifier = Modifier.padding(16.dp),
            text = stringResource(id = R.string.buttons),
            cornerShapeSize = 28.dp
        ) {
            onPageSelected(buttonsScreen)
        }
        SignBoard(
            modifier = Modifier.padding(top = 16.dp),
            title = stringResource(id = R.string.dialogs).uppercase(),
        )
        ActionButton(
            modifier = Modifier.padding(16.dp),
            text = stringResource(id = R.string.dialogs),
            cornerShapeSize = 28.dp
        ) {
            onPageSelected(dialogsScreen)
        }
        SignBoard(
            modifier = Modifier.padding(top = 16.dp),
            title = stringResource(id = R.string.spinner).uppercase(),
        )
        ActionButton(
            modifier = Modifier.padding(16.dp),
            text = stringResource(id = R.string.spinner),
            cornerShapeSize = 28.dp
        ) {
            onPageSelected(spinnerScreen)
        }
    }
}

@Preview(showBackground = true, widthDp = 400, heightDp = 600)
@Composable
fun MenuScreenPreview() {
    MaterialTheme {
        MenuScreen(onPageSelected = {})
    }
}