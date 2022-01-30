package gui

import java.awt.Graphics2D
import java.awt.event.KeyEvent
import java.awt.event.KeyListener

abstract class Scene : KeyListener {
    var sceneObjects: ArrayList<SceneObject> = ArrayList() // always sorted by z-index
    var backgroundImage: SceneObject? = null
    open var gui: GUI? = null
        set(value) {
            field = value
            if (value != null) {
                this.backgroundImage?.width = value.width.toDouble()
                this.backgroundImage?.height = value.height.toDouble()
            }
        }

    fun draw(g2d: Graphics2D){
        this.run()
        this.backgroundImage?.draw(g2d)
        this.sceneObjects.forEach {
            if (it.visible)
                it.draw(g2d)
        }
    }

    open fun run() {}

    fun activate() {}
    fun deactivate() {}

    fun addSceneObject(sceneObject: SceneObject) {
        var insertIndex = 0
        if (this.sceneObjects.isNotEmpty()) {
            insertIndex = -1
            for (i in this.sceneObjects.indices)
                if (this.sceneObjects[i].z == sceneObject.z) {
                    insertIndex = i
                    break
                }
            if (insertIndex == -1)
                insertIndex = this.sceneObjects.size
        }
        sceneObject.parentScene = this
        this.sceneObjects.add(insertIndex, sceneObject)
    }

    @Throws(IllegalArgumentException::class)
    fun removeSceneObject(sceneObject: SceneObject) {
        if (this.sceneObjects.remove(sceneObject))
            throw IllegalArgumentException("Object $sceneObject was not in the list")
        else
            sceneObject.parentScene = null
    }

    override fun keyTyped(e: KeyEvent?) {
        // this can be overridden way down
    }

    override fun keyPressed(e: KeyEvent?) {
        // this can be overridden way down
    }

    override fun keyReleased(e: KeyEvent?) {
        // this can be overridden way down
    }
}