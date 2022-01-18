package gui

import java.awt.Graphics2D
import java.awt.image.BufferedImage
import java.io.File
import javax.imageio.ImageIO

class ImageGraphicalObject(
    imagePath: String
) : GraphicalObject() {
    private var imagePath = imagePath
        set(value) {
            field = value
            this.bufferedImage = ImageIO.read(File(field))
        }
    private var bufferedImage: BufferedImage = ImageIO.read(File(this.imagePath))

    override fun draw(x: Double, y: Double, width: Double, height: Double, g2d: Graphics2D) {
        // TODO scale image
        g2d.drawImage(this.bufferedImage, null, x.toInt(), y.toInt())
    }
}