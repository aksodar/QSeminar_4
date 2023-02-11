package ru.sberbank.service;

import ru.sberbank.data.Developer;

import java.util.ArrayList;

public class DeveloperService extends AbstractStorage<Developer> implements DataService<Developer> {

    public DeveloperService() {
        super();
    }

    @Override
    public void create(int id, String firstName, String secondName) {
        if ((firstName == null || firstName.isEmpty()) || (secondName == null || secondName.isEmpty())) {
            throw new IllegalStateException("Входные данные не валидны");
        }
        list.add(new Developer(id, firstName, secondName));
    }

    @Override
    public Developer get(String firstName, String secondName) {
        for (Developer t : list) {
            if (firstName.equalsIgnoreCase(t.getFirstName()) && secondName.equalsIgnoreCase(t.getSecondName())) {
                return t;
            }
        }
        throw new IllegalStateException("Разработчики не найдены");
    }

    @Override
    public Developer get(int id) {
        for (Developer t : list) {
            if (id == t.getId()) {
                return t;
            }
        }
        throw new IllegalStateException("Разработчики не найдены");
    }

    @Override
    public ArrayList<Developer> getListOfFree() {
        ArrayList<Developer> freeTester = new ArrayList<>();
        for (Developer n : list) {
            if (n.isFree()) {
                freeTester.add(n);
            }
        }
        return freeTester;
    }
}