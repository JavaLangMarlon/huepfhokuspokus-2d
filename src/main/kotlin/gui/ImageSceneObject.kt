package gui

import java.awt.Graphics2D
import java.awt.image.BufferedImage
import java.io.File
import javax.imageio.ImageIO

class ImageSceneObject(
    x: Double,
    y: Double,
    z: Double,
    width: Double,
    height: Double,
    var imagePath: String
) : SceneObject(x, y, z, width, height) {
    private var bufferedImage: BufferedImage = ImageIO.read(File(this.imagePath))

    override fun draw(graphics2D: Graphics2D) {
        graphics2D.drawImage(this.bufferedImage, null, this.x.toInt(), this.y.toInt())
    }
}