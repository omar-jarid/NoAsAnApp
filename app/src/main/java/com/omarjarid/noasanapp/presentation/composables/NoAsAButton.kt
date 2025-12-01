package com.omarjarid.noasanapp.presentation.composables

import androidx.compose.animation.animateContentSize
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import com.omarjarid.noasanapp.R

@Composable
fun NoAsAButton(modifier: Modifier = Modifier, stringId: Int, onButtonClick: () -> Unit) {
    Button(
        onClick = onButtonClick,
        colors = ButtonDefaults.buttonColors().copy(
            containerColor = MaterialTheme.colorScheme.onBackground,
            contentColor = MaterialTheme.colorScheme.background
        ),
        modifier = modifier.animateContentSize()
    ) {
        Text(
            stringResource(stringId),
            style = MaterialTheme.typography.labelLarge
        )
    }
}