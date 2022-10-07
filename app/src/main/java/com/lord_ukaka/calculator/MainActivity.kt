package com.lord_ukaka.calculator

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.lord_ukaka.calculator.ui.theme.CalculatorTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CalculatorTheme {
                val viewModel = viewModels<CalculatorViewModel>()
                val state = viewModel.value.state
                val buttonSpacing = 8.dp
                CalculatorLayout(
                    modifier = Modifier
                        .fillMaxSize()
                        .background(Color.DarkGray)
                        .padding(16.dp),
                    state = state,
                    onEvent = viewModel.value::onEvent,
                    buttonSpacing = buttonSpacing
                )
            }
        }
    }
}
