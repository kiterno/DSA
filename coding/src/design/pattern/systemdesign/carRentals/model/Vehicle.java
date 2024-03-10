package design.pattern.systemdesign.carRentals.model;

public class Vehicle {
    private String regNumber;
    private String model;
    private String name;
    private String year;
    private VehicleType vehicleType;
    private Boolean available;

    public Vehicle(String regNumber, String model, String name, String year, VehicleType vehicleType, boolean available) {
        this.regNumber = regNumber;
        this.model = model;
        this.name = name;
        this.year = year;
        this.vehicleType = vehicleType;
        this.available = available;
    }

    public String getRegNumber() {
        return regNumber;
    }

    public void setRegNumber(String regNumber) {
        this.regNumber = regNumber;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public VehicleType getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(VehicleType vehicleType) {
        this.vehicleType = vehicleType;
    }

    public Boolean getAvailable() {
        return available;
    }

    public void setAvailable(Boolean available) {
        this.available = available;
    }
}
