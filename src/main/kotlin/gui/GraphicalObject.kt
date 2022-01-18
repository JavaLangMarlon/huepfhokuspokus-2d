package gui

import java.awt.Graphics2D

abstract class GraphicalObject {
    abstract fun draw(x: Double, y: Double, width: Double, height: Double, g2d: Graphics2D)
}