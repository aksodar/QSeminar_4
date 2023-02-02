package ru.sberbank.service;

import ru.sberbank.data.TeamMember;

import java.util.ArrayList;

public abstract class AbstractStorage <T extends TeamMember>{
    protected ArrayList<T> list;

    public ArrayList<T> getList() {
        return list;
    }

    public void setList(final ArrayList<T> list) {
        this.list = list;
    }

    public AbstractStorage() {
        this.list = new ArrayList<>();
    }

}
