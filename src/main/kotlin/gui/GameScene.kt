package gui

import java.awt.event.KeyEvent

open class GameScene : Scene() {
    var gameX = 0.0
        set(value) {
            field = value
            this.repositionGameObjectsX()
        }
    var gameY = 0.0
        set(value) {
            field = value
            this.repositionGameObjectsY()
        }

    private fun repositionGameObjectsX() {
        for (i in this.sceneObjects)
            if (i is GameObject)
                i.x = i.gameX - this.gameX
    }

    private fun repositionGameObjectsY() {
        for (i in this.sceneObjects)
            if (i is GameObject)
                i.y = i.gameY - this.gameY
    }

    var ego: Ego? = null
        set(value) {
            if (this.ego != null)
                this.removeSceneObject(this.ego!!)
            if (value != null) {
                field = value
                this.addSceneObject(value)
            }
        }

    override var gui: GUI? = null
        set(value) {
            field = value
            if (value != null) {
                this.backgroundImage?.width = value.width.toDouble()
                this.backgroundImage?.height = value.height.toDouble()
                this.gameY = (-this.gui!!.height).toDouble()
            }
        }

    private var leftKeyPressed = false
    private var rightKeyPressed = false

    override fun run() {
        if (this.ego != null && !this.ego!!.isStanding())
            this.ego!!.ay = .3  // gravity

        this.sceneObjects.filterIsInstance<DynamicGameObject>().forEach {
            it.vx += it.ax
            it.vy += it.ay
            it.gameX += it.vx
            it.gameY += it.vy
        }
    }

    override fun keyPressed(e: KeyEvent?) {
        if (e != null)
            when (e.keyCode) {
                KeyEvent.VK_LEFT -> {
                    this.leftKeyPressed = true
                    this.updateSignal()
                }
                KeyEvent.VK_RIGHT -> {
                    this.rightKeyPressed = true
                    this.updateSignal()
                }
                KeyEvent.VK_UP -> this.ego!!.ay = -10.0
            }
    }

    override fun keyReleased(e: KeyEvent?) {
        if (e != null)
            when (e.keyCode) {
                KeyEvent.VK_LEFT -> {
                    this.leftKeyPressed = false
                    this.updateSignal()
                }
                KeyEvent.VK_RIGHT -> {
                    this.rightKeyPressed = false
                    this.updateSignal()
                }
            }
    }

    private fun updateSignal() {
        if (this.ego != null)
            if (this.leftKeyPressed && !this.rightKeyPressed)
                this.ego!!.vx = -10.0
            else if (this.rightKeyPressed && !this.leftKeyPressed)
                this.ego!!.vx = 10.0
            else
                this.ego!!.vx = .0
    }
}