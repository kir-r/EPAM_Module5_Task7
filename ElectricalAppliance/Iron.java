package ElectricalAppliance;

public class Iron extends ElectricalAppliance {
    private final static String name = "Iron Ariston";
    public Iron(boolean pluggedIn, int powerСonsumption, String manufacturer) {
        super(name, pluggedIn, powerСonsumption, manufacturer);
    }
}
