package imageviewer.model;

public class RealImage extends Image {

    private final BitMap bitmap;
    private Image nextImage;
    private Image prevImage;

    public RealImage(BitMap bitmap) {
        this.bitmap = bitmap;
    }

    @Override
    public BitMap getBitMap() {
        return bitmap;
    }

    @Override
    public Image getNext() {
        return nextImage;
    }

    @Override
    public Image getPrev() {
        return prevImage;
    }

    @Override
    public void setNext(Image image) {
        nextImage = image;
    }

    @Override
    public void setPrev(Image image) {
        prevImage = image;
    }

}
