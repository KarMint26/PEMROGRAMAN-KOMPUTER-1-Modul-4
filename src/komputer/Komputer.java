package komputer;

/**
 *
 * @author karel
 */
public class Komputer {
    private String brand;
    private String model;
    private String diskType;
    private int diskSize;
    private int ram;

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getDiskType() {
        return diskType;
    }

    public void setDiskType(String disk) {
        this.diskType = disk;
    }

    public int getDiskSize() {
        return diskSize;
    }

    public void setDiskSize(int diskSize) {
        this.diskSize = diskSize;
    }

    public int getRam() {
        return ram;
    }

    public void setRam(int ram) {
        this.ram = ram;
    }
}
