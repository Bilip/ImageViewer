package imageviewer.ui;

import imageviewer.model.Image;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import javax.swing.JPanel;

public class ImagePanel extends JPanel implements ImageViewer {

    private Image image;
    private int offset;
    private java.awt.Image getBufferedImage;

    @Override
    public Image getImage() {
        return image;
    }

    @Override
    public void setImage(Image image) {
        this.image = image;
        repaint();
    }

    @Override
    public void show() {
        this.image = image;
        repaint();
    }

    @Override
    public void paint(Graphics graphics) {
        if (image == null) {
            return;
        }
        super.paint(graphics);
        graphics.drawImage(getBitmap(), offset, 0, null);
        if (offset == 0) {
        } else if (offset < 0) {
            graphics.drawImage(getBufferedImage((SwingBitMap) image.getNext().getBitMap()), image.getBitMap().getWidth() + offset, 0, null);
        } else {
            graphics.drawImage(getBufferedImage((SwingBitMap) image.getPrev().getBitMap()), offset - image.getBitMap().getWidth(), 0, null);
        }
    }

    private BufferedImage getBufferedImage(SwingBitMap swingBitMap) {
        return swingBitMap.getBufferedImage();
    }

    private BufferedImage getBitmap() {
        if (image.getBitMap() instanceof SwingBitMap) {
            return getBufferedImage((SwingBitMap) image.getBitMap());
        }
        return null;
    }

}
