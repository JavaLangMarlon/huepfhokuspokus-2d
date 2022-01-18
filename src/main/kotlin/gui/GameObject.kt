package gui

class GameObject(
    gameX: Double,
    gameY: Double,

    z: Double,
    width: Double,
    height: Double,
    graphicalObject: GraphicalObject
) : SceneObject(0.0, 0.0, z, width, height, graphicalObject) {
    override var parentScene: Scene? = null
        set(value) {
            field = value
            this.readjustX()
            this.readjustY()
        }

    var gameX = gameX
        set(value) {
            field = value
            this.readjustX()
        }
    var gameY = gameY
        set(value) {
            field = value
            this.readjustY()
        }

    private fun readjustX() {
        if (this.parentScene != null && this.parentScene is GameScene)
            this.x = this.gameX - (this.parentScene as GameScene).gameX
    }

    private fun readjustY() {
        if (this.parentScene != null && this.parentScene is GameScene)
            this.y = this.gameY - (this.parentScene as GameScene).gameY
    }
}