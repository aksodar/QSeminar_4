package ru.sberbank.data;

public abstract class TeamMember {
    private Task currentTask;
    private int id;
    private boolean isFree;
    private String firstName;
    private String secondName;

    public TeamMember(int id, String firstName, String secondName) {
        this.id = id;
        this.firstName = firstName;
        this.secondName = secondName;
    }

    public Task getCurrentTask() {
        return currentTask;
    }

    public void setCurrentTask(Task currentTask) {
        this.currentTask = currentTask;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public boolean isFree() {
        return isFree;
    }

    public void setFree(boolean free) {
        isFree = free;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    boolean addTask(Task task){
        if(this.isFree && this.currentTask == null){
            this.currentTask = task;
            this.isFree = false;
            return true;
        }
        return false;
    }

    void release(){
        this.currentTask = null;
        this.isFree = true;
    }
}
