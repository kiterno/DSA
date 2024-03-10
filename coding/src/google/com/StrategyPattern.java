package google.com;

public class StrategyPattern {
    public static void main(String[] args) {
        ImageManager imageManager = new ImageManager();
        imageManager.setRenderer(new SmartphoneRenderer());
        imageManager.show();
    }
}


class TVRenderer implements Device {
    @Override
    public void showImage() {
        System.out.println("Showing an image on TV...");
    }
}

class SmartphoneRenderer implements Device {
    @Override
    public void showImage() {
        System.out.println("Showing an image on smartphone...");
    }
}

class LaptopRenderer implements Device {

    @Override
    public void showImage() {
        System.out.println("Showing an image on laptop...");
    }
}

interface Device{
    public void showImage();
}

class ImageManager {

    private Device device;

    public void setRenderer(Device device) {
        this.device = device;
    }

    public void show() {
        device.showImage();
    }
}
