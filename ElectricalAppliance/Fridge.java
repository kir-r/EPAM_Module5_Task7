package ElectricalAppliance;

public class Fridge extends ElectricalAppliance {
    private final static String name = "Fridge Daewoo";
    public Fridge(boolean pluggedIn, int powerСonsumption, String manufacturer) {
        super(name, pluggedIn, powerСonsumption, manufacturer);
    }
}
