package ru.sberbank.data;

        import java.util.Objects;

public class Tester extends TeamMember {
    private boolean isFree;
    private Task currentTask;


    public Tester(int id, String firstName, String secondName) {
        super(id, firstName, secondName);
        {
            this.isFree = true;
            this.currentTask = currentTask;
        }
    }


    public boolean checkTask() {
        if (this.currentTask != null) {
            this.currentTask.isTested = true;
            return true;
        }
        return false;
    }

}