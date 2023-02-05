package ru.sberbank.service;

import ru.sberbank.data.Developer;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class DeveloperService extends AbstractStorage<Developer> implements DataService<Developer> {

    @Override
    public Developer create(int id, String firstName, String secondName) {
        if ((firstName == null || firstName.isEmpty()) || (secondName == null || secondName.isEmpty())) {
            throw new IllegalStateException("Developer is not created");
        }
        Developer dev = new Developer(id, firstName, secondName);
        list.add(dev);
        return dev;
    }

    @Override
    public Developer get(String firstName, String secondName) {
        return list
                .stream()
                .filter(
                        dev -> firstName.equalsIgnoreCase(dev.getFirstName()) &&
                               secondName.equalsIgnoreCase(dev.getSecondName())
                )
                .findFirst()
                .orElseThrow(() -> new IllegalStateException("Developer is not found"));
    }

    @Override
    public List<Developer> getListOfFree() {
        return list.stream()
                   .filter(Developer::isFree)
                   .collect(Collectors.toList());
    }
}