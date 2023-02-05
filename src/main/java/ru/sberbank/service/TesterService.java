package ru.sberbank.service;

import ru.sberbank.data.Developer;
import ru.sberbank.data.Tester;
import java.util.ArrayList;

public class TesterService extends AbstractStorage<Tester> implements DataService<Tester> {
    public ArrayList<Tester> list;

    public TesterService() {
        super();
    }

    @Override
    public boolean create(int id, String firstName, String secondName) {
        if (firstName == null || secondName == null || firstName == "" || secondName == ""){
            throw new IllegalStateException("Tester is not created");
        }
        Tester QA = new Tester(id, firstName, secondName);
        return list.add(QA);
    }

    @Override
    public Tester get(String firstName, String secondName) {
        for (Tester n : list) {
            if (firstName.equalsIgnoreCase(n.getFirstName()) && secondName.equalsIgnoreCase(n.getSecondName()))
                return n;
        }
        throw new IllegalStateException("Tester is not found");
    }


    @Override
    public ArrayList<Tester> getListOfFree() {
        ArrayList<Tester> temp = new ArrayList<>();
        for (Tester n : list) {
            if (n.isFree()) {
                temp.add(n);
            }
        }
        if (temp.isEmpty()){
            throw new IllegalStateException("Testers list is empty");
        }
        return temp;
    }

    @Override
    public Tester get(int id) {
        for (Tester a:list) {
            if(a != null){
                return a;
            }
        }
        throw new IllegalStateException("Tester is not found");
    }
        // дописать этот метод с учетом перегрузки get
    // не уверена, что здесь должен быть список, но по идее хочу перебрать весь список Тестеров, у которых id is not null (возможно ли такое?)
    }

