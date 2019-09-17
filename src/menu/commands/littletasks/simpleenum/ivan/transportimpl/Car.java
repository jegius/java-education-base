package menu.commands.littletasks.simpleenum.ivan.transportimpl;

import menu.commands.littletasks.simpleenum.ivan.Transport;
import menu.commands.littletasks.simpleenum.ivan.TransportType;

public class Car implements Transport {
    private TransportType transportType;

    public Car() {
        transportType = TransportType.CAR;
    }

    @Override
    public void drive() {
        System.out.println(this);
    }

    @Override
    public String toString() {
        return transportType.getName()
                + " rides on the freeway.";
    }
}
