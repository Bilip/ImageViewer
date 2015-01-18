
package imageviewer.persistence;

import imageviewer.model.BitMap;
import imageviewer.model.Image;
import imageviewer.model.RealImage;
import imageviewer.ui.SwingBitMap;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;

public class ImageLoader {

    String filename;

    public ImageLoader(String filename) {
        this.filename = filename;
    }
    
    public Image load() {
        return new RealImage(loadBitmap());
    }

    private BitMap loadBitmap() {
        try {
            return new SwingBitMap(loadBufferedImage());
        } catch (IOException ex) {
            Logger.getLogger(ImageLoader.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    private BufferedImage loadBufferedImage() throws IOException{
        return ImageIO.read(new File(filename));
    }

}
