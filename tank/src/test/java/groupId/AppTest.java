package groupId;


import org.junit.Test;

import javax.imageio.ImageIO;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import static org.junit.Assert.assertNotNull;

/**
 * Unit test for simple App.
 */
public class AppTest {

    @Test
    public void test() throws IOException {
        BufferedImage image = ImageIO.read(new File("src/main/resources/favicon.ico"));
        BufferedImage image2 = ImageIO.read(this.getClass().getClassLoader().getResourceAsStream("images/bulletD.gif"));
        assertNotNull(image2);
    }
}
