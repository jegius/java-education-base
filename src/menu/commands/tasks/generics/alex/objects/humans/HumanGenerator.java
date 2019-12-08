package menu.commands.tasks.generics.alex.objects.humans;

import menu.commands.tasks.generics.alex.AlexGenArrayList;

public class HumanGenerator {
    private static final int amountOfHumans = 3;

    private String[] humansNames = new String[]{
            "Alex",
            "John",
            "Michale",
            "Jessica",
            "Max",
            "Pidr"
    };

    private int[] ages = new int[]{
            12,
            15,
            24,
            30,
            17,
            27
    };

    private String[] subjects = new String[]{
            "Math",
            "English",
            "History",
            "Literature",
            "Biology",
            "Java"
    };

    private String[] jobs = new String[]{
            "Programmer",
            "Teacher",
            "Engineer",
            "Actor",
            "Footbal player",
            "Whore"
    };

    private int getRandomNumber() {
        int max = 5;
        return (int) (Math.random() * max);
    }

    private Human generateHuman(int type) {
        if (type % 2 == 0) {
            return new Pupil(humansNames[getRandomNumber()],
                    ages[getRandomNumber()],
                    subjects[getRandomNumber()]);
        } else {
            return new Worker(humansNames[getRandomNumber()],
                    ages[getRandomNumber()],
                    jobs[getRandomNumber()]);
        }
    }

    public AlexGenArrayList generateHumans(AlexGenArrayList Humans) {
        for (int index = 0; index < amountOfHumans; index++) {
            Humans.add(generateHuman(getRandomNumber()));
        }
        return Humans;
    }
}
