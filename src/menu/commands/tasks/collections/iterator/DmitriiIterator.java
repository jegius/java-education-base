package menu.commands.tasks.collections.iterator;

import menu.commands.tasks.collections.List;

import static menu.commands.tasks.collections.iterator.EnumDmitrii.NOT_FOUND;
import static menu.commands.tasks.collections.iterator.EnumDmitrii.INITIAL_SIZE_OF_LIST;

public class DmitriiIterator implements Iterator {
    private int index;
    private List list;

    public DmitriiIterator(List list) {
        this.index = 0;
        this.list = list;
    }

    @Override
    public boolean hasNext() throws Exception {
        return index < list.size();
    }

    @Override
    public long next() throws Exception {
        return list.size() != INITIAL_SIZE_OF_LIST.getValue() ? list.get(index++) : NOT_FOUND.getValue();
    }

    @Override
    public void remove() throws Exception {
        if (list.size() != INITIAL_SIZE_OF_LIST.getValue()) {
            list.remove(index - 1);
        }
    }
}
