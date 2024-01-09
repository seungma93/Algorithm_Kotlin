package com.example.algorithmtest

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.StringTokenizer
import kotlin.collections.component1
import kotlin.collections.component2
import kotlin.collections.map


var exchangeCount = 0
var result1 = 0
var result2 = 0
var inputCount = 0

fun main(): Unit = with(BufferedReader(InputStreamReader(System.`in`))) {
    val (n, k) = readLine()!!.split(" ").map { it.toInt() }
    val a = StringTokenizer(readLine())


    val inputArray = IntArray(n) {
        a.nextToken().toInt()
    }
    inputCount = k

    heapSort(inputArray, n)
    when(exchangeCount > inputCount) {
        true -> listOf(result1, result2).sorted().map { print("$it ") }
        false -> print(-1)
    }

}

fun heapSort(arr: IntArray, n: Int) {
    buildMinHeap(arr, n)
    for (i in n - 1 downTo 1) {
        exchangeCount++
        arr[0] = arr[i].also { arr[i] = arr[0] } // Swap A[1] and A[i]
        if(exchangeCount == inputCount) {
            result1 = arr[0]
            result2 = arr[i]
        }
        heapify(arr, 0, i - 1)
    }
}

fun buildMinHeap(arr: IntArray, n: Int) {
    for (i in n / 2 downTo 0) {
        heapify(arr, i, n - 1)
    }
}

fun heapify(arr: IntArray, k: Int, n: Int) {
    val left = 2 * k + 1
    val right = 2 * k + 2
    var smaller = k

    if (left <= n && arr[left] < arr[smaller]) {
        smaller = left
    }

    if (right <= n && arr[right] < arr[smaller]) {
        smaller = right
    }

    if (smaller != k) {
        exchangeCount++
        arr[k] = arr[smaller].also { arr[smaller] = arr[k] } // Swap A[k] and A[smaller]
        if(exchangeCount == inputCount) {
            result1 = arr[smaller]
            result2 = arr[k]
        }
        heapify(arr, smaller, n)
    }
}


