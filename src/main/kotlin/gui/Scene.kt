package gui

import java.awt.Graphics2D

abstract class Scene {
    private var sceneObjects: ArrayList<SceneObject> = ArrayList() // always sorted by z-index
    var backgroundImage: SceneObject? = null
    var gui: GUI? = null
        set(value) {
            field = value
            print("z")
            if (value != null) {
                print("b")
                this.backgroundImage?.width = value.width.toDouble()
                this.backgroundImage?.height = value.height.toDouble()
            }
        }

    fun draw(g2d: Graphics2D){
        this.run()
        this.backgroundImage?.draw(g2d)
        this.sceneObjects.forEach {
            it.draw(g2d)
        }
    }

    abstract fun run()

    fun activate() {}
    fun deactivate() {}

    fun addSceneObject(sceneObject: SceneObject) {
        var insertIndex = 0
        for (i in this.sceneObjects.indices)
            if (this.sceneObjects[i].z == sceneObject.z) {
                insertIndex = i
                sceneObject.parentScene = this
                break
            }
        this.sceneObjects.add(insertIndex, sceneObject)
    }

    @Throws(IllegalArgumentException::class)
    fun removeSceneObject(sceneObject: SceneObject) {
        if (this.sceneObjects.remove(sceneObject))
            throw IllegalArgumentException("Object $sceneObject was not in the list")
        else
            sceneObject.parentScene = null
    }
}