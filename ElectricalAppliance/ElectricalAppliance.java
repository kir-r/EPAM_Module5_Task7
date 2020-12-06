package ElectricalAppliance;

import java.io.Serializable;

public abstract class ElectricalAppliance implements Serializable {
    private String name;
    private boolean pluggedIn;
    private int powerСonsumption;
    private String manufacturer;

    public String getName() {
        return name;
    }

    public boolean isPluggedIn() {
        return pluggedIn;
    }

    public int getPowerСonsumption() {
        return powerСonsumption;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPluggedIn(boolean pluggedIn) {
        this.pluggedIn = pluggedIn;
    }

    public void setPowerСonsumption(int powerСonsumption) {
        this.powerСonsumption = powerСonsumption;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public ElectricalAppliance(String name, boolean pluggedIn, int powerСonsumption, String manufacturer) {
        this.name = name;
        this.pluggedIn = pluggedIn;
        this.powerСonsumption = powerСonsumption;
        this.manufacturer = manufacturer;
    }

    @Override
    public String toString() {
        return "Electrical appliance: " + name + "\n" +
                "pluggedIn: " + pluggedIn + "\n" +
                "powerСonsumption: " + powerСonsumption + "\n" +
                "manufacturer: " + manufacturer + "\n";
    }
}
