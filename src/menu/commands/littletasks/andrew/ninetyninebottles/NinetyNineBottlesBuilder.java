package menu.commands.littletasks.andrew.ninetyninebottles;

public class NinetyNineBottlesBuilder implements NinetyNineBottlesInterface {
    NinetyNineBottles ninetyNineBottles = new NinetyNineBottles();

    @Override
    public NinetyNineBottlesInterface setBottles(int bottle) {
        ninetyNineBottles.setBottlesCount(bottle);
        return this;
    }

    @Override
    public NinetyNineBottles build() {
        return ninetyNineBottles;
    }
}
