package ru.sberbank.data;

public class Tester extends TeamMember{

    public Tester(int id, String firstName, String secondName) {
        super(id, firstName, secondName);
    }

    //IDEA почему-то криво в этом месте генерирует переопределние toString, сделал костыльно руками
    @Override
    public String toString() {
        return "Tester{id = " + this.getId() + ", firstName = " + this.getFirstName() + ", secondName = " + this.getSecondName();
    }

    public Task checkTask() {
        if ((this.getCurrentTask() != null) && (this.getCurrentTask().isDeveloped == true) /*протестировать можно только задачу, которая была разработана*/) {
            this.getCurrentTask().isTested = true;
        }
        return getCurrentTask();


    }

}