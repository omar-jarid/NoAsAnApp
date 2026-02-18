package com.omarjarid.noasanapp.presentation

import android.content.ClipData
import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.ClipEntry
import androidx.compose.ui.platform.LocalClipboard
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.hilt.navigation.compose.hiltViewModel
import com.omarjarid.noasanapp.R
import com.omarjarid.noasanapp.presentation.composables.NoAsAButton
import com.omarjarid.noasanapp.ui.theme.Dimens
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainScreen(
    modifier: Modifier = Modifier
) {
    val context = LocalContext.current
    val clipboard = LocalClipboard.current
    val reasonViewModel = hiltViewModel<ReasonViewModel>()
    val reasonModel by reasonViewModel.reason.collectAsState()

    LaunchedEffect("error") {
        reasonViewModel.error.onEach {
            Toast.makeText(
                context,
                context.getString(R.string.something_went_wrong),
                Toast.LENGTH_LONG
            ).show()
        }.launchIn(scope = this)
    }

    Scaffold(
        topBar = {
            TopAppBar(title = { Text(stringResource(R.string.app_name)) })
        }
    ) { innerPadding ->
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
            modifier = modifier
                .fillMaxSize()
                .padding(innerPadding)
                .background(color = MaterialTheme.colorScheme.background)
        ) {
            Text(
                reasonModel.reason,
                textAlign = TextAlign.Center,
                style = MaterialTheme.typography.bodyLarge,
                color = MaterialTheme.colorScheme.onBackground,
                modifier = modifier.padding(Dimens.size16)
            )
            Spacer(modifier = modifier.height(Dimens.size16))
            if (reasonModel.reason.isNotEmpty()) NoAsAButton(stringId = R.string.copy_to_clipboard) {
                CoroutineScope(Dispatchers.Main).launch {
                    val clipData =
                        ClipData.newPlainText(reasonModel.reason, reasonModel.reason)
                    clipboard.setClipEntry(ClipEntry(clipData))
                }
            }
            NoAsAButton(stringId = R.string.get_a_new_rejection_reason) {
                reasonViewModel.getReason()
            }
        }
    }
}