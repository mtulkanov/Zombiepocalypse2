package com.mtulkanov.render

class FpsCounter(val fps: Int) {

    private var totalDelta = 0.0

    fun addDelta(delta: Double) {
        totalDelta += delta
    }

    fun isFpsReady() = totalDelta >= fps

    fun getFps(): Double {
        val saved = totalDelta
        totalDelta = 0.0
        return saved
    }
}