package render

import java.awt.Canvas
import java.awt.Dimension
import java.awt.Frame
import javax.swing.JFrame

class Display(val title: String, val width: Int, val height: Int) {

    private val canvas: Canvas

    init {
        val dimension = Dimension(width, height)
        canvas = Canvas()
        with(canvas) {
            preferredSize = dimension
            maximumSize = dimension
            minimumSize = dimension
            isFocusable = false
        }
    }

    private val frame: Frame

    init {
        frame = JFrame(title)
        with(frame) {
            setSize(width, height)
            defaultCloseOperation = JFrame.EXIT_ON_CLOSE
            isResizable = false
            setLocationRelativeTo(null)
            isVisible = true
            add(canvas)
            pack()
        }
    }
}