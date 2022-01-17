package gui

import java.awt.Graphics2D

abstract class Scene {
    private var sceneObjects: ArrayList<SceneObject> = ArrayList() // always sorted by z-index
    private var backgroundImage: SceneObject? = null

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
        for (i in this.sceneObjects.indices)
            if (this.sceneObjects[i].z == sceneObject.z) {
                this.sceneObjects.add(i, sceneObject)
                sceneObject.parentScene = this
                break
            }
    }

    @Throws(IllegalArgumentException::class)
    fun removeSceneObject(sceneObject: SceneObject) {
        if (this.sceneObjects.remove(sceneObject))
            throw IllegalArgumentException("Object $sceneObject was not in the list")
        else
            sceneObject.parentScene = null
    }
}