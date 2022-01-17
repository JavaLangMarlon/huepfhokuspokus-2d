package gui

import java.awt.Graphics2D

abstract class SceneObject(
    var x: Double,
    var y: Double,
    z: Double,
    var width: Double,
    var height: Double
) {
    var parentScene: Scene? = null

    var z = z
        set(value) {
            val tmp = this.parentScene  // removeSceneObject will remove our reference
            this.parentScene?.removeSceneObject(this)
            field = value
            tmp?.addSceneObject(this)
        }
    var visible = true

    abstract fun draw(graphics2D: Graphics2D)
}