package com.mtulkanov

import kotlin.concurrent.thread

import java.lang.System
import kotlin.math.round
import kotlin.math.roundToLong

class Game() {
    companion object {
        private const val TARGET_FPS = 60
        private const val TIME_PER_TICK = 1_000.0 / TARGET_FPS
        private const val TIME_TO_SLEEP = 1L
    }

    private val engine = Engine()
    private var running = false

    fun start() {
        running = true
        engine.init()
        thread {
            run()
        }.join()
    }

    private fun run() {
        var delta = 0.0
        var lastTime = System.currentTimeMillis()
        while (running) {
            val currentTime = System.currentTimeMillis()
            delta += (currentTime - lastTime) / TIME_PER_TICK
            lastTime = currentTime
            if (delta >= 1) {
                engine.update(delta)
                delta--
            }
            Thread.sleep(TIME_TO_SLEEP)
        }
    }
}