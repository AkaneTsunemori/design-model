package com.shiro.tank.util;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class ResourceManager {
    public static BufferedImage enemyTankL, enemyTankU, enemyTankR, enemyTankD;
    public static BufferedImage friendTankL, friendTankU, friendTankR, friendTankD;

    public static BufferedImage bulletL, bulletU, bulletR, bulletD;

    public static BufferedImage[] explosion = new BufferedImage[16];
    public static boolean init = false;
    static {
        try {
            friendTankU = ImageIO.read(ResourceManager.class.getClassLoader().getResourceAsStream("images/GoodTank1.png"));
            enemyTankU = ImageIO.read(ResourceManager.class.getClassLoader().getResourceAsStream("images/BadTank1.png"));
            bulletU = ImageIO.read(ResourceManager.class.getClassLoader().getResourceAsStream("images/bulletU.gif"));
            for (int i = 0; i < 16; i++) {
                explosion[i] = ImageIO.read(ResourceManager.class.getClassLoader().getResourceAsStream("images/e"+(i+1)+".gif"));
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        friendTankL = rotateImage(friendTankU, -90);
        friendTankR = rotateImage(friendTankU, 90);
        friendTankD = rotateImage(friendTankU, 180);

        enemyTankL = rotateImage(enemyTankU, -90);
        enemyTankR = rotateImage(enemyTankU, 90);
        enemyTankD = rotateImage(enemyTankU, 180);
        bulletL = rotateImage(bulletU, -90);
        bulletR = rotateImage(bulletU, 90);
        bulletD = rotateImage(bulletU, 180);
        Const.TANK_WIDTH = friendTankU.getWidth();
        Const.TANK_HEIGHT = friendTankU.getHeight();
        Const.BULLET_HEIGHT = bulletD.getHeight();
        Const.BULLET_WIDTH = bulletD.getWidth();
        Const.EXPLOSION_WIDTH = explosion[0].getWidth();
        Const.EXPLOSION_HEIGHT = explosion[0].getWidth();
        init = true;

    }

    public static BufferedImage rotateImage(final BufferedImage bufferedimage,
                                            final int degree) {
        int w = bufferedimage.getWidth();
        int h = bufferedimage.getHeight();
        int type = bufferedimage.getColorModel().getTransparency();
        BufferedImage img;
        Graphics2D graphics2d;
        (graphics2d = (img = new BufferedImage(w, h, type))
                .createGraphics()).setRenderingHint(
                RenderingHints.KEY_INTERPOLATION,
                RenderingHints.VALUE_INTERPOLATION_BILINEAR);
        graphics2d.rotate(Math.toRadians(degree), w / 2, h / 2);
        graphics2d.drawImage(bufferedimage, 0, 0, null);
        graphics2d.dispose();
        return img;
    }
}
