package gui

import java.awt.Color
import java.awt.event.KeyEvent

class TestScene2 : GameScene() {
    var ground = GameObject(0.0, -100.0, 0.0, 3000.0, 100.0,
        ColorGraphicalObject(Color(0, 100, 0)))
    var player = GameObject(0.0, -200.0, 1.0, 100.0, 100.0,
        ColorGraphicalObject(Color(255, 200, 200)))

    var leftKeyPressed = false
    var rightKeyPressed = false

    override var gui: GUI? = null
        set(value) {
            field = value
            if (value != null) {
                this.backgroundImage?.width = value.width.toDouble()
                this.backgroundImage?.height = value.height.toDouble()
                this.gameY = (-this.gui!!.height).toDouble()
            }
        }

    init {
        this.backgroundImage = SceneObject(0.0, 0.0, 0.0, 1920.0, 1080.0,
            ColorGraphicalObject(Color(0, 200, 255)))

        this.addSceneObject(ground)
        this.addSceneObject(player)
    }

    override fun run() {
        if (this.leftKeyPressed) {
            this.player.gameX -= 20
        }
        if (this.rightKeyPressed) {
            this.player.gameX += 20
        }

        this.gameX = this.player.gameX - this.gui!!.width * 0.2
        this.gameY = this.player.gameY - this.gui!!.height * 0.8
    }

    override fun keyPressed(e: KeyEvent?) {
        if (e != null) {
            when (e.keyCode) {
                KeyEvent.VK_LEFT -> this.leftKeyPressed = true
                KeyEvent.VK_RIGHT -> this.rightKeyPressed =true
            }
        }
    }

    override fun keyReleased(e: KeyEvent?) {
        if (e != null) {
            when (e.keyCode) {
                KeyEvent.VK_LEFT -> this.leftKeyPressed = false
                KeyEvent.VK_RIGHT -> this.rightKeyPressed = false
            }
        }
    }
}