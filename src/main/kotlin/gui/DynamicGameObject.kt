package gui

open class DynamicGameObject (
    gameX: Double,
    gameY: Double,

    z: Double,
    width: Double,
    height: Double,
    graphicalObject: GraphicalObject
) : GameObject(gameX, gameY, z, width, height, graphicalObject) {
    open var vx = .0
    open var vy = .0
    var ax = .0
    var ay = .0

    fun isValid(newX: Double, newY: Double): Boolean {  // TODO rename function
        var result = true

        this.parentScene!!.sceneObjects.filterIsInstance<Obstacle>().forEach {
            if (this.touches(newX, newY, it)) {
                result = false
                return@forEach
            }
        }
        return result
    }

    fun isStanding() : Boolean {
        // TODO there is optimization possible
        return !this.isValid(this.gameX, this.gameY + 1)
    }
}