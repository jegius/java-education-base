package menu.commands.tasks.generics.alex.objects.dogs;

import java.util.Map;

import static menu.commands.tasks.generics.alex.objects.FieldsNames.*;

public class WildDog extends Dog {

    private String area;

    public WildDog(Map<String, String> values) {
        super(values.get(NICKNAME.getName()));
        this.area = values.get(AREA.getName());
    }

    public String getArea() {
        return area;
    }

    @Override
    public boolean equals(Object object) {
        if (!this.getClass().getName().equals(object.getClass().getName())) {
            return false;
        }
        WildDog wildDog = (WildDog) object;
        String thisNickName = this.getNickName();
        String objectNickName = wildDog.getNickName();
        String thisArea = this.getArea();
        String objectArea = wildDog.getArea();

        return thisNickName == objectNickName &&
                thisArea == objectArea;
    }

    @Override
    public String toString() {
        return super.toString() + " lives in the " + this.area;
    }
}
