package ru.sberbank.data;

public class Tester extends TeamMember{

    public Tester(int id, String firstName, String secondName){

        super(id, firstName, secondName);
    }

    public Task checkTask() {
        if (this.currentTask != null && this.currentTask.isDeveloped == true && this.currentTask.isTested == false) {
            this.currentTask.isTested = true;
        }
        return currentTask;
    }
}