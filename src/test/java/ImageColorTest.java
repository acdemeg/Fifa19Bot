import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class ImageColorTest {

    @Test
    void checkColorTest() throws IOException {
        File file = new File("screenshots", "1.jpg");
        BufferedImage bufferedImage = ImageIO.read(file);

        Color startPixel = new Color(bufferedImage.getRGB(0, 0));
        Color endPixel = new Color(bufferedImage.getRGB(257, 152));
        Color pixelDarkField = new Color(bufferedImage.getRGB(31, 58));
        Color pixelLightField = new Color(bufferedImage.getRGB(229, 54));
        Color pixelBall = new Color(bufferedImage.getRGB(77, 36));
        Color pixelActivePlayer = new Color(bufferedImage.getRGB(73, 32));
        Color pixelComradePlayer = new Color(bufferedImage.getRGB(129, 61));
        Color pixelEnemyPlayer = new Color(bufferedImage.getRGB(135, 67));
        Color pixelCenterField = new Color(bufferedImage.getRGB(128, 77));

        Assertions.assertEquals(startPixel.getRGB(), new Color(194,204,185).getRGB());
        Assertions.assertEquals(endPixel.getRGB(), new Color(174,185,163).getRGB());
        Assertions.assertEquals(pixelDarkField.getRGB(), new Color(52,74,27).getRGB());
        Assertions.assertEquals(pixelLightField.getRGB(), new Color(57,77,35).getRGB());
        Assertions.assertEquals(pixelBall.getRGB(), new Color(255,186,0).getRGB());
        Assertions.assertEquals(pixelActivePlayer.getRGB(), new Color(0,172,172).getRGB());
        Assertions.assertEquals(pixelComradePlayer.getRGB(), new Color(198,41,44).getRGB());
        Assertions.assertEquals(pixelEnemyPlayer.getRGB(), new Color(40,45,77).getRGB());
        Assertions.assertEquals(pixelCenterField.getRGB(), new Color(208,210,204).getRGB());
    }
}
