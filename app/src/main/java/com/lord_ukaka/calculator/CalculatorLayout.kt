package com.lord_ukaka.calculator

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.lord_ukaka.calculator.ui.theme.CalculatorTheme
import com.lord_ukaka.calculator.ui.theme.LightGray
import com.lord_ukaka.calculator.ui.theme.MediumGray
import com.lord_ukaka.calculator.ui.theme.Orange

@Composable
fun CalculatorLayout(
    modifier: Modifier = Modifier,
    state: CalculatorState,
    buttonSpacing: Dp = 8.dp,
    onEvent: (CalculatorEvents) -> Unit
) {
    Box(modifier = modifier) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .align(Alignment.BottomCenter),
            verticalArrangement = Arrangement.spacedBy(buttonSpacing)
        ) {
            Column(
                modifier = Modifier
                    .weight(1f)
                    .padding(5.dp)
            ) {
                Text(
                    text = state.workingTV,
                    textAlign = TextAlign.End,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 6.dp),
                    fontWeight = FontWeight.Light,
                    fontSize = 30.sp,
                    color = Color.White,
                    maxLines = 2
                )
                Text(
                    text = state.resultTV,
                    textAlign = TextAlign.End,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 8.dp),
                    fontWeight = FontWeight.Bold,
                    fontSize = 50.sp,
                    color = Color.White,
                    maxLines = 1
                )
            }
            Column(
                modifier = Modifier.weight(3f),
                verticalArrangement = Arrangement.spacedBy(5.dp)
            ) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(buttonSpacing)
                ) {
                    CalculatorButton(
                        symbol = "AC",
                        modifier = Modifier
                            .background(LightGray)
                            .aspectRatio(2f)
                            .weight(2f),
                        onClick = {
                            onEvent(CalculatorEvents.Clear)
                        }
                    )
                    CalculatorButton(
                        symbol = "DEL",
                        modifier = Modifier
                            .background(LightGray)
                            .aspectRatio(1f)
                            .weight(1f),
                        onClick = {
                            onEvent(CalculatorEvents.Delete)
                        }
                    )
                    CalculatorButton(
                        symbol = "/",
                        modifier = Modifier
                            .background(Orange)
                            .aspectRatio(1f)
                            .weight(1f),
                        onClick = {
                            onEvent(CalculatorEvents.Operation(CalculatorOperation.Divide))
                        }
                    )
                }
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(buttonSpacing)
                ) {
                    CalculatorButton(
                        symbol = "7",
                        modifier = Modifier
                            .background(MediumGray)
                            .aspectRatio(1f)
                            .weight(1f),
                        onClick = {
                            onEvent(CalculatorEvents.Number(7))
                        }
                    )
                    CalculatorButton(
                        symbol = "8",
                        modifier = Modifier
                            .background(MediumGray)
                            .aspectRatio(1f)
                            .weight(1f),
                        onClick = {
                            onEvent(CalculatorEvents.Number(8))
                        }
                    )
                    CalculatorButton(
                        symbol = "9",
                        modifier = Modifier
                            .background(MediumGray)
                            .aspectRatio(1f)
                            .weight(1f),
                        onClick = {
                            onEvent(CalculatorEvents.Number(9))
                        }
                    )
                    CalculatorButton(
                        symbol = "x",
                        modifier = Modifier
                            .background(Orange)
                            .aspectRatio(1f)
                            .weight(1f),
                        onClick = {
                            onEvent(CalculatorEvents.Operation(CalculatorOperation.Multiply))
                        }
                    )
                }
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(buttonSpacing)
                ) {
                    CalculatorButton(
                        symbol = "4",
                        modifier = Modifier
                            .background(MediumGray)
                            .aspectRatio(1f)
                            .weight(1f),
                        onClick = {
                            onEvent(CalculatorEvents.Number(4))
                        }
                    )
                    CalculatorButton(
                        symbol = "5",
                        modifier = Modifier
                            .background(MediumGray)
                            .aspectRatio(1f)
                            .weight(1f),
                        onClick = {
                            onEvent(CalculatorEvents.Number(5))
                        }
                    )
                    CalculatorButton(
                        symbol = "6",
                        modifier = Modifier
                            .background(MediumGray)
                            .aspectRatio(1f)
                            .weight(1f),
                        onClick = {
                            onEvent(CalculatorEvents.Number(6))
                        }
                    )
                    CalculatorButton(
                        symbol = "-",
                        modifier = Modifier
                            .background(Orange)
                            .aspectRatio(1f)
                            .weight(1f),
                        onClick = {
                            onEvent(CalculatorEvents.Operation(CalculatorOperation.Subtract))
                        }
                    )
                }
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(buttonSpacing)
                ) {
                    CalculatorButton(
                        symbol = "1",
                        modifier = Modifier
                            .background(MediumGray)
                            .aspectRatio(1f)
                            .weight(1f),
                        onClick = {
                            onEvent(CalculatorEvents.Number(1))
                        }
                    )
                    CalculatorButton(
                        symbol = "2",
                        modifier = Modifier
                            .background(MediumGray)
                            .aspectRatio(1f)
                            .weight(1f),
                        onClick = {
                            onEvent(CalculatorEvents.Number(2))
                        }
                    )
                    CalculatorButton(
                        symbol = "3",
                        modifier = Modifier
                            .background(MediumGray)
                            .aspectRatio(1f)
                            .weight(1f),
                        onClick = {
                            onEvent(CalculatorEvents.Number(3))
                        }
                    )
                    CalculatorButton(
                        symbol = "+",
                        modifier = Modifier
                            .background(Orange)
                            .aspectRatio(1f)
                            .weight(1f),
                        onClick = {
                            onEvent(CalculatorEvents.Operation(CalculatorOperation.Add))
                        }
                    )
                }
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(buttonSpacing)
                ) {
                    CalculatorButton(
                        symbol = "0",
                        modifier = Modifier
                            .background(MediumGray)
                            .aspectRatio(2f)
                            .weight(2f),
                        onClick = {
                            onEvent(CalculatorEvents.Number(0))
                        }
                    )
                    CalculatorButton(
                        symbol = ".",
                        modifier = Modifier
                            .background(MediumGray)
                            .aspectRatio(1f)
                            .weight(1f),
                        onClick = {
                            onEvent(CalculatorEvents.Decimal)
                        }
                    )
                    CalculatorButton(
                        symbol = "=",
                        modifier = Modifier
                            .background(Orange)
                            .aspectRatio(1f)
                            .weight(1f),
                        onClick = {
                            onEvent(CalculatorEvents.Calculate)
                        }
                    )
                }
            }

        }
    }
}
@Preview
@Composable
fun CalculatorLayoutPreview() {
    CalculatorTheme {
        //CalculatorLayout(modifier = Modifier.fillMaxSize())
    }
}