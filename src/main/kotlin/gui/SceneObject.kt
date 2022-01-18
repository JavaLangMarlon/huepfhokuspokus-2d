package gui

import java.awt.Graphics2D

open class SceneObject(
    var x: Double,
    var y: Double,
    z: Double,
    var width: Double,
    var height: Double,
    var graphicalObject: GraphicalObject
) {
    open var parentScene: Scene? = null

    var z = z
        set(value) {
            val tmp = this.parentScene  // removeSceneObject will remove our reference
            this.parentScene?.removeSceneObject(this)
            field = value
            tmp?.addSceneObject(this)
        }
    var visible = true

    fun draw(graphics2D: Graphics2D) {
        this.graphicalObject.draw(this.x, this.y, this.width, this.height, graphics2D)
    }
}