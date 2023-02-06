package ru.sberbank.service;

import ru.sberbank.data.Developer;

import java.util.ArrayList;

public class DeveloperService extends AbstractStorage<Developer>{

    public DeveloperService() {
        super();
    }

    public void createDeveloper(int id, String firstName, String secondName) throws IllegalStateException {
        if((firstName == null || firstName.isEmpty()) || (secondName == null || secondName.isEmpty())) {
            throw new IllegalStateException("Входные данные не валидны");
        }
        list.add(new Developer(id, firstName, secondName));
    }

    public Developer getDeveloper(String firstName, String secondName) throws IllegalStateException {
        for (Developer t: list)  {
            if(firstName.equalsIgnoreCase(t.getFirstName()) && secondName.equalsIgnoreCase(t.getSecondName())) {
                return t;
            }
        }
        throw new IllegalStateException("Разработчики не найдены");
    }

    public ArrayList<Developer> getFreeDevelopers() {
        ArrayList<Developer> freeTester = new ArrayList<>();
        for (Developer n: list) {
            if(n.isFree()) {
                freeTester.add(n);
            }
        }
        return freeTester;
    }

}