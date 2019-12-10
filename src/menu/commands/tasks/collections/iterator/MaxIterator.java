package menu.commands.tasks.collections.iterator;

import menu.commands.tasks.collections.List;

import static menu.commands.tasks.collections.iterator.EnumMaxForIterator.INITIAL_AMOUNT;
import static menu.commands.tasks.collections.iterator.EnumMaxForIterator.NOT_FOUND;

public class MaxIterator implements Iterator {
    private int index;
    private List list;

    public MaxIterator(List list) {
        this.index = INITIAL_AMOUNT.getValue();
        this.list = list;
    }

    @Override
    public boolean hasNext() throws Exception {
        return index < list.size();
    }

    @Override
    public long next() throws Exception {
        if (list.size() != INITIAL_AMOUNT.getValue()) {
            return list.get(index++);
        } else {
            return NOT_FOUND.getValue();
        }
    }

    @Override
    public void remove() throws Exception {
        if (index != INITIAL_AMOUNT.getValue()) {
            list.remove(index - 1);
        } else {
            throw new Exception();
        }
    }
}

