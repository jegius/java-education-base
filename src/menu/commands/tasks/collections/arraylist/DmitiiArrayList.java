package menu.commands.tasks.collections.arraylist;

import menu.commands.tasks.collections.List;
import menu.commands.tasks.collections.iterator.Iterator;


import static menu.commands.tasks.collections.arraylist.DmitriiEnum.*;
import static menu.commands.tasks.collections.arraylist.EnumMax.INITIAL_AMOUNT;
import static menu.commands.tasks.collections.arraylist.EnumMax.INVALID_INDEX;

public class DmitiiArrayList implements List {

    private long[] value;
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
        boolean findmarker=false;
        long findValue = 0;
        for (int index = 0; index < size; index++) {
            if (value[index] == val) {
                findmarker= true;
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
        if(index< value.length && index >=0){
            return value[index];
        }
        else {
            throw new ExceptionsOutOfArraySize();
        }
    }

    @Override
    public void update(int index, long data) throws Exception {
        if(index< value.length && index >=0){
            value[index]=data;
        }
        else {
            throw new ExceptionsOutOfArraySize();
        }
    }

    @Override
    public int size() throws Exception {
        return size;
    }

    @Override
    public void bubbleSort() throws Exception {

    }

    @Override
    public void quickSort() throws Exception {

    }

    @Override
    public boolean removeAll() throws Exception {
        return false;
    }

    @Override
    public long getMin() throws Exception {
        return 0;
    }

    @Override
    public long getMax() throws Exception {
        return 0;
    }

    @Override
    public Iterator getIterator() throws Exception {
        return null;
    }
}
