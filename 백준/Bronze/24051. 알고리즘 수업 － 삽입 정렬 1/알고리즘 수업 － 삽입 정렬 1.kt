package com.example.algorithmtest

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.StringTokenizer
import kotlin.collections.component1
import kotlin.collections.component2
import kotlin.collections.map


var saveCount = 0
var result = 0


fun main(): Unit = with(BufferedReader(InputStreamReader(System.`in`))) {
    val (n, k) = readLine()!!.split(" ").map { it.toInt() }
    val a = StringTokenizer(readLine())

    val inputArray = IntArray(n) {
        a.nextToken().toInt()
    }

    insertionSort(inputArray, k)

    if(saveCount < k) result = -1

    print(result)
}

fun insertionSort(arr: IntArray, k: Int) {
    val n = arr.size

    for (i in 1 until n) {
        var loc = i - 1
        val newItem = arr[i]

        while (loc >= 0 && newItem < arr[loc]) {
            arr[loc + 1] = arr[loc]
            saveCount++
            if(saveCount == k) result = arr[loc]
            loc--
        }

        if (loc + 1 != i) {
            arr[loc + 1] = newItem
            saveCount++
            if(saveCount == k) result = newItem
        }
    }
}

