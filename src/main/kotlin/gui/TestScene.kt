package gui

import java.awt.Color

class TestScene : Scene() {
    init {
        this.backgroundImage = ColorSceneObject(0.0, 0.0, 0.0, 0.0, 0.0, Color(100, 150, 255))
        var a = ColorSceneObject(0.0, 0.0, 0.0, 100.0, 100.0, Color(255, 255, 0))

        this.addSceneObject(a)
    }

    override fun run() {
    }


}