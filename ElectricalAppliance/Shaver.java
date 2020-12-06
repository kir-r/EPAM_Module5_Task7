package ElectricalAppliance;

public class Shaver extends ElectricalAppliance {
    private final static String name = "Shaver Sharp";
    public Shaver(boolean pluggedIn, int powerСonsumption, String manufacturer) {
        super(name, pluggedIn, powerСonsumption, manufacturer);
    }
}
