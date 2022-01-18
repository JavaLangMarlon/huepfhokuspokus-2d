package gui

import java.awt.Color
import java.awt.Graphics2D

class ColorSceneObject(
    x: Double,
    y: Double,
    z: Double,
    width: Double,
    height: Double,
    var color: Color
) : SceneObject(x, y, z, width, height) {

    override fun draw(graphics2D: Graphics2D) {
        graphics2D.color = this.color
        graphics2D.fillRect(this.x.toInt(), this.y.toInt(), this.width.toInt(), this.height.toInt())
    }
}