package main

import gui.GUI
import gui.TestScene2

fun main(args: Array<String>) {
    val g = GUI("a", 1920, 1080)
    val ts2 = TestScene2()
    g.currentScene = ts2
    g.start()
}