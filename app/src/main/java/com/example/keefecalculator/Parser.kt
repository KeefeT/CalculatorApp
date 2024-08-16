package com.example.keefecalculator

import android.util.Log
import androidx.compose.runtime.mutableStateOf
import androidx.core.text.isDigitsOnly
import kotlin.math.pow

class Parser {
    var input = mutableStateOf("")

    //evaluate reverse-polish notation string
    fun evaluate() {
        try {
            val rpn: String = stringToRPN(input.value)
            val tokens: List<String> = rpn.split(' ').filter { it != "" }
            val stack: ArrayDeque<Double> = ArrayDeque<Double>()
            for (token in tokens) {
                val d: Double? = token.toDoubleOrNull()

                if (d != null) {
                    stack.addFirst(d)
                } else if (token !in "+-*/^") {
                    throw IllegalArgumentException("$token is not a valid token")
                } else if (stack.size < 2) {
                    throw IllegalArgumentException("Stack contains too few operands")
                } else {
                    val d1 = stack.removeFirst()
                    val d2 = stack.removeFirst()
                    Log.i(TAG, "Performing operation: d1: $d1, d2: $d2, token: $token")
                    stack.add(when (token) {
                        "+" -> d2 + d1
                        "-" -> d2 - d1
                        "*" -> d1 * d2
                        "/" -> d1 / d2
                        else -> d2.pow(d1)
                    })
                }
            }

            input.value = stack.first().toString()
        } catch (e: Exception) {
            Log.e(TAG, "Exception: $e")
            input.value = "Err"
        }
    }

    //convert input string to reverse-polish notation
    private fun stringToRPN(expression: String): String {
        //send formatted strings like "42 + 42 / ( 2 * 2 )"
        //returns formatted strings like " "
        var output = ""
        val stack: ArrayDeque<String> = ArrayDeque<String>()
        val tokens: List<String> = expression.split(' ').filter { it != "" }

        for (token in tokens) {
            val d: Double? = token.toDoubleOrNull()

            if (d != null) {
                output += "$token " // space intentional
            } else if ("(" == token) {
                //stack push
                while (")" != stack.first()) {
                    //stack pop
                    output += stack.removeFirst() + " "
                }
            } else if (")" == token) {
                stack.addFirst(token)
            } else {
                while (!stack.isEmpty() && (getPriority(stack.first()) > getPriority(token))) {
                    output += stack.removeFirst() + " "
                }
                stack.addFirst(token)
            }
        }
        while (!stack.isEmpty()) {
            output += stack.removeFirst() + " "
        }
        Log.i(TAG, "RPN string: $output")
        return output
    }

    //return operator precedence (PEMDAS)
    private fun getPriority(op: String): Int {
        return when (op) {
            "(" -> 0
            "+", "-" -> 1
            "/", "*" -> 2
            else -> 3
        }
    }

    //clear input
    fun clear() {
        input.value = ""
    }

    //add token to input; handle formatting
    fun add(token: String) {
        Log.i(TAG, "Adding $token")
        input.value += if (token.isDigitsOnly() || "." == token || "(" == token || ")" == token) {
            //token is a single digit or decimal point, add to string
            //TODO refactor to use char
            token
        } else {
            //token is an operator, add operator with padding spaces
            //needed for parser
            " $token "
        }
        Log.i(TAG, "New input string: ${input.value}")
    }

    fun remove() {
        //remove last token and underlying space
        if (input.toString().isNotEmpty()) {
            val last = input.toString().last()
            if (last.isDigit() || '.' == last || '(' == last || ')' == last) {
                //just delete the one digit
                input.value = input.toString().dropLast(1)
            } else {
                //else character is a padding space or operator
                input.value = input.toString().dropLast(2)
            }
        }
    }
}