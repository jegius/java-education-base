package menu.commands.tasks.generics.alex.objects;

import java.util.Map;

import static menu.commands.tasks.generics.alex.objects.FieldsNames.*;

public class WildDog extends Dog {

    String area;

    public WildDog(Map<String, String> values) {
        super(values.get(NICKNAME.getName()));
        fillFields(this.getClass(),this,values);
    }

    public String getArea() {
        return area;
    }

    @Override
    public boolean equals(Object object) {
        String thisClassName = this.getClass().getName();
        String objectClassName = object.getClass().getName();
        if (!thisClassName.equals(objectClassName)) {
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
