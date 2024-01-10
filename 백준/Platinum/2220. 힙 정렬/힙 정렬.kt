package com.example.algorithmtest

import java.io.BufferedReader
import java.io.InputStreamReader


fun main(): Unit = with(BufferedReader(InputStreamReader(System.`in`))) {
    val n = readLine().toInt()

    val arr = mutableListOf(0)

    arr.add(1,1)

    for(i in 2..n) {
        arr.add(i, i)
        var j = i -1
        arr[i] = arr[i-1].also { arr[i-1] = arr[i] }

        while(j != 1) {
            arr[j] = arr[j/2].also { arr[j/2] = arr[j] }
            j = j / 2
        }
    }

    arr.subList(1, n + 1).forEach { print("$it ") }

    }

