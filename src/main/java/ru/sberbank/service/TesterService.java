package ru.sberbank.service;

import ru.sberbank.data.Tester;

import java.util.ArrayList;

public class TesterService extends AbstractStorage<Tester>{

    public TesterService() {
        super();
    }

    public void createTester(int id, String firstName, String secondName) {
        if ((firstName == null || firstName.isEmpty()) || (secondName == null || secondName.isEmpty())) {
            throw new IllegalStateException("Wrong parameters, tester not created");
        }
        list.add(new Tester(id, firstName, secondName));
    }

    public Tester getTester(String firstName, String secondName) {
        for (Tester s: list) {
            if ((firstName.equalsIgnoreCase(s.getFirstName())) && (secondName.equalsIgnoreCase(s.getSecondName()))) {
                return s;
            }
        }
        throw new IllegalStateException("Tester not found");
    }

    public ArrayList<Tester> getFreeTesters() {
        ArrayList<Tester> freeTesters = new ArrayList<>();
        for (Tester s: list) {
            if (s.isFree() == true) {
                freeTesters.add(s);
            }
        }
        if (freeTesters.isEmpty()) {
            throw new IllegalStateException("No free Testers");
        }
        return freeTesters;
    }

}