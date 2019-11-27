package menu.commands.tasks.collections.linkedlist;

public class MaxNode {
    private int index;
    private long value;

    private MaxNode next;

    public MaxNode(int index, long value) {
        this.index = index;
        this.value = value;
    }

    public int getIndex() {
        return index;
    }

    public long getValue() {
        return value;
    }

    public MaxNode getNext() {
        return next;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public void setValue(long value) {
        this.value = value;
    }

    public void setNext(MaxNode next) {
        this.next = next;
    }
}
