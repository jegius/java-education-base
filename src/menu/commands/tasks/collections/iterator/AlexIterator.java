package menu.commands.tasks.collections.iterator;

import menu.commands.tasks.collections.List;
import menu.commands.tasks.collections.arraylist.AlexArrayList;

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
        if(list.size() !=0) {
            return list.get(index++);
        } else {
            return -1;
        }
    }

    @Override
    public void remove() throws Exception {
        if (list.size() != 0)
        list.remove(index - 1);
    }
}
