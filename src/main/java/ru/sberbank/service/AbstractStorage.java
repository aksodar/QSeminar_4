package ru.sberbank.service;

import ru.sberbank.data.Developer;
import ru.sberbank.data.TeamMember;

import java.util.ArrayList;

public abstract class AbstractStorage<T extends TeamMember> {
    protected ArrayList<Developer> list;

    public ArrayList<Developer> getList() {
        return list;
    }

    public void setList(ArrayList<Developer> list) {
        this.list = list;
    }

    public AbstractStorage(){
        this.list = new ArrayList<>();
    }

}
