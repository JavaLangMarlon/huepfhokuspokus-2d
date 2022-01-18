package gui

import java.awt.Color
import java.awt.event.KeyEvent

class TestScene : Scene() {
    private var a = SceneObject(0.0, 0.0, 0.0, 100.0, 100.0, ColorGraphicalObject(Color(255, 255, 0)))

    init {
        this.backgroundImage = SceneObject(0.0, 0.0, 0.0, 0.0, 0.0, ColorGraphicalObject(Color(150, 200, 255)))

        this.addSceneObject(a)
    }

    override fun run() {
        this.a.x++
    }
}