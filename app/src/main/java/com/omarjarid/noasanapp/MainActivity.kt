package com.omarjarid.noasanapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.lifecycle.lifecycleScope
import com.omarjarid.noasanapp.presentation.MainScreen
import com.omarjarid.noasanapp.ui.theme.NoAsAnAppTheme
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    private var isLoading = true

    override fun onCreate(savedInstanceState: Bundle?) {
        val splashScreen = installSplashScreen()
        splashScreen.setKeepOnScreenCondition { isLoading }
        lifecycleScope.launch {
            delay(2000)
            isLoading = false
        }

        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            NoAsAnAppTheme { MainScreen() }
        }
    }
}