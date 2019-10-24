package menu.commands.tasks.collections.arraylist;

import menu.commands.tasks.collections.List;
import menu.commands.tasks.collections.iterator.StubIterator;

import static menu.commands.tasks.collections.arraylist.EnumMax.*;

public class MaxArrayList implements List {
    private long[] values;
    private int size;

    public MaxArrayList() {
        this.values = new long[INITIAL_AMOUNT.getValue()];
        this.size = INITIAL_AMOUNT.getValue();
    }

    @Override
    public void add(long data) throws Exception {
        long[] temp = values;
        values = new long[values.length + 1];
        System.arraycopy(
                temp,
                START_POSITION_OF_INITIAL_ARRAY.getValue(),
                values,
                START_POSITION_OF_NEW_ARRAY.getValue(),
                temp.length
        );
        values[values.length - 1] = data;
        size++;
    }

    @Override
    public boolean remove(int id) throws Exception {
        if (id < INITIAL_AMOUNT.getValue() || id > size - 1) {
            throw new ExceptionsOutOfArraySize();
        }
        for (int index = id; index < size; index++) {
            if (index + 1 >= size) {
                values[index] = 0;
            } else {
                values[index] = values[index + 1];
            }
        }
        size--;
        return true;
    }

    @Override
    public long find(long value) throws Exception {
        long findValue = 0;
        boolean isFound = false;
        for (int index = 0; index < size; index++) {
            if (values[index] == value) {
                findValue = index;
                isFound = true;
                break;
            }
        }
        return isFound ? findValue : INVALID_INDEX.getValue();
    }


    @Override
    public long get(int index) throws Exception {
        if (index >= 0 && index < values.length) {
            return values[index];
        } else {
            throw new ExceptionsOutOfArraySize();
        }
    }

    @Override
    public void update(int index, long data) throws Exception {
        if (index >= 0 && index < values.length) {
            values[index] = data;
        } else {
            throw new ExceptionsOutOfArraySize();
        }
    }

    @Override
    public int size() throws Exception {
        return size;
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
        values = new long[INITIAL_AMOUNT.getValue()];
        size = INITIAL_AMOUNT.getValue();
        return true;
    }

    @Override
    public long getMin() throws Exception {
        long minValue = values[INITIAL_AMOUNT.getValue()];
        for (int index = 0; index < size; index++) {
            if (values[index] < minValue) {
                minValue = values[index];
            }
        }
        return minValue;
    }

    @Override
    public long getMax() throws Exception {
        long maxValue = values[INITIAL_AMOUNT.getValue()];
        for (int index = 0; index < size; index++) {
            if (values[index] > maxValue) {
                maxValue = values[index];
            }
        }
        return maxValue;
    }

    @Override
    public StubIterator getIterator() throws Exception {
        throw new Exception("No realization for this method!");
    }
}