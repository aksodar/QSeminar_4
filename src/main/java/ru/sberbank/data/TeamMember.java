package ru.sberbank.data;

public abstract class TeamMember {
    private Task currentTask;
    private int id;
    private boolean isFree;
    private String firstName;
    private String secondName;

    public TeamMember(int id, String firstName, String secondName) {
        this.id = id;
        this.isFree = true;
        this.secondName = secondName;
        this.firstName = firstName;
    }

    public Task getCurrentTask() {
        return currentTask;
    }

    public void setCurrentTask(final Task currentTask) {
        this.currentTask = currentTask;
    }

    public int getId() {
        return id;
    }

    public void setId(final int id) {
        this.id = id;
    }

    public boolean isFree() {
        return isFree;
    }

    public void setFree(final boolean free) {
        isFree = free;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(final String firstName) {
        this.firstName = firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(final String secondName) {
        this.secondName = secondName;
    }

    public boolean addTask(Task task){
        if(this.isFree && this.currentTask == null){
            this.currentTask = task;
            this.isFree = false;
            return true;
        }
        return false;
    }

    public void release(){
        this.currentTask = null;
        this.isFree = true;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        final TeamMember that = (TeamMember) o;

        if (id != that.id) {
            return false;
        }
        if (!firstName.equals(that.firstName)) {
            return false;
        }
        return secondName.equals(that.secondName);
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + firstName.hashCode();
        result = 31 * result + secondName.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "TeamMember{" +
               "currentTask=" + currentTask +
               ", id=" + id +
               ", isFree=" + isFree +
               ", firstName='" + firstName + '\'' +
               ", secondName='" + secondName + '\'' +
               '}';
    }
}
