package ru.sberbank.data;

import java.util.Objects;

public abstract class TeamMember {
    Task currentTask;
    public int id;
    public boolean isFree;
    public String firstName;
    public String secondName;

    public TeamMember(int id, String firstName, String secondName) {
        this.id = id;
        this.secondName = secondName;
        this.firstName = firstName;
        this.isFree = true;
    }

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
            this.currentTask.isDeveloped = true;
            this.isFree = true;
        }
        return null;
    }

    void release(){
        this.currentTask = null;
        this.isFree = true;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Developer developer = (Developer) o;
        return id == developer.id && isFree == developer.isFree && Objects.equals(currentTask, developer.currentTask);
    }

    @Override
    public int hashCode() {
        return Objects.hash(currentTask, id, isFree);
    }

    protected Task getCurrentTask() {
        return currentTask;
    }

    protected void setCurrentTask(Task task) {
        this.currentTask = task;
    }

    protected void setFree(boolean b) {
        this.isFree = true;
    }
}
