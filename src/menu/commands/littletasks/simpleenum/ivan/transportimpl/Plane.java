package menu.commands.littletasks.simpleenum.ivan.transportimpl;

import menu.commands.littletasks.simpleenum.ivan.Transport;
import menu.commands.littletasks.simpleenum.ivan.TransportType;

public class Plane implements Transport {
    private TransportType transportType;

    public Plane() {
        transportType = TransportType.PLANE;
    }

    @Override
    public void drive() {
        System.out.println(this);
    }

    @Override
    public String toString() {
        return transportType.getName() +
                " flies through the sky.";
    }
}
