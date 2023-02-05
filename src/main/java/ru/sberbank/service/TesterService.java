package ru.sberbank.service;

import ru.sberbank.data.Tester;

import java.util.ArrayList;

public class TesterService extends AbstractStorage<Tester> implements DataService<Tester> {

    public TesterService() {
        super();
    }

    @Override
    public void create(int id, String firstName, String secondName) {
        if(firstName == null || firstName.isEmpty() || secondName == null || secondName.isEmpty()){
            throw new IllegalArgumentException("Недопустимые атрибуты Tester");
        }
        list.add(new Tester(id, firstName, secondName));
    }

    @Override
    public Tester get(String firstName, String secondName) {
        for(Tester t: list){
            if(firstName.equalsIgnoreCase(t.getFirstName()) && secondName.equalsIgnoreCase(t.getSecondName())){
                return t;
            }
        }
        throw new IllegalArgumentException("Не найдено ни одной записи Tester с именем " + firstName + " и фамилией " + secondName);
    }

    @Override
    public ArrayList<Tester> getListOfFree() {
        ArrayList<Tester> freeTester = new ArrayList<>();

        for(Tester t: list){
            if(t.isFree()){
                freeTester.add(t);
            }
        }
        if(list.isEmpty()){
            throw new IllegalArgumentException("Нет свободных тестировщиков");
        }
        return freeTester;
    }
}
