package ru.sberbank.service;

import ru.sberbank.data.Developer;
import ru.sberbank.data.Tester;
import java.util.ArrayList;

public class TesterService extends AbstractStorage<Tester> implements DataService<Tester> {
    public TesterService() {
        super();
    }

    @Override
    public boolean create(int id, String firstName, String secondName) {
        if((firstName == null || firstName.isEmpty()) || (secondName == null || secondName.isEmpty())) {
            throw new IllegalStateException("Входные данные не валидны");
        }
        list.add(new Tester(id, firstName, secondName));
        return false;
    }

    @Override
    public Tester get(String firstName, String secondName) {
        for (Tester t: list)  {
            if(firstName.equalsIgnoreCase(t.firstName) && secondName.equalsIgnoreCase(t.secondName)) {
                return t;
            }
        }
        throw new IllegalStateException("Разработчики не найдены");
    }

    @Override
    public ArrayList<Tester> getListOfFree() {
        ArrayList<Tester> freeTester = new ArrayList<>();
        for (Tester n: list) {
            if(n.isFree) {
                freeTester.add(n);
            }
        }
        return freeTester;
    }

    public Tester getById(int my_id) {
        for (Tester t: list)  {
            if(t.id == my_id) {
                return t;
            }
        }
        throw new IllegalStateException("Разработчик не найден!");
    }
}
