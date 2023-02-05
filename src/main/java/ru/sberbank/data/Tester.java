package ru.sberbank.data;

public class Tester extends TeamMember {


    public Tester(int id, String firstName, String secondName) {
        super(id, firstName, secondName);
    }

    public Task checkTask() {
        if (this.currentTask != null) {
            this.currentTask.setTested(true);
            this.isFree = false;
        }
        return currentTask;
    }

    @Override
    public boolean addTask(Task testTask) {
        if (this.isFree && this.currentTask == null && testTask.isDeveloped()) {
            this.currentTask = testTask;
            this.isFree = false;
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return "Tester{" +
               "id=" + id +
               ", firstName='" + firstName + '\'' +
               ", secondName='" + secondName + '\'' +
               ", isFree=" + isFree +
               ", currentTask=" + currentTask +
               '}';
    }
}
