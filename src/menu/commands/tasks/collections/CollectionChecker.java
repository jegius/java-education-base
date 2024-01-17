package menu.commands.tasks.collections;

import menu.Command;
import menu.commands.tasks.collections.eduexception.*;
import menu.commands.tasks.collections.fillingoututil.FillingOutUtil;
import menu.commands.tasks.collections.iterator.Iterator;

public class CollectionChecker {
    private final Command taskCommand;
    private static CollectionChecker instance;
    private FillingOutUtil fillingOutUtil;
    private int assessment;
    private static final int ARRAY_LIST_INDEX = 0;
    private static final int LINKED_LIST_INDEX = 1;

    private CollectionChecker(Command taskCommand) {
        this.assessment = 0;
        this.taskCommand = taskCommand;
    }

    public static synchronized CollectionChecker getInstance() {
        if (instance == null) {
            instance = new CollectionChecker(CollectionTaskCommand.getInstance());
        }
        return instance;
    }


    Command checkTask(List[] lists, FillingOutUtil fillingOutUtil) {
        this.fillingOutUtil = fillingOutUtil;
        this.assessment = 0;

        try {
            checkFourthStage(lists[LINKED_LIST_INDEX]);
            checkFifthStage(lists[ARRAY_LIST_INDEX]);

        } catch (
                FourthStageException
                        | FifthStageException exception
        ) {
            System.out.println(exception.getMessage());
        }
        System.out.println("Mark for the task: " + getMark());

        return taskCommand;
    }

    private String getMark() {
        switch (assessment) {
            case 0:
                return "Fail";
            case 1:
                return "Enough";
            case 3:
                return "Diversely";
            case 4:
                return "Creditable";
            case 5:
                return "Beautiful";
            default:
                return "Unfair";
        }
    }

    private void checkFifthStage(List list) throws FifthStageException {
        try {
            long min = 13;
            long max = 12345;

            list.add(max);
            list.add(min);
            list.add(44);
            list.add(1234);
            list.add(444);
            list.add(474);
            list.add(344);
            list.add(56);

            list.bubbleSort();

            if (min != list.get(0)) {
                throw new Exception();
            }

            if (max != list.get(list.size() - 1)) {
                throw new Exception();
            }

            list = (List) fillingOutUtil.fillList(list, 100000);
            list.quickSort();
            assessment++;
        } catch (Exception exception) {
            throw new FifthStageException("Error with completing fifth task!");
        }
    }

    private void checkFourthStage(List list) throws FourthStageException {
        try {
            checkFirstStage(list);
            checkSecondStage(list);
            checkThirdStage(list);

            assessment++;
        } catch (Exception exception) {
            throw new FourthStageException("Error with completing fourth task!");
        }
    }

    private void checkThirdStage(List list) throws ThirdStageException {
        try {
            int expectedLength = 200;
            list = (List) fillingOutUtil.fillList(list, expectedLength);

            if (list.size() != expectedLength) {
                throw new Exception();
            }
            list.removeAll();

            assessment++;
        } catch (Exception exception) {
            throw new ThirdStageException("Error with completing third task!");
        }
    }

    private void checkSecondStage(List list) throws SecondStageException {
        try {
            list.add(12);
            list.add(22);
            list.add(44);
            StringBuilder expectedResult = new StringBuilder();

            Iterator iterator = list.getIterator();

            while (iterator.hasNext()) {
                expectedResult.append(iterator.next());
            }

            if (!expectedResult.toString().equals("122244")) {
                throw new Exception();
            }

            iterator = list.getIterator();

            while (iterator.hasNext()) {
                long nextValue = iterator.next();
                if (nextValue == 22) {
                    iterator.remove();
                }
            }

            expectedResult = new StringBuilder();
            iterator = list.getIterator();

            while (iterator.hasNext()) {
                expectedResult.append(iterator.next());
            }

            if (!expectedResult.toString().equals("1244")) {
                throw new Exception();
            }

            list.removeAll();
            assessment++;
        } catch (Exception exception) {
            throw new SecondStageException("Error with completing second task!");
        }
    }

    private void checkFirstStage(List listForChecking) throws FirstStageException {

        try {
            long min = 1;
            long max = 144;

            listForChecking.add(12);
            listForChecking.add(13);
            listForChecking.add(126);
            listForChecking.add(max);
            listForChecking.add(min);


            System.out.println(listForChecking.get(2));
            long changeDataER = 122;

            listForChecking.update(2, changeDataER);

            if (listForChecking.get(2) != changeDataER) {
                throw new Exception();
            }

            long oldSize = listForChecking.size();
            boolean isRemove = listForChecking.remove(2);

            if (!isRemove && oldSize != listForChecking.size() - 1) {
                throw new Exception();
            }

            boolean isNoException = false;
            try {
                listForChecking.remove(300);
                System.out.println("No exception with trying to remove invalid index!");

                isNoException = true;

            } catch (Exception e) {
                System.out.println("Exception successful catched!");
            }

            if (isNoException) {
                throw new Exception();
            }


            long findER = 13;
            int expectedPosition = 1;

            if (listForChecking.find(findER) != expectedPosition) {
                throw new Exception();
            }

            if (listForChecking.getMin() != min || listForChecking.getMax() != max) {
                throw new Exception();
            }

            boolean isAllElementRemoved = listForChecking.removeAll();

            if (!isAllElementRemoved || listForChecking.size() != 0) {
                throw new Exception();
            }

            assessment++;
        } catch (Exception exception) {
            throw new FirstStageException("Error with completing first task!");
        }
    }
}
