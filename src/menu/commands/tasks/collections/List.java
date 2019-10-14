package menu.commands.tasks.collections;

import menu.commands.tasks.collections.iterator.Iterator;

public interface List {
    void add(long data) throws Exception;

    boolean remove(int id) throws Exception;

    long find(long value) throws Exception;

    long get(int index) throws Exception;

    void update(int index, long data) throws Exception;

    int size() throws Exception;

    void bubbleSort() throws Exception;

    void quickSort() throws Exception;

    boolean removeAll() throws Exception;

    long getMin() throws Exception;

    long getMax() throws Exception;

    /* *
     *  Этап 2
     * */
    Iterator getIterator() throws Exception;
}
