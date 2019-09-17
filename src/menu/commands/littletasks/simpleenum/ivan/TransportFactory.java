package menu.commands.littletasks.simpleenum.ivan;

import menu.commands.littletasks.simpleenum.ivan.transportimpl.Bus;
import menu.commands.littletasks.simpleenum.ivan.transportimpl.Car;
import menu.commands.littletasks.simpleenum.ivan.transportimpl.Plane;
import menu.commands.littletasks.simpleenum.ivan.transportimpl.Train;

class TransportFactory {

    static Transport createTransportByType(TransportType transportType){
        switch (transportType) {
            case BUS:
                return new Bus();
            case CAR:
                return new Car();
            case PLANE:
                return new Plane();
            case TRAIN:
                return new Train();
            default:
                System.out.println("Incorrect transport type!");
                return null;
        }
    }
}
