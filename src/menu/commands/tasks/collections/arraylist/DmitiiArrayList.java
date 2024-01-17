package menu.commands.tasks.collections.arraylist;

import menu.commands.tasks.collections.List;
import menu.commands.tasks.collections.iterator.DmitriiIterator;
import menu.commands.tasks.collections.iterator.Iterator;


import static menu.commands.tasks.collections.arraylist.DmitriiEnum.*;
import static menu.commands.tasks.collections.arraylist.EnumMax.INITIAL_AMOUNT;
import static menu.commands.tasks.collections.arraylist.EnumMax.INVALID_INDEX;
import static menu.commands.tasks.collections.arraylist.NumbersForAlexArray.FIRST_ELEMENT_OF_ARRAY;
import static menu.commands.tasks.collections.arraylist.NumbersForAlexArray.INITIAL_ARRAY_SIZE;

public class DmitiiArrayList implements List {

    private static long[] value;
    private int size;

    public DmitiiArrayList() {
        this.value = new long[INITIAL_AMOUNT.getValue()];
        this.size = INITIAL_AMOUNT.getValue();
    }

    @Override
    public void add(long data) throws Exception {
        long[] arraytemp = value;
        value = new long[value.length + 1];
        System.arraycopy(arraytemp,
                START_POSITION_OF_INITIAL_ARRAY.getValue(),
                value,
                START_POSITION_OF_NEW_ARRAY.getValue(),
                arraytemp.length);
        value[value.length - 1] = data;
        size++;
    }

    @Override
    public boolean remove(int id) throws Exception {
        if (id < INITIAL_AMOUNT.getValue() || id > size - 1) {
            throw new ExceptionsOutOfArraySize();
        }
        for (int index = id; index < size; index++) {
            if (index + 1 >= size) {
                value[index] = 0;
            } else {
                value[index] = value[index + 1];
            }
        }
        size--;
        return true;
    }

    @Override
    public long find(long val) throws Exception {
        boolean findmarker = false;
        long findValue = 0;
        for (int index = 0; index < size; index++) {
            if (value[index] == val) {
                findmarker = true;
                findValue = index;
                break;
            }
        }
        if (findmarker) {
            return findValue;
        } else {
            return INVALID_INDEX.getValue();
        }
    }

    @Override
    public long get(int index) throws Exception {
        if (index < value.length && index >= 0) {
            return value[index];
        } else {
            throw new ExceptionsOutOfArraySize();
        }
    }

    @Override
    public void update(int index, long data) throws Exception {
        if (index < value.length && index >= 0) {
            value[index] = data;
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
        long temp;
        for (int oneCicle = 0; oneCicle < size; oneCicle++) {
            for (int twoCicle = size - 1; twoCicle > oneCicle; twoCicle--) {
                if (value[twoCicle - 1] > value[twoCicle]) {
                    temp = value[twoCicle - 1];
                    value[twoCicle - 1] = value[twoCicle];
                    value[twoCicle] = temp;
                }
            }
        }
    }

    @Override
    public void quickSort() throws Exception {
        quickSort(0, size);
    }

    public static void quickSort(int low, int high) {
        if (value.length == 0)
            return;

        if (low >= high)
            return;

        int middle = low + (high - low) / 2;
        long opora = value[middle];

        int i = low, j = high;
        while (i <= j) {
            while (value[i] < opora) {
                i++;
            }

            while (value[j] > opora) {
                j--;
            }

            if (i <= j) {
                long temp = value[i];
                value[i] = value[j];
                value[j] = temp;
                i++;
                j--;
            }
        }

        if (low < j)
            quickSort(low, j);

        if (high > i)
            quickSort(i, high);
    }

    @Override
    public boolean removeAll() throws Exception {
        value = new long[INITIAL_ARRAY_SIZE.getValue()];
        size = 0;
        return true;
    }

    @Override
    public long getMin() throws Exception {
        long minimum = value[FIRST_ELEMENT_OF_ARRAY.getValue()];
        for (int index = 0; index < size; index++) {
            if (value[index] < minimum) {
                minimum = value[index];
            }
        }
        return minimum;
    }

    @Override
    public long getMax() throws Exception {
        long maximum = value[FIRST_ELEMENT_OF_ARRAY.getValue()];
        for (int index = 0; index < size; index++) {
            if (value[index] > maximum) {
                maximum = value[index];
            }
        }
        return maximum;
    }

    @Override
    public Iterator getIterator() throws Exception {
        return new DmitriiIterator(this);
    }
}
