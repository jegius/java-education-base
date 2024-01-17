package menu.commands.tasks.collections.linkedlist;

import menu.commands.tasks.collections.List;
import menu.commands.tasks.collections.arraylist.ExceptionsOutOfArraySize;
import menu.commands.tasks.collections.iterator.DmitriiIterator;
import menu.commands.tasks.collections.iterator.Iterator;

import static menu.commands.tasks.collections.linkedlist.DmitriiEnum.*;

public class DmitriiLinkedList implements List {

    private Node node;
    private int size;
    private int index;

    public DmitriiLinkedList() {
        this.node = null;
        this.index = INVALID_INDEX.getValue();
        this.size = INITIAL_SIZE.getValue();
    }

    private boolean Empty() {
        return node == null;
    }

    @Override
    public void add(long data) throws Exception {
        if (Empty()) {
            node = new Node(index, data);
        } else {
            getLastNode().setNext(new Node(index, data));
        }
        index++;
        size++;
    }

    @Override
    public boolean remove(int id) throws Exception {
        if (Empty() || index < 0 || index > size) {
            throw new ExceptionEmptyArray();
        } else {
            Node next = getNodeID(id + 1);
            Node previous = getNodeID(id - 1);
            previous.setNext(next);
        }
        updateIndexes(index);
        size--;
        index--;
        return true;
    }

    @Override
    public long find(long value) throws Exception {
        Node currectNode = node;
        while (currectNode != null && currectNode.getnData() != value) {
            currectNode = currectNode.getNext();
        }
        if (currectNode != null) {
            return currectNode.getId();
        } else {
            return INVALID_INDEX.getValue();
        }
    }

    @Override
    public long get(int index) throws Exception {
        if (index < 0 || index > size) {
            throw new ExceptionsOutOfArraySize();
        } else {
            Node correctNode = node;
            while (correctNode.getNext() != null && correctNode.getId() != index) {
                correctNode = correctNode.getNext();
            }
            return correctNode.getnData();
        }
    }

    @Override
    public void update(int index, long data) throws Exception {
        if (index < 0 || index > size) {
            throw new ExceptionsOutOfArraySize();
        } else {
            getNodeID(index).setnData(data);
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
        node = null;
        index = INITIAL_AMOUNT.getValue();
        size = INITIAL_AMOUNT.getValue();
        return true;
    }

    @Override
    public long getMin() throws Exception {
        if (Empty()) {
            throw new ExceptionEmptyArray();
        } else {
            Node currectNode = node;
            long min = currectNode.getnData();
            for (int index = 0; index < size; index++) {
                Node indexNode = getNodeID(index);
                if (indexNode != null && indexNode.getnData() < min) {
                    min = indexNode.getnData();
                }
            }
            return min;
        }
    }

    @Override
    public long getMax() throws Exception {
        if (Empty()) {
            throw new ExceptionEmptyArray();
        } else {
            Node currectNode = node;
            long max = currectNode.getnData();
            for (int index = 0; index < size; index++) {
                Node indexNode = getNodeID(index);
                if (indexNode != null && indexNode.getnData() > max) {
                    max = indexNode.getnData();
                }
            }
            return max;
        }
    }

    @Override
    public Iterator getIterator() throws Exception {
        return new DmitriiIterator(this);
    }

    private Node getLastNode() {
        Node currectNode = node;
        while (currectNode != null) {
            currectNode = currectNode.getNext();
        }
        return currectNode;
    }

    private Node getNodeID(int id) {
        Node currect = node;
        while (currect != null && currect.getId() != id) {
            currect = currect.getNext();
        }
        return currect;
    }

    private void updateIndexes(int id) {
        Node currect = getNodeID(id + 1);
        while (currect != null) {
            currect.setId(currect.getId() - 1);
            currect = currect.getNext();
        }
    }
}
