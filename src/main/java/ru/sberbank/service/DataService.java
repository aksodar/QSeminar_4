package ru.sberbank.service;

import ru.sberbank.data.TeamMember;

import java.util.ArrayList;

public interface DataService<T extends TeamMember> {
    boolean create(int id, String firstName, String secondName);
    T get(String firstName, String secondName);
    T get(int id);
    ArrayList<T> getListOfFree();
}
