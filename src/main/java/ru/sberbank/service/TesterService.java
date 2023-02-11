package ru.sberbank.service;

import ru.sberbank.data.TeamMember;
import ru.sberbank.data.Tester;

import java.util.ArrayList;

public class TesterService extends AbstractStorage<Tester> implements DataService<Tester> {

    public TesterService() {
        super();
    }

    @Override
    public void create(int id, String firstName, String secondName) {

        if (firstName == null || firstName.isEmpty()) {
            throw new IllegalArgumentException("incorrect firstname");
        } else if (secondName == null || secondName.isEmpty()) {
            throw new IllegalArgumentException("incorrect secondName");
        }

        this.list.add(new Tester(id, firstName, secondName));
    }

    @Override
    public Tester get(String firstName, String secondName) {

        for (Tester tester : this.list) {
            if (tester.getFirstName().equalsIgnoreCase(firstName)
                    && tester.getSecondName().equalsIgnoreCase(secondName)) {
                return tester;
            }
        }
        throw new IllegalArgumentException("Tester not found");

    }

    @Override
    public Tester get(int id) {

        for (Tester tester : this.list) {
            if (id == tester.getId()) {
                return tester;
            }
        }
        throw new IllegalArgumentException("Tester not found");
    }

    @Override
    public ArrayList<Tester> getListOfFree() {
        ArrayList<Tester> freeTesters = new ArrayList<>();
        for (Tester tester : this.list) {
            if (tester.isFree()) {
                freeTesters.add(tester);
            }
        }
        return freeTesters;
    }


}
