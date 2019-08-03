package menu.commands.tasks.objects.exercises.dns;

import menu.commands.tasks.objects.exercises.Organization;
import menu.commands.tasks.objects.exercises.dns.employees.Director;
import menu.commands.tasks.objects.exercises.dns.employees.Employee;
import menu.commands.tasks.objects.exercises.dns.employees.RegionalManager;

public class Dns extends Organization {

    @Override
    public void start() {
        Employee employee1 = new Employee("Иван", "Алексеев", 25, "Продавец-консультант");
        Employee employee2 = new Employee("Роман", "Семенчук", 25, "Продавец-консультант");
        Employee employee3 = new Employee("Дмитрий", "Акулов", 24, "Продавец-консультант");
        Employee employee4 = new Employee("Валерий", "Крот", 27, "Продавец-консультант");
        Employee employee5 = new Employee("Павел", "Попов", 33, "Старший продавец-консультант");
        Employee employee6 = new Employee("Денис", "Шакин", 30, "Кладовщик");

        Employee[] employees = {
                employee1,
                employee2,
                employee3,
                employee4,
                employee5,
                employee6
        };

        Director director = new Director("Борис", "Грицаев", 40, "Директор и царь всея отдела", employees);

        RegionalManager regionalManager = new RegionalManager("СлаваБогу", "ТыПришел", 42, "Заведующий банхаммером ДНСа", director);

        regionalManager.doWork();
    }
}
