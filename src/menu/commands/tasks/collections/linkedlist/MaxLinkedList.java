package menu.commands.tasks.collections.linkedlist;

import menu.commands.tasks.collections.List;
import menu.commands.tasks.collections.arraylist.ExceptionsOutOfArraySize;
import menu.commands.tasks.collections.iterator.MaxIterator;
import static menu.commands.tasks.collections.linkedlist.EnumMaxList.*;

public class MaxLinkedList implements List {

    private MaxNode maxNode;
    private int size;
    private int index;

    public MaxLinkedList() {
        this.maxNode = null;
        this.size = INITIAL_AMOUNT.getValue();
        this.index = INITIAL_AMOUNT.getValue();
    }

    @Override
    public void add(long data) throws Exception {
        if (isEmpty()) {
            maxNode = new MaxNode(index, data);
        } else {
            getLastMaxNode().
                    setNext(new MaxNode(index, data));
        }
        size++;
        index++;
    }

    @Override
    public boolean remove(int id) throws Exception {
        if (isEmpty() || id < 0 || id > size) {
            throw new ExceptionsOutOfArraySize();
        }
        if (id == 0) {
            maxNode = maxNode.getNext();
        } else {
            MaxNode previous = getNodeByID(id - 1);
            MaxNode next = getNodeByID(id + 1);
            previous.setNext(next);
        }
        updateIndexes(id);
        size--;
        index--;
        return true;
    }

    @Override
    public long find(long value) throws Exception {
        MaxNode currentNode = maxNode;
        while (currentNode != null && currentNode.getValue() != value) {
            currentNode = currentNode.getNext();
        }
        return currentNode != null ?
                currentNode.getIndex() :
                INVALID_INDEX.getValue();
    }

    @Override
    public long get(int index) throws Exception {
        if (index < 0 || index > size) {
            throw new ExceptionsOutOfArraySize();
        }
        MaxNode currentNode = maxNode;
        while (currentNode.getNext() != null && currentNode.getIndex() != index) {
            currentNode = currentNode.getNext();
        }
        return currentNode.getValue();
    }

    @Override
    public void update(int index, long data) throws Exception {
        if (index < 0 || index > size) {
            throw new ExceptionsOutOfArraySize();
        } else {
            getNodeByID(index).
                    setValue(data);
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
        maxNode = null;
        index = INITIAL_AMOUNT.getValue();
        size = INITIAL_AMOUNT.getValue();
        return true;
    }

    @Override
    public long getMin() throws Exception {
        if (isEmpty()) {
            throw new ExceptionEmptyArray();
        }
        MaxNode currentNode = maxNode;
        long minValue = currentNode.getValue();
        while (currentNode != null) {
            if (minValue > currentNode.getValue()) {
                minValue = currentNode.getValue();
            }
            currentNode = currentNode.getNext();
        }
        return minValue;
    }

    @Override
    public long getMax() throws Exception {
        if (isEmpty()) {
            throw new ExceptionEmptyArray();
        }
        MaxNode currentNode = maxNode;
        long maxValue = currentNode.getValue();
        while (currentNode != null) {
            if (maxValue < currentNode.getValue()) {
                maxValue = currentNode.getValue();
            }
            currentNode = currentNode.getNext();
        }
        return maxValue;
    }

    @Override
    public MaxIterator getIterator() throws Exception {
        return new MaxIterator(this);
    }

    private boolean isEmpty() {
        return maxNode == null;
    }

    private MaxNode getLastMaxNode() {
        MaxNode currentNode = maxNode;
        while (currentNode.getNext() != null) {
            currentNode = currentNode.getNext();
        }
        return currentNode;
    }

    private MaxNode getNodeByID(int id) {
        MaxNode current = maxNode;
        while (current != null && current.getIndex() != id) {
            current = current.getNext();
        }
        return current;
    }

    private void updateIndexes(int id) {
        MaxNode current = getNodeByID(id + 1);
        while (current != null) {
            current.setIndex(current.getIndex() - 1);
            current = current.getNext();
        }
    }
}
