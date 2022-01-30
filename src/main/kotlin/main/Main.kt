package main

import gui.*
import java.awt.Color

fun main(args: Array<String>) {
    val g = GUI("a", 1920, 1080, 60)
    val s = GameScene()
    g.currentScene = s
    s.ego = Ego(0.0, -200.0, 1.0, 20.0, 20.0, ColorGraphicalObject(Color(255, 200, 200)))
    s.backgroundImage = SceneObject(0.0, 0.0, 0.0, 1920.0, 1080.0,
        ColorGraphicalObject(Color(0, 200, 255)))
    s.addSceneObject(Obstacle(0.0, -100.0, 0.0, 600.0, 20.0,
        ColorGraphicalObject(Color(0, 100, 0))))
    g.start()
}