package menu.commands.tasks.collections.iterator;

public interface Iterator {
    boolean hasNext() throws Exception;
    long next() throws Exception;
    void remove() throws Exception;
}
