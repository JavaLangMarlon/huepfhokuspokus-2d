package main

import gui.GUI
import gui.TestScene

fun main(args: Array<String>) {
    val g = GUI("a", 1920, 1080)
    val ts = TestScene()
    g.currentScene = ts
    g.start()
}