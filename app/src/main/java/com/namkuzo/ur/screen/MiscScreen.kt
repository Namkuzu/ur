package com.namkuzo.ur.screen

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.namkuzo.ur.R
import com.namkuzo.ur.ui.OutlineBox
import com.namkuzo.ur.ui.SwipeToDelete
import com.namkuzo.ur.ui.TemplateScreen

@Composable
fun MiscScreen(
    onBack: () -> Unit,
){
    TemplateScreen(
        textHeader = stringResource(id = R.string.misc),
        isScrollable = false,
        onBackPressed = onBack
    ) {

/*        SwipeToDelete(
            items = listOf("Test A", "Test B", "Test C"),
            onDelete = {},
            content = {
                OutlineBox() {
                    Text(
                        modifier = Modifier.padding(16.dp),
                        text = stringResource(id = R.string.app_name)
                    )
                }
            }
        )*/

        LazyColumn(){
            items(items = listOf("Test A", "Test B", "Test C")){ value ->
                SwipeToDelete(
                    modifier = Modifier.padding(8.dp),
                    content = {
                        OutlineBox() {
                            Text(
                                modifier = Modifier.padding(16.dp),
                                text = value
                            )
                        }
                    }
                )
            }
        }

        SwipeToDelete(
            modifier = Modifier.padding(8.dp),
            content = {
                OutlineBox() {
                    Text(
                        modifier = Modifier.padding(16.dp),
                        text = stringResource(id = R.string.camera)
                    )
                }
            }
        )
    }
}