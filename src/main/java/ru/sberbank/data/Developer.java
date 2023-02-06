package ru.sberbank.data;

import java.util.Objects;

public class Developer extends TeamMember{

    public Developer(int id, String firstName, String secondName) {
        super(id, firstName, secondName);
    }

    public Task makeTask(){
        if(this.getCurrentTask() != null && !this.isFree()){
            this.getCurrentTask().isDeveloped = true;
            this.setFree(true);
        }
        return null;
    }

    //IDEA почему-то криво в этом месте генерирует переопределние toString, сделал костыльно руками
    @Override
    public String toString() {
        return "Developer{id = " + this.getId() + ", firstName = " + this.getFirstName() + ", secondName = " + this.getSecondName();
    }
}
