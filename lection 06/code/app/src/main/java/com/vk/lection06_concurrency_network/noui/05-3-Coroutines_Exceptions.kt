@file:OptIn(DelicateCoroutinesApi::class)

package com.vk.lection06_concurrency_network.noui

import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.async
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking


fun main() = runBlocking {
    // root coroutine with launch
    try {
        val job = GlobalScope.launch {
            println("Throwing exception from launch")
            // Will be printed to the console by Thread.defaultUncaughtExceptionHandler
            throw IndexOutOfBoundsException()
        }
        job.join()
    } catch (e: Exception) {
        println("Joined failed job")
    }
    // root coroutine with async
    val deferred = GlobalScope.async {
        println("Throwing exception from async")
        // Nothing is printed, relying on user to call await
        throw ArithmeticException()
    }
    try {
        deferred.await()
        println("Unreached")
    } catch (e: ArithmeticException) {
        println("Caught ArithmeticException")
    }
}


