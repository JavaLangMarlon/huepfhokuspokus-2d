package gui

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
}