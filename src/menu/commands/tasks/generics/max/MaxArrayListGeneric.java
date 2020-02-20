package menu.commands.tasks.generics.max;

import static menu.commands.tasks.generics.max.EnumForMonsters.*;

public class MaxArrayListGeneric <T> {
    private Object[] values;
    private int size;

    public MaxArrayListGeneric() {
        this.values = new Object[ELEMENTS_OF_ARRAY.getValue()];
        this.size = INITIAL_AMOUNT.getValue();
    }

    public T get(int index) throws ExceptionsOutOfArrSizeGeneric {
        if (index >= 0 && index < values.length) {
            return (T) values[index];
        } else {
            throw new ExceptionsOutOfArrSizeGeneric();
        }
    }

    public void add(T data) {
        Object[] temp = values;
        if (size == values.length - 1) {
            values = new Object[temp.length + NEW_NUMBER_ELEMENTS_OF_ARRAY.getValue()];
            System.arraycopy(
                    temp,
                    START_POSITION_OF_INITIAL_ARRAY.getValue(),
                    values,
                    START_POSITION_OF_NEW_ARRAY.getValue(),
                    temp.length
            );
        }
        values[size] = data;
        size++;
    }

    public void printElements() {
        for (int element = 0; element < size; element++) {
            System.out.println(values[element]);
        }
    }
}
