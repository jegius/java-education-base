package menu.commands.tasks.generics.alex;

import menu.commands.tasks.exceptions.OutOfArrayLength;

public class AlexGenArrayList <T>{
    private Object[] values;
    private int size;

    public AlexGenArrayList() {
        this.size = 0;
        values = new Object[100];
    }

    public void add(T value) {
        values[size++] = value;
    }

    public T get(int id) throws OutOfArrayLength {
        if (id < 0 || id > size) {
            throw new OutOfArrayLength();
        } else {
            return (T) values[id];
        }
    }

    public int getSize() {
        return size;
    }

    public void printElements() {
        for (int index = 0; index < size; index++) {
            try {
                System.out.println(get(index));
            } catch (OutOfArrayLength outOfArrayLength) {
                outOfArrayLength.printStackTrace();
            }
        }
        System.out.println("________________");
    }

    public boolean compare(AlexGenArrayList listForComparison) throws OutOfArrayLength {
        if (size != listForComparison.getSize()) {
            return false;
        }
        for (int index = 0; index < size; index++) {
            if (!isEqual(index, listForComparison)) {
                return false;
            }
        }
        return true;
    }

    private boolean isEqual(int index, AlexGenArrayList listForComparison) throws OutOfArrayLength {
        return this.get(index).equals(listForComparison.get(index));
    }
}
