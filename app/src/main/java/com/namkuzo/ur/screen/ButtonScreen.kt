package com.namkuzo.ur.screen

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.namkuzo.ur.R
import com.namkuzo.ur.ui.ActionButton
import com.namkuzo.ur.ui.AddButton
import com.namkuzo.ur.ui.BoxButton
import com.namkuzo.ur.ui.TemplateScreen

@Composable
fun ButtonScreen(
    onBack: () -> Unit,
){
    TemplateScreen(
        textHeader = stringResource(id = R.string.buttons),
        onBackPressed = onBack
    ) {
        ActionButton(
            modifier = Modifier.padding(16.dp),
            text = stringResource(id = R.string.app_name),
            iconRight = painterResource(id = R.drawable.ic_arrow_right),
            description = stringResource(R.string.arrow_right),
            onClick = {}
        )
        ActionButton(
            modifier = Modifier.padding(16.dp),
            text = stringResource(id = R.string.app_name),
            iconRight = painterResource(id = R.drawable.ic_arrow_right),
            description = stringResource(R.string.arrow_right),
            isInProcess = true,
            onClick = {}
        )

        ActionButton(
            modifier = Modifier.padding(16.dp),
            text = stringResource(id = R.string.app_name),
            iconRight = painterResource(id = R.drawable.ic_arrow_right),
            description = stringResource(R.string.arrow_right),
            isDisabled = true,
            onClick = {}
        )

        AddButton(
            text = stringResource(id = R.string.app_name),
            colorIcon = MaterialTheme.colorScheme.primary,
            onClick = { }
        )

        BoxButton(
            modifier = Modifier.padding(16.dp),
            icon = painterResource(id = R.drawable.ic_camera),
            iconDescription = stringResource(id = R.string.app_name),
            text = stringResource(id = R.string.app_name),
            placeholder = stringResource(id = R.string.buttons),
            onClick = {}
        )

        BoxButton(
            modifier = Modifier.padding(16.dp),
            icon = painterResource(id = R.drawable.ic_camera),
            iconDescription = stringResource(id = R.string.app_name),
            text = stringResource(id = R.string.app_name),
            placeholder = stringResource(id = R.string.buttons),
            isCompleted = true,
            onClick = {}
        )
    }
}

@Preview(showBackground = true, widthDp = 400, heightDp = 600)
@Composable
fun ButtonScreenPreview(){
    MaterialTheme {
        ButtonScreen {}
    }
}
