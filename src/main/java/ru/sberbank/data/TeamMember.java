package ru.sberbank.data;

import java.util.Objects;

public abstract class TeamMember {
    protected int id;
    protected String firstName;
    protected String secondName;
    protected boolean isFree;
    protected Task currentTask;

    public TeamMember(final int id, final String firstName, final String secondName) {
        this.id = id;
        this.firstName = firstName;
        this.secondName = secondName;
        this.isFree = true;
    }

    public int getId() {
        return id;
    }

    public void setId(final int id) {
        this.id = id;
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

    public boolean isFree() {
        return isFree;
    }

    public void setFree(final boolean free) {
        isFree = free;
    }

    public Task getCurrentTask() {
        return currentTask;
    }

    public void setCurrentTask(final Task currentTask) {
        this.currentTask = currentTask;
    }

    public abstract boolean addTask(Task task);

    public void release() {
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
        return id == that.id && firstName.equals(that.firstName) && secondName.equals(that.secondName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, firstName, secondName);
    }
}
