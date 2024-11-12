package com.vk.lection06_concurrency_network.noui

fun main() {
    println("hello, i'm ${Thread.currentThread().name} ${Thread.currentThread().isAlive}")
    val thread = Thread {
        Thread.sleep(1000L)
        println("hello, i'm ${Thread.currentThread().name}")

    }
//    thread.isDaemon = true
    println("Start another thread")
    thread.start()
    println("Thread started")
    thread.join()
    println("Done")
}