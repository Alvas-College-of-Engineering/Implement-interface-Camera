package mobilmanagement;

public class Mobile implements Camera {

    String brand;

    public Mobile(String brand) {
        this.brand = brand;
    }

    @Override
    public String clickPhoto() {
        return brand + " Photo Clicked 📸";
    }

    @Override
    public String recordVideo() {
        return brand + " Video Recorded 🎥";
    }
}