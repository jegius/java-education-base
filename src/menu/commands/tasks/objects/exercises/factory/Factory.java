package menu.commands.tasks.objects.exercises.factory;

import menu.commands.tasks.objects.exercises.Organization;
import menu.commands.tasks.objects.exercises.factory.employees.Director;
import menu.commands.tasks.objects.exercises.factory.employees.Employee;
import menu.commands.tasks.objects.exercises.factory.employees.Master;

public class Factory extends Organization {


    public void start() {
        Employee employeeOne = new Employee("Джеймс", "Бонд", "Слесарь", 23);
        Employee employeeTwo = new Employee("Генри", "Эйдсвил", "Слесарь второго разряда", 31);
        Employee employeeThree = new Employee("Дик", "Чейни", "Электрик", 55);
        Employee employeeFour = new Employee("Джордж", "Буш", "Водопроводчик", 30);
        Employee employeeFive = new Employee("Майкл", "Окконел", "Слесарь", 54);

        Employee[] fistGroup = {
                employeeOne,
                employeeTwo
        };

        Employee[] secondGroup = {
                employeeThree,
                employeeFour,
                employeeFive
        };

        Master firstMaster = new Master("David", "Firstman", "Начальник бригады", fistGroup, 43);
        Master secondMaster = new Master("Jon", "Doe", "Зам начальника бригады", secondGroup, 56);

        Master[] masters = {
                firstMaster,
                secondMaster
        };

        Director director = new Director("Donald", "Tramp", "Дирктор завода", masters, 45);

        director.doWork();
    }
}
