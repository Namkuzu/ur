package com.namkuzo.ur.screen

import android.widget.Toast
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.namkuzo.ur.R
import com.namkuzo.ur.ui.Spinner
import com.namkuzo.ur.ui.TemplateScreen

@Composable
fun SpinnerScreen(
    onBack: () -> Unit,
){
    val context = LocalContext.current
    var isSpinnerRoundedExpanded by remember { mutableStateOf(false) }
    var isSpinnerDisabledExpanded by remember { mutableStateOf(false) }
    var isSpinnerSquareExpanded by remember { mutableStateOf(false) }

    TemplateScreen(
        textHeader = stringResource(id = R.string.spinner),
        onBackPressed = onBack
    ) {
        Spinner(
            modifier = Modifier.padding(16.dp),
            text = stringResource(id = R.string.t_new),
            items = getDummyList(),
            expanded = isSpinnerRoundedExpanded,
            onExpanded = { isSpinnerRoundedExpanded = !isSpinnerRoundedExpanded },
            onClick = { value ->
                Toast.makeText(context, "Click on: $value", Toast.LENGTH_SHORT).show()
            },
            content = { value ->
                Text(
                    modifier = Modifier.padding(horizontal = 8.dp, vertical = 16.dp),
                    text = value.toString()
                )
            }
        )

        Spinner(
            modifier = Modifier.padding(16.dp),
            text = stringResource(id = R.string.spinner),
            items = getDummyNamesList(),
            cornerShapeSize = 16.dp,
            isDisabled = true,
            expanded = isSpinnerDisabledExpanded,
            onExpanded = { isSpinnerDisabledExpanded = !isSpinnerDisabledExpanded },
            onClick = { value ->
                Toast.makeText(context, "Click on: $value", Toast.LENGTH_SHORT).show()
            },
            content = { value ->
                Text(
                    modifier = Modifier.padding(horizontal = 8.dp, vertical = 16.dp),
                    text = value
                )
            }
        )

        Spinner(
            modifier = Modifier.padding(16.dp),
            text = stringResource(id = R.string.spinner),
            items = getDummyNamesList(),
            cornerShapeSize = 8.dp,
            expanded = isSpinnerSquareExpanded,
            onExpanded = { isSpinnerSquareExpanded = !isSpinnerSquareExpanded },
            onClick = {},
            content = { value ->
                Text(
                    modifier = Modifier.padding(horizontal = 8.dp, vertical = 16.dp),
                    text = value
                )
            }
        )
    }
}

private fun getDummyList() = listOf(1, 2, 3, 4)
private fun getDummyNamesList(): List<String> = listOf("Bob", "Mark", "Jennifer", "Su")

@Preview
@Composable
fun SpinnerScreenPreview() {
    MaterialTheme {
        SpinnerScreen(){}
    }
}