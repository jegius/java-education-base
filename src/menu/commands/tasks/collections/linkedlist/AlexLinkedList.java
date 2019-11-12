package menu.commands.tasks.collections.linkedlist;

import menu.commands.tasks.collections.List;
import menu.commands.tasks.collections.exception.NullNodeException;
import menu.commands.tasks.collections.exception.OutOfSizeException;
import menu.commands.tasks.collections.iterator.AlexIterator;

import static menu.commands.tasks.collections.linkedlist.NumbersForAlexLinkedList.*;

public class AlexLinkedList implements List {

    private Node node;
    private int size;
    private int id;

    public AlexLinkedList() {
        node = null;
        size = INITIAL_SIZE.getValue();
        id = INITIAL_ID.getValue();
    }

    @Override
    public void add(long data) throws Exception {
        if (isEmpty()) {
            node = new Node(id, data);
        } else {
            getLastNode().setNext(new Node(id, data));
        }
        id++;
        size++;
    }

    @Override
    public boolean remove(int id) throws Exception {
        if (isEmpty() || id < INITIAL_ID.getValue() || id > size) {
            throw new OutOfSizeException();
        } else {
            Node prevNode = getNodeById(id - 1);
            Node nextNode = getNodeById(id + 1);
            if (prevNode != null) {
                prevNode.setNext(nextNode);
            } else {
                node.setNext(nextNode);
            }
            updateNode(id);
            size--;
            this.id--;
            return true;
        }
    }

    @Override
    public long find(long value) throws Exception {
        Node currentNode = node;
        while (currentNode.getnData() != value) {
            currentNode = currentNode.getNext();
            if (currentNode.getId() == size - 1) {
                break;
            }
        }
        return currentNode == null
                ? NOT_FOUND.getValue()
                : currentNode.getId();
    }

    @Override
    public long get(int index) throws Exception {
        if (index >= INITIAL_ID.getValue() && index < size) {
            Node currentNode = node;
            while (currentNode.getId() != index) {
                currentNode = currentNode.getNext();
            }
            return currentNode.getnData();
        } else throw new OutOfSizeException();
    }

    @Override
    public void update(int index, long data) throws Exception {
        Node searchedNode = getNodeById(index);
        if (searchedNode == null) {
            throw new NullNodeException();
        } else {
            searchedNode.setnData(data);
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
        size = INITIAL_SIZE.getValue();
        id = INITIAL_ID.getValue();
        return true;
    }

    @Override
    public long getMin() throws Exception {
        if (size > INITIAL_SIZE.getValue()) {
            Node currentNode = node;
            long minData = currentNode.getnData();
            for (int index = 0; index < size; index++) {
                Node indexNode = getNodeById(index);
                if (indexNode != null && indexNode.getnData() < minData) {
                    minData = indexNode.getnData();
                }
            }
            return minData;
        } else {
            return 0;
        }
    }

    @Override
    public long getMax() throws Exception {
        if (size > INITIAL_SIZE.getValue()) {
            Node currentNode = node;
            long maxData = currentNode.getnData();
            for (int index = 0; index < size; index++) {
                Node indexNode = getNodeById(index);
                if (indexNode != null && indexNode.getnData() > maxData) {
                    maxData = indexNode.getnData();
                }
            }
            return maxData;
        } else {
            return 0;
        }
    }

    @Override
    public AlexIterator getIterator() throws Exception {
        return new AlexIterator(this);
    }

    @Override
    public String toString() {
        return super.toString();
    }

    private boolean isEmpty() {
        return node == null;
    }

    private Node getLastNode() {
        Node currentNode = node;
        while (currentNode.getNext() != null) {
            currentNode = currentNode.getNext();
        }
        return currentNode;
    }

    private void updateNode(int index) {
        Node currentNode = getNodeById(index + 1);
        while (currentNode != null) {
            currentNode.setId(currentNode.getId() - 1);
            currentNode = currentNode.getNext();
        }
    }

    private Node getNodeById(int id) {
        if (id >= INITIAL_ID.getValue() && id <= size) {
            Node currentNode = node;
            while (currentNode.getId() != id) {
                currentNode = currentNode.getNext();
            }
            return currentNode;
        } else {
            return null;
        }
    }
}
