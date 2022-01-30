package gui

import kotlin.math.absoluteValue
import kotlin.math.roundToInt

class Ego(
    gameX: Double,
    gameY: Double,

    z: Double,
    width: Double,
    height: Double,
    graphicalObject: GraphicalObject
) : DynamicGameObject(gameX, gameY, z, width, height, graphicalObject) {
    override var parentScene: Scene? = null
        set(value) {
            if (value != null) {
                field = value
                this.x = value.gui!!.width * 0.2
                this.y = value.gui!!.height * 0.5
                this.readjustScene()
            }
        }


    override var gameX = gameX
        set(value) {
            if (this.isValid(value, this.gameY)) {
                field = value
                this.gamePosition.x = value
                this.readjustScene()
            } else
                this.vx = (this.vx / 2 * 100).roundToInt() / 100.0
        }
    override var gameY = gameY
        set(value) {
            if (this.isValid(this.gameX, value)) {
                field = value
                this.gamePosition.y = value
                this.readjustScene()
            } else {
                this.vy = (this.vy / 2 * 100).roundToInt() / 100.0
            }
        }

    override var vx = .0
        set(value) {
            if (this.isValid(this.gameX + value, this.gameY))
                field = value
        }

    override var vy = .0
        set(value) {
            if (this.isValid(this.gameX, this.gameY + value) || value.absoluteValue < field.absoluteValue)
                field = value
        }

    override var gamePosition = Position(.0, .0)
        set(value) {
            if (this.isValid(value.x, value.y)) {
                field = value
                this.gameX = value.x
                this.gameY = value.y
                this.readjustScene()
            }
        }

    fun readjustScene() {
        if (this.parentScene != null && this.parentScene is GameScene) {
            (this.parentScene as GameScene).gameX = this.gameX - (this.parentScene as GameScene).gui!!.width * 0.2
            (this.parentScene as GameScene).gameY = this.gameY - (this.parentScene as GameScene).gui!!.height * 0.5
        }
        // TODO
    }
}