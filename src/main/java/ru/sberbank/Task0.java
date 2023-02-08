package ru.sberbank;

import ru.sberbank.data.Developer;
import ru.sberbank.data.Tester;
import ru.sberbank.service.DeveloperService;
import ru.sberbank.service.TesterService;

public class Task0 {
    public static void main(String[] args) {

        //Демонстрация работы, что после добавления механизма наследования логика работает

        Tester tester1 = new Tester(1, "Ivan", "Ivanov");
        System.out.println(tester1.getId());
        System.out.println(tester1.getFirstName());
        System.out.println(tester1.getSecondName());
        TesterService tester = new TesterService();
        tester.create(2, "Petr", "Petrov");
        System.out.println(tester.get("Petr", "Petrov"));
        System.out.println(tester.getListOfFree());
        System.out.println(tester.get(2));

        Developer dev = new Developer(1, "Vasya", "Vasiliev");
        System.out.println(dev.getId());
        System.out.println(dev.getFirstName());
        System.out.println(dev.getSecondName());
        DeveloperService dev1 = new DeveloperService();
        dev1.create(2, "Petr", "Petrov");
        System.out.println(dev1.get("Petr", "Petrov"));
        System.out.println(dev1.getListOfFree());
        System.out.println(dev1.get(2));
    }
}