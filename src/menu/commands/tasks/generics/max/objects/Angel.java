package menu.commands.tasks.generics.max.objects;

import java.util.List;

public class Angel extends Ghost {

    private String angelWings;

    public Angel(List<String> values) {
        super(values.get(1));
        this.angelWings = values.get(0);
    }

    public String getAngelWings() {
        return angelWings;
    }

    public void setAngelWings(String angelWings) {
        this.angelWings = angelWings;
    }

    public String toString() {
        return super.toString() + " - " + this.angelWings;
    }
}
