package com.namkuzo.ur.screen

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.namkuzo.ur.R
import com.namkuzo.ur.ui.DialogMessage
import com.namkuzo.ur.ui.SupportImageDocumentDialog
import com.namkuzo.ur.ui.TemplateScreen

@Composable
fun DialogsScreen(
    onBack: () -> Unit,
){
    TemplateScreen(
        textHeader = stringResource(id = R.string.dialogs),
        onBackPressed = onBack
    ) {
        var showDialog by remember { mutableStateOf(false) }
        var showImageDocumentDialog by remember { mutableStateOf(false) }

        Button(
            modifier = Modifier.padding(16.dp),
            onClick = { showDialog = true }
        ) {
            Text(text = stringResource(id = R.string.show_dialog))
        }

        Button(
            modifier = Modifier.padding(16.dp),
            onClick = { showImageDocumentDialog = true }
        ) {
            Text(text = stringResource(id = R.string.support_image_document_dialog))
        }

        if (showDialog) {
            DialogMessage(
                title = stringResource(id = R.string.hello),
                body = stringResource(id = R.string.welcome),
                textButton = stringResource(id = R.string.accept),
                onDismiss = { showDialog = false },
            )
        }

        if (showImageDocumentDialog) {
            SupportImageDocumentDialog(
                title = stringResource(id = R.string.choose_option),
                firstButtonText = stringResource(id = R.string.take_photo),
                secondButtonText = stringResource(id = R.string.choose_from_gallery),
                textCancelButton = stringResource(id = R.string.cancel),
                onDismissRequest = { showImageDocumentDialog = false },
                onRequestDocument = {},
                onRequestGallery = {}
            )
        }
    }
}

@Preview(showBackground = true, widthDp = 400, heightDp = 600)
@Composable
fun DialogsScreenPreview(){
    MaterialTheme {
        DialogsScreen {}
    }
}