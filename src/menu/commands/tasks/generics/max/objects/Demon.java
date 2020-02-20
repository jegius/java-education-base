package menu.commands.tasks.generics.max.objects;

import java.util.List;

public class Demon extends Ghost {

    private String demonHorns;

    public Demon(List<String> values) {
        super(values.get(1));
        this.demonHorns = values.get(0);
    }

    public String getDemonHorns() {
        return demonHorns;
    }

    public void setDemonHorns(String demonHorns) {
        this.demonHorns = demonHorns;
    }

    @Override
    public String toString() {
        return super.toString() + " - " + this.demonHorns;
    }
}
