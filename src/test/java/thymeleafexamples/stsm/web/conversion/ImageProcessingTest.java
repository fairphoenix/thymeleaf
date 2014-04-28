package thymeleafexamples.stsm.web.conversion;

import org.imgscalr.Scalr;


import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * Created by anatoliy on 28.04.14.
 */
public class ImageProcessingTest {

    public static void main(String[] args) throws IOException {
        BufferedImage image = ImageIO.read(ImageProcessingTest.class.getResourceAsStream("/img.png"));

        image = Scalr.crop(image,150,150,500,150,Scalr.OP_ANTIALIAS);

        BufferedImage resizeImage =
                Scalr.resize(image, Scalr.Method.QUALITY, Scalr.Mode.FIT_EXACT,
                        150, 150, Scalr.OP_ANTIALIAS);

        ImageIO.write(resizeImage, "PNG", new FileOutputStream("resImg.png"));
    }

}
