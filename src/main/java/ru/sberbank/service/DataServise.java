package ru.sberbank.service;

import ru.sberbank.data.TeamMember;

import java.util.ArrayList;

// для интерфейсов - не наследование, а реализация
public interface DataServise<T extends TeamMember> {
    void create(int id, String firstName, String secondName);
    T get(String firstName, String secondName);
    T get(int id);
    //типизация коллекций - даймонт оператор Т
    ArrayList<T> getListOfFree();
}
