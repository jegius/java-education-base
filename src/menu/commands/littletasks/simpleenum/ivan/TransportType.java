package menu.commands.littletasks.simpleenum.ivan;

public enum TransportType {
    BUS("Bus"),
    CAR("Car"),
    TRAIN("Train"),
    PLANE("Plane");

    private String name;

    TransportType(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
