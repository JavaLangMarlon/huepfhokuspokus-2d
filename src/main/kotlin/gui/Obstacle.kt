package gui

class Obstacle(
    gameX: Double,
    gameY: Double,

    z: Double,
    width: Double,
    height: Double,
    graphicalObject: GraphicalObject
) : GameObject(gameX, gameY, z, width, height, graphicalObject) {
}