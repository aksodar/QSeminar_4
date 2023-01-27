package ru.sberbank.service;

import ru.sberbank.data.TeamMember;

import java.util.ArrayList;

public abstract class AbstractStorage<T extends TeamMember> {
    protected ArrayList<T> list;

    protected AbstractStorage(){
        this.list = new ArrayList<>();
    }

}
