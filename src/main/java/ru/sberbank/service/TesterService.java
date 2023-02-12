package ru.sberbank.service;

import ru.sberbank.data.Developer;
import ru.sberbank.data.Tester;

import java.util.ArrayList;

public class TesterService extends AbstractStorage<Tester> implements DataServise<Tester>{
    ArrayList<Tester> list;

    public TesterService() {

        super();
    }

    @Override
    public void create(int id, String firstName, String secondName) {
        if((firstName == null || firstName.isEmpty()) || (secondName == null || secondName.isEmpty())) {
            throw new IllegalStateException("Тестер не создан");
        }
        list.add(new Tester(id, firstName, secondName));
    }

    @Override
    public Tester get(String firstName, String secondName) {
        for (Tester t: list)  {
            if(firstName.equalsIgnoreCase(t.getFirstName()) && secondName.equalsIgnoreCase(t.getSecondName())) {
                return t;
            }
        }
        throw new IllegalStateException("Тестер не найден");
    }


    @Override
    public ArrayList<Tester> getListOfFree() {
        ArrayList<Tester> freeTester = new ArrayList<>();
        for (Tester n: list) {
            if(n.isFree()) {
                freeTester.add(n);
            }
        }
        if(freeTester.isEmpty()) {
            throw new IllegalStateException("Нет свободный тестеров");
        }
        return freeTester;
    }

    @Override
    public Tester get(int id) {
        for (Tester m: list) {
            if(m.getId() == id) {
                return  m;
            }
        }
        return null;
    }
}