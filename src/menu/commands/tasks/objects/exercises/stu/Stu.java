package menu.commands.tasks.objects.exercises.stu;

import menu.commands.tasks.objects.exercises.Organization;
import menu.commands.tasks.objects.exercises.stu.manager.Director;
import menu.commands.tasks.objects.exercises.stu.manager.Leader;
import menu.commands.tasks.objects.exercises.stu.manager.Manager;

public class Stu extends Organization {
    @Override
    public void start() {
        Manager manager1 = new Manager("Алексей","Иванов", 21, 19000);
        Manager manager2 = new Manager("Мария","Иванова", 22, 21000);
        Manager manager3 = new Manager("Мария","Приходько", 23, 22000);
        Manager manager4 = new Manager("Иван","Кузнецов", 24, 22000);

        Manager[] firstGroup = {
                manager1, manager2
        };
        Manager[] secondGroup = {
                manager3, manager4
        };

        Leader leader1 = new Leader("Иван","Курчатов", 32, firstGroup,32000);
        Leader leader2 = new Leader("Марьям","Церетели", 27, secondGroup,42000);

        Leader[] leaders = {
          leader1, leader2
        };
        Director director = new Director("Алексей","Степанов", 47, leaders,52000);
        director.doWork();
    }

}
