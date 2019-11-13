package menu.commands.tasks.collections.arraylist;

import menu.commands.tasks.collections.List;
import menu.commands.tasks.collections.iterator.AlexIterator;
import menu.commands.tasks.exceptions.OutOfArrayLength;

import static menu.commands.tasks.collections.arraylist.NumbersForAlexArray.*;

public class AlexArrayList implements List {
    private long[] values;
    private int size;

    public AlexArrayList() {
        this.values = new long[INITIAL_ARRAY_SIZE.getValue()];
        this.size = 0;
    }

    @Override
    public void add(long data) throws Exception {
        if (size == values.length) {
            long[] temp = values;
            values = new long[values.length + ADDED_AMOUNT_FOR_ARRAY.getValue()];
            System.arraycopy(temp,
                    INITIAL_ELEMENT_OF_COPY.getValue(),
                    values,
                    INITIAL_ELEMENT_OF_PASTE.getValue(),
                    temp.length);
        }
        values[size] = data;
        size++;
    }

    @Override
    public boolean remove(int id) throws Exception {
        if (id < 0 || id >= size) {
            throw new OutOfArrayLength();
        }
        for (int index = id; index < size; index++) {
            if (index + 1 == size) {
                values[index + 1] = 0;
            } else {
                values[index] = values[index + 1];
            }
        }
        size--;
        return true;
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
        return isFound ? foundIndex : NOT_FOUND.getValue();
    }

    @Override
    public long get(int index) throws Exception {
        if (index >= 0 && index < size) {
            return values[index];
        } else {
            throw new OutOfArrayLength();
        }
    }

    @Override
    public void update(int index, long data) throws Exception {
        if (index >= 0 && index < size) {
            values[index] = data;
        } else {
            throw new OutOfArrayLength();
        }
    }

    @Override
    public int size() throws Exception {
        return size;
    }

    @Override
    public void bubbleSort() throws Exception {
        int outerCircle;
        int innerCircle;
        for (outerCircle = 0; outerCircle < (size - 1); outerCircle++) {
            for (innerCircle = 0; innerCircle < (size - 1 - outerCircle); innerCircle++) {
                if (values[innerCircle] > values[innerCircle + 1]) {
                    swap(innerCircle, innerCircle + 1);
                }
            }
        }
    }

    @Override
    public void quickSort() throws Exception {
        recQuickSort(0, size - 1);
    }

    @Override
    public boolean removeAll() throws Exception {
        values = new long[INITIAL_ARRAY_SIZE.getValue()];
        size = 0;
        return true;
    }

    @Override
    public long getMin() throws Exception {
        long min = values[FIRST_ELEMENT_OF_ARRAY.getValue()];
        for (int index = 1; index < size; index++) {
            if (values[index] < min) {
                min = values[index];
            }
        }
        return min;
    }

    @Override
    public long getMax() throws Exception {
        long max = values[FIRST_ELEMENT_OF_ARRAY.getValue()];
        for (int index = 1; index < size; index++) {
            if (values[index] > max) {
                max = values[index];
            }
        }
        return max;
    }

    @Override
    public AlexIterator getIterator() throws Exception {
        return new AlexIterator(this);
    }

    private void swap(int left, int right) {
        long temp = values[left];
        values[left] = values[right];
        values[right] = temp;
    }

    private int dividerIndex(int left, int right, long pivot) {
        int leftPointer = left - 1;
        int rightPointer = right;
        while (true) {
            while (leftPointer < right && values[++leftPointer] < pivot) ;
            while (rightPointer > left && values[--rightPointer] > pivot) ;
            if (leftPointer >= rightPointer) {
                break;
            } else {
                swap(leftPointer, rightPointer);
            }
        }
        swap(leftPointer, right);
        return leftPointer;
    }

    private void recQuickSort(int left, int right) {
        if (left >= right) {
            return;
        } else {
            long pivot = values[right];
            int devidedPivot = dividerIndex(left, right, pivot);
            recQuickSort(left, devidedPivot - 1);
            recQuickSort(devidedPivot + 1, right);
        }
    }
}


