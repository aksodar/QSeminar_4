package ru.sberbank.data;

import java.util.Objects;

public class Developer extends TeamMember {

    public Developer(int id, String firstName, String secondName) {
        super(id, firstName, secondName);
    }

    Task makeTask(){
        if(this.getCurrentTask() != null && !this.isFree()){
            this.getCurrentTask().isDeveloped = true;
            this.setFree(true);
        }
        return null;
    }
}
