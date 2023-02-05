package ru.sberbank.service;

import ru.sberbank.data.Tester;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class TesterService extends AbstractStorage<Tester> implements DataService<Tester> {

    @Override
    public Tester create(int id, String firstName, String secondName) {
        if (firstName == null || firstName.isEmpty() || secondName == null || secondName.isEmpty()) {
            throw new IllegalStateException("Tester is not created");
        }
        Tester tester = new Tester(id, firstName, secondName);
        list.add(tester);
        return tester;
    }

    @Override
    public Tester get(String firstName, String secondName) throws IllegalStateException {
        return list.stream()
                   .filter(
                           tester -> tester.getFirstName().equals(firstName) &&
                                     tester.getSecondName().equals(secondName)
                   )
                   .findFirst()
                   .orElseThrow(
                           () -> new IllegalStateException("Tester " + firstName + " " + secondName + " is not found")
                   );
    }

    @Override
    public List<Tester> getListOfFree() {
        return list
                .stream()
                .filter(Tester::isFree)
                .collect(Collectors.toList());
    }
}
