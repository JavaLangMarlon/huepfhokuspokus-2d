package gui

import java.awt.Color
import java.awt.Graphics2D

class ColorGraphicalObject(
    var color: Color
) : GraphicalObject() {
    override fun draw(x: Double, y: Double, width: Double, height: Double, g2d: Graphics2D) {
        g2d.color = this.color
        g2d.fillRect(x.toInt(), y.toInt(), width.toInt(), height.toInt())
    }
}