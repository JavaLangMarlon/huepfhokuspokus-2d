package gui

import java.awt.Dimension
import java.awt.Graphics
import java.awt.Graphics2D
import javax.swing.JFrame
import javax.swing.JPanel
import javax.swing.Timer


class GUI(
    val frameTitle: String,
    val frameWidth: Int,
    val frameHeight: Int,
) : JPanel() {
    private val frame: JFrame = JFrame(this.frameTitle)

    var currentScene: Scene? = null
        set(value) {
            field?.deactivate()
            value?.gui = this
            field = value
            field?.activate()
        }

    init {
        this.size = Dimension(this.frameWidth, this.frameHeight)
        this.frame.size = this.size
        this.frame.add(this)
    }

    fun start() {
        this.frame.isVisible = true
        this.isVisible = true

        val timer = Timer(50) {
            this.repaint()
        }

        timer.start()
    }

    override fun paintComponent(g: Graphics?) {
        super.paintComponent(g)

        if (g is Graphics2D) {
            this.currentScene?.draw(g)
        }
    }
}