package ru.sberbank.service;

import ru.sberbank.data.Tester;

import java.util.ArrayList;

public class TesterService extends AbstractStorage<Tester>{

    public TesterService() {
        super();
    }

    public void createTester(int id, String firstName, String secondName) {
        if((firstName == null || firstName.isEmpty()) || (secondName == null || secondName.isEmpty())) {
            throw new IllegalStateException("Входные данные не валидны");
        }
        list.add(new Tester(id, firstName, secondName));
    }

    public Tester getTester(String firstName, String secondName) {
        for (Tester t: list)  {
            if(firstName.equalsIgnoreCase(t.getFirstName()) && secondName.equalsIgnoreCase(t.getSecondName())) {
                return t;
            }
        }
        throw new IllegalStateException("Тестировщик не найден");
    }

    public ArrayList<Tester> getFreeTesters() {
        ArrayList<Tester> freeTester = new ArrayList<>();
        for (Tester n: list) {
            if(n.isFree() == true) {
                freeTester.add(n);
            }
        }
        if(freeTester.isEmpty()) {
            throw new IllegalStateException("Нет свободного тестировщика");
        }
        return freeTester;
    }

}
