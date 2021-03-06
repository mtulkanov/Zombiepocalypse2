package com.mtulkanov.render

import java.awt.Canvas
import java.awt.Dimension
import java.awt.Frame
import javax.swing.JFrame

class Display(title: String, width: Int, height: Int) {

    private val canvas: Canvas

    init {
        val dimension = Dimension(width, height)
        canvas = Canvas().apply {
            preferredSize = dimension
            maximumSize = dimension
            minimumSize = dimension
            isFocusable = false
        }
    }

    private val frame: Frame

    init {
        frame = JFrame(title).apply {
            setSize(width, height)
            defaultCloseOperation = JFrame.EXIT_ON_CLOSE
            isResizable = false
            setLocationRelativeTo(null)
            isVisible = true
            add(canvas)
            pack()
        }
    }

    fun updateTitle(title: String) {
        frame.title = title
    }
}