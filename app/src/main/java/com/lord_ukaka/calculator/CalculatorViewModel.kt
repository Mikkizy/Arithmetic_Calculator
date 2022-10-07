package com.lord_ukaka.calculator

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel

class CalculatorViewModel: ViewModel() {
    var state by mutableStateOf(CalculatorState())
        private set
    private var canAddOperation = false
    private var canAddDecimal = true
    fun onEvent(event: CalculatorEvents) {
        when(event) {
            is CalculatorEvents.Number -> enterNumber(event.number)
            is CalculatorEvents.Decimal -> enterDecimal()
            is CalculatorEvents.Clear -> state = CalculatorState()
            is CalculatorEvents.Calculate -> performCalculation()
            is CalculatorEvents.Operation -> enterOperation(event.operation)
            is CalculatorEvents.Delete -> performDeletion()
        }
    }

    private fun enterDecimal() {
        if (canAddDecimal) {
            state = state.copy(workingTV = state.workingTV + '.')
            canAddDecimal = false
        }
    }

    private fun performCalculation() {
        state = state.copy(resultTV = calculateResults())
    }

    private fun calculateResults(): String {
        val digitsOperator = digitOperators()
        if (digitsOperator.isEmpty()) return ""

        val timeDivision = timeDivisionCalculate(digitsOperator)
        if (timeDivision.isEmpty()) return ""

        val result = addSubtractCalculate(timeDivision)
        return result.toString().take(10)
    }

    private fun addSubtractCalculate(passedList: MutableList<Any>): Float {
        var result = passedList[0] as Float
        for (i in passedList.indices) {
            if (passedList[i] is Char && i != passedList.lastIndex) {
                val operator = passedList[i]
                val nextDigit = passedList[1 + 1] as Float
                if (operator == '+') result += nextDigit
                if (operator == '-') result -= nextDigit
            }
        }
        return result
    }

    private fun timeDivisionCalculate(passedList: MutableList<Any>): MutableList<Any> {
        var list = passedList
        while (list.contains('x') || list.contains('/')) {
            list = calculateTimesDivide(list)
        }
        return list
    }

    private fun calculateTimesDivide(passedList: MutableList<Any>): MutableList<Any> {
        val newList = mutableListOf<Any>()
        var restartIndex = passedList.size
        for (i in passedList.indices) {
            if (passedList[i] is Char && i != passedList.lastIndex && i < restartIndex) {
                val operator = passedList[i]
                val previousDigit = passedList[i-1] as Float
                val nextDigit = passedList[i+1]  as Float
                when(operator) {
                    '/' -> {
                        newList.add(previousDigit / nextDigit)
                        restartIndex = i + 1
                    }
                    'x' -> {
                        newList.add(previousDigit * nextDigit)
                        restartIndex = i + 1
                    }
                    else -> {
                        newList.add(previousDigit)
                        newList.add(operator)
                    }
                }
            }
            if (i > restartIndex) {
                newList.add(passedList[i])
            }

        }
        return newList
    }

    private fun digitOperators(): MutableList<Any> {
        val list = mutableListOf<Any>()
        var currentDigit = ""
        for (character in state.workingTV) {
            if (character.isDigit() || character == '.' ) currentDigit += character
            else {
                list.add(currentDigit.toFloat())
                currentDigit = ""
                list.add(character)
            }
        }
        if (currentDigit.isNotBlank()) list.add(currentDigit.toFloat())
        return list
    }

    private fun enterOperation(operation: CalculatorOperation) {
        if (canAddOperation) {
            state = state.copy(workingTV = state.workingTV + operation.symbol)
            canAddOperation = false
            canAddDecimal = true
        }
    }

    private fun performDeletion() {
        when {
            state.workingTV.isNotBlank() -> state = state.copy(state.workingTV.dropLast(1))
        }
    }

    private fun enterNumber(number: Int) {
        state = state.copy(workingTV = state.workingTV + number)
        canAddOperation = true
    }
}