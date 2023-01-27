package ru.sberbank.service;

import ru.sberbank.data.Tester;

import java.util.ArrayList;

public class TesterService extends AbstractStorage implements DataService<Tester> {
    @Override
    public boolean create(int id, String firstName, String secondName) {
        return false;
    }

    @Override
    public Tester get(String firstName, String secondName) {
        return null;
    }

    @Override
    public ArrayList<Tester> getListOfFree() {
        return null;
    }
}
