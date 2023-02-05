package ru.sberbank.data;

import java.util.Objects;

public class Developer extends TeamMember{

    public Developer(int id, String firstName, String secondName) {
        super(id, firstName, secondName);
    }

    @Override
    public boolean addTask(Task task){
        if(this.isFree && this.currentTask == null){
            this.currentTask = task;
            this.isFree = false;
            return true;
        }
        return false;
    }

    public Task makeTask(){
        if(this.currentTask != null && !this.isFree){
            this.currentTask.setDeveloped(true);
            this.isFree = true;
        }
        return null;
    }
}
