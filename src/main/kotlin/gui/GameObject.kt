package gui

class Position(
    var x: Double,
    var y: Double
)

open class GameObject(
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

    open var gameX = gameX
        set(value) {
            field = value
            this.gamePosition.x = value
            this.readjustX()
        }
    open var gameY = gameY
        set(value) {
            field = value
            this.gamePosition.y = value
            this.readjustY()
        }
    open var gamePosition = Position(.0, .0)
        set(value) {
            this.gameX = value.x
            this.gameY = value.y
            this.readjustX()
            this.readjustY()
            field = value
        }

    fun readjustX() {
        if (this.parentScene != null && this.parentScene is GameScene)
            this.x = this.gameX - (this.parentScene as GameScene).gameX
    }

    fun readjustY() {
        if (this.parentScene != null && this.parentScene is GameScene)
            this.y = this.gameY - (this.parentScene as GameScene).gameY
    }

    fun touches(other: GameObject) : Boolean {
        return this.touches(this.gameX, this.gameY, other)
    }

    fun touches(newX: Double, newY: Double, other: GameObject) : Boolean {
        // this function should be used for movement
        return (
                newX <= other.gameX  && other.gameX < newX + this.width ||
                        other.gameX <= newX && newX < other.gameX + other.width
                ) && (
                newY <= other.gameY  && other.gameY < newY + this.height ||
                        other.gameY <= newY && newY < other.gameY + other.height
                )
    }
}