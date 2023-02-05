package ru.sberbank.service;

import ru.sberbank.data.Developer;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class DeveloperService extends AbstractStorage<Developer> {

    public boolean createDeveloper(int id, String firstName, String secondName) {
        if ((firstName == null || firstName.isEmpty()) || (secondName == null || secondName.isEmpty())) {
            throw new IllegalStateException("Developer is not created");
        }
        return list.add(new Developer(id, firstName, secondName));
    }

    public Developer getDeveloper(String firstName, String secondName) {
        return list
                .stream()
                .filter(
                        dev -> firstName.equalsIgnoreCase(dev.getFirstName()) &&
                               secondName.equalsIgnoreCase(dev.getSecondName())
                )
                .findFirst()
                .orElseThrow(() -> new IllegalStateException("Developer is not found"));
    }

    public List<Developer> getFreeDevelopers() {
        return list.stream()
                   .filter(Developer::isFree)
                   .collect(Collectors.toList());
    }

}