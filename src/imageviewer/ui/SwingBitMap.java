package imageviewer.ui;

import imageviewer.model.BitMap;
import java.awt.image.BufferedImage;

public class SwingBitMap implements BitMap {

    private final BufferedImage bufferedImage;

    public SwingBitMap(BufferedImage bufferedImage) {
        this.bufferedImage = bufferedImage;
    }

    public BufferedImage getBufferedImage() {
        return bufferedImage;
    }

    public int getWidth() {
        return bufferedImage.getWidth();
    }

    public int getHeight() {
        return bufferedImage.getHeight();
    }

}
