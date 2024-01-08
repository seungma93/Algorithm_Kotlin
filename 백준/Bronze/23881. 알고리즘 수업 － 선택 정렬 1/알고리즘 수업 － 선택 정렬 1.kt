package com.example.algorithmtest

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.StringTokenizer
import kotlin.collections.component1
import kotlin.collections.component2
import kotlin.collections.map


var exchangeCount = 0

fun main(): Unit = with(BufferedReader(InputStreamReader(System.`in`))) {
    val (n, k) = readLine()!!.split(" ").map { it.toInt() }
    val a = StringTokenizer(readLine())


    val inputArray = IntArray(n) {
        a.nextToken().toInt()
    }

    val result = selectionSort(inputArray, n, k)

    when(result.isNullOrEmpty()) {
        true -> print(-1)
        false -> result.map { print("$it ") }
    }

}

fun selectionSort(arr: IntArray, n: Int, k: Int): List<Int>? {
    var result1 = 0
    var result2 = 0
    for(last in n-1  downTo 1) {
        var maxIndex = 0
        for(i in 0..last) {
            if(arr[maxIndex] < arr[i]) maxIndex = i
        }

        if(last != maxIndex) {
            val tmp = arr[maxIndex]
            arr[maxIndex] = arr[last]
            arr[last] = tmp
            exchangeCount++
            if(exchangeCount == k) {
                result1 = arr[maxIndex]
                result2 = arr[last]

            }
        }
    }
    return when(result1 == 0) {
        true -> null
        false -> listOf(result1,result2)
    }
}

