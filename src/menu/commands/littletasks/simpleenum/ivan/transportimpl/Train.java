package menu.commands.littletasks.simpleenum.ivan.transportimpl;

import menu.commands.littletasks.simpleenum.ivan.Transport;
import menu.commands.littletasks.simpleenum.ivan.TransportType;

public class Train implements Transport {
    private TransportType transportType;

    public Train() {
        transportType = TransportType.TRAIN;
    }

    @Override
    public void drive() {
        System.out.println(this);
    }

    @Override
    public String toString() {
        return transportType.getName() +
                " train rides on rails";
    }
}
