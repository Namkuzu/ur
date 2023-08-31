package com.namkuzo.ur.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog

@Composable
fun SupportImageDocumentDialog(
    title: String,
    firstButtonText: String,
    secondButtonText: String,
    textCancelButton: String,
    onDismissRequest: () -> Unit,
    onRequestDocument: () -> Unit,
    onRequestGallery: () -> Unit
) {
    Dialog(
        onDismissRequest = onDismissRequest
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .background(
                    color = MaterialTheme.colorScheme.secondaryContainer,
                    shape = RoundedCornerShape(size = 28.dp)
                )
                .padding(8.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.SpaceEvenly
        ) {
            Text(
                modifier = Modifier.padding(8.dp),
                text = title,
                fontWeight = FontWeight.SemiBold,
                color = MaterialTheme.colorScheme.primary
            )

            OutlinedButton(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 32.dp),
                onClick = onRequestDocument,
                colors = ButtonDefaults.buttonColors(
                    containerColor = MaterialTheme.colorScheme.primary,
                    contentColor = MaterialTheme.colorScheme.onPrimary
                )
            ) {
                Text(
                    text = firstButtonText,
                    color = MaterialTheme.colorScheme.onPrimary,
                )
            }

            OutlinedButton(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 32.dp),
                onClick = onRequestGallery,
                colors = ButtonDefaults.buttonColors(
                    containerColor = MaterialTheme.colorScheme.primary,
                    contentColor = MaterialTheme.colorScheme.onPrimary
                )
            ) {
                Text(
                    text = secondButtonText,
                    color = MaterialTheme.colorScheme.onPrimary,
                )
            }

            TextButton(
                onClick = onDismissRequest
            ) {
                Text(
                    modifier = Modifier.padding(8.dp),
                    text = textCancelButton,
                    color = MaterialTheme.colorScheme.primary,
                )
            }
        }
    }
}

/*
@Preview
@Composable
fun SupportImageDocumentDialogPreview() {
    MaterialTheme {
        SupportImageDocumentDialog(
            title = choose_option,
            firstButtonText = take_photo,
            secondButtonText = choose_image_from_gallery,
            textCancelButton = cancel,
            onDismissRequest = {},
            onRequestDocument = {},
            onRequestGallery = {}
        )
    }
}
*/
