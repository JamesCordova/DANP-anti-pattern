package com.aero.antypattern

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.aero.antypattern.ui.antipattern.AntiPatternScreen
import com.aero.antypattern.ui.antipattern.KeysImprovedScreen
import com.aero.antypattern.ui.antipattern.SnapshotStateListScreen
import com.aero.antypattern.ui.antipattern.StatePerItemScreen
import com.aero.antypattern.ui.theme.AntyPatternTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AntyPatternTheme {
                SnapshotStateListScreen()
            }
        }
    }
}