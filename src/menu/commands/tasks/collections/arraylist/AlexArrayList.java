package menu.commands.tasks.collections.arraylist;

import menu.commands.tasks.collections.List;
import menu.commands.tasks.collections.iterator.StubIterator;
import menu.commands.tasks.exceptions.OutOfArrayLength;

public class AlexArrayList implements List {
    private long[] values;

    public AlexArrayList() {
        values = new long[0];
    }

    @Override
    public void add(long data) throws Exception {
        long[] temp = values;
        values = new long[values.length + 1];
        System.arraycopy(temp, 0, values, 0, temp.length);
        values[values.length - 1] = data;
    }

    @Override
    public boolean remove(int id) throws Exception {
        if (id > 0 && id < values.length) {
            long[] temp = values;
            values = new long[values.length - 1];
            System.arraycopy(temp, 0, values, 0, id);
            System.arraycopy(temp, id + 1, values, id, temp.length - id - 1);
            return true;
        } else {
            throw new OutOfArrayLength();
        }
    }

    @Override
    public long find(long value) throws Exception {
        int foundIndex = 0;
        boolean isFound = false;
        for (long valueFromValues : values) {
            if (valueFromValues == value) {
                isFound = true;
                break;
            }
            foundIndex++;
        }
        return isFound ? foundIndex : -1;
    }

    @Override
    public long get(int index) throws Exception {
        return values[index];
    }

    @Override
    public void update(int index, long data) throws Exception {
        values[index] = data;
    }

    @Override
    public int size() throws Exception {
        return values.length;
    }

    @Override
    public void bubbleSort() throws Exception {
        throw new Exception("No realization for this method!");
    }

    @Override
    public void quickSort() throws Exception {
        throw new Exception("No realization for this method!");
    }

    @Override
    public boolean removeAll() throws Exception {
        values  = new long[0];
        return true;
    }

    @Override
    public long getMin() throws Exception {
        long comparable = values[0];
        for (long valueFromValues : values) {
            if (valueFromValues < comparable) {
                comparable = valueFromValues;
            }
        }
        return comparable;
    }

    @Override
    public long getMax() throws Exception {
        long comparable = values[0];
        for (long valueFromValues : values) {
            if (valueFromValues > comparable) {
                comparable = valueFromValues;
            }
        }
        return comparable;
    }

    @Override
    public StubIterator getIterator() throws Exception {
        throw new Exception("No realization for this method!");
    }
}
