package menu.commands.tasks.collections.iterator;

import menu.commands.tasks.collections.List;

import static menu.commands.tasks.collections.iterator.NumbersForAlexIterator.INITIAL_SIZE_OF_LIST;
import static menu.commands.tasks.collections.iterator.NumbersForAlexIterator.NOT_FOUND;

public class AlexIterator implements Iterator {
    private int index;
    private List list;

    public AlexIterator(List list) {
        this.index = 0;
        this.list = list;
    }

    @Override
    public boolean hasNext() throws Exception {
        return index < list.size();
    }

    @Override
    public long next() throws Exception {
        if (list.size() != INITIAL_SIZE_OF_LIST.getValue()) {
            return list.get(index++);
        } else {
            return NOT_FOUND.getValue();
        }
    }

    @Override
    public void remove() throws Exception {
        if (list.size() != INITIAL_SIZE_OF_LIST.getValue())
            list.remove(index - 1);
    }
}
