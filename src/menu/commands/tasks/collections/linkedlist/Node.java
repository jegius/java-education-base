package menu.commands.tasks.collections.linkedlist;

public class Node {
    private long nData;
    private  int id;
    private Node next;

    public Node(int id,long data) {
        this.id = id;
        this.nData = data;
    }

    public long getnData() {
        return nData;
    }

    public void setnData(long nData) {
        this.nData = nData;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
