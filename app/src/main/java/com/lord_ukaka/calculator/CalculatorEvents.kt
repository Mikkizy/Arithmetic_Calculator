package com.lord_ukaka.calculator

sealed class CalculatorEvents {
    data class Number(val number: Int): CalculatorEvents()
    data class Operation(val operation: CalculatorOperation): CalculatorEvents()
    object Clear: CalculatorEvents()
    object Decimal: CalculatorEvents()
    object Delete: CalculatorEvents()
    object Calculate: CalculatorEvents()
}