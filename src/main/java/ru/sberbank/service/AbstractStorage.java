package ru.sberbank.service;

import ru.sberbank.data.TeamMember;

import java.util.ArrayList;

public abstract class AbstractStorage<T extends TeamMember> {
    protected ArrayList<T> list;

    public ArrayList<T> getList() {
        return list;
    }

    public void setList(ArrayList<T> list) {
        this.list = new ArrayList<>();
    }
    public AbstractStorage(){
        this.list = new ArrayList<>();
    }

}
