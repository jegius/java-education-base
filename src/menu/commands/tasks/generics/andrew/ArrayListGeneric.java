package menu.commands.tasks.generics.andrew;

public class ArrayListGeneric<T> {
    private Object[] values = new Object[ArrayListGenericConstant.INIT_SIZE.getValue()];
    private int size = 0;

    public void add(T item) {
        if (size == values.length - 1)
            resize(values.length * 2);
        values[size++] = item;
    }

    public T get(int index) {
        return (T) values[index];
    }

    public Object set(Object o, int index) {
        if (index >= size) {
            throw new IndexOutOfBoundsException();
        }
        Object oldObject = values[index];
        values[index] = o;
        return oldObject;
    }

    public void remove(int index) {
        for (int i = index; i < size; i++)
            values[i] = values[i + 1];
        values[size] = null;
        size--;
        if (values.length > ArrayListGenericConstant.INIT_SIZE.getValue() && size < values.length / ArrayListGenericConstant.CUT_RATE.getValue())
            resize(values.length / 2);
    }

    public int size() {
        return size;
    }

    private void resize(int newLength) {
        Object[] newArray = new Object[newLength];
        System.arraycopy(values, 0, newArray, 0, size);
        values = newArray;
    }

    public void printElements() {
        for (int i = 0; i < size; i++) {
            System.out.println(get(i));
        }
    }
}
