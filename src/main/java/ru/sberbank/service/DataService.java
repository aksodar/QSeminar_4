package ru.sberbank.service;

import ru.sberbank.data.TeamMember;

import java.util.List;

public interface DataService<T extends TeamMember> {

    T create(int id, String firstName, String secondName);

    T get(String firstName, String secondName);

    List<T> getListOfFree();
}
