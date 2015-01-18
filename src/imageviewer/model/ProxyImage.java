package imageviewer.model;

import imageviewer.persistence.ImageLoader;

public class ProxyImage extends Image {

    private final ImageLoader loader;
    private Image next;
    private Image prev;
    private Image realImage;

    public ProxyImage(ImageLoader loader) {
        this.loader = loader;
    }

    @Override
    public Image getNext() {
        return next;
    }

    @Override
    public Image getPrev() {
        return prev;
    }

    @Override
    public BitMap getBitMap() {
        checkLoaded();
        return realImage.getBitMap();
    }

    @Override
    public void setNext(Image image) {
        this.next = image;
    }

    @Override
    public void setPrev(Image image) {
        this.prev = image;
    }

    private void checkLoaded() {
        if (realImage != null) {
            return;
        }
        realImage = loader.load();
    }
    
}
