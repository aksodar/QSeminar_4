package ru.sberbank;

import ru.sberbank.data.Developer;
import ru.sberbank.data.Task;
import ru.sberbank.data.Tester;
import ru.sberbank.service.DeveloperService;
import ru.sberbank.service.TaskService;
import ru.sberbank.service.TesterService;

public class Homework {

    public static void main(String[] args) {
        DeveloperService developerService = new DeveloperService();
        TaskService taskService = new TaskService();
        TesterService testerService = new TesterService();

        developerService.create(1, "Endy", "Pafca");
        try {
            developerService.get("Endy", "");
        } catch (IllegalStateException e) {
            System.err.println(e.getMessage());
        }
        Developer developer = developerService.get("Endy", "Pafca");

        taskService.createTask(1, "New SPA");
        Task task = taskService.getTaskById(1);
        try {
            taskService.getTask("New");
        } catch (IllegalStateException e) {
            System.err.println(e.getMessage());
        }
        developer.addTask(task);
        developer.makeTask();
        Task toTest = developer.getCurrentTask();

        System.out.println("Free testers:" +  testerService.getListOfFree());

        testerService.create(1, "Damir", "Iskakov");
        testerService.create(2, "John", "Dow");
        System.out.println("Free testers:" +  testerService.getListOfFree());
        Tester testerJohn = testerService.get("John", "Dow");
        testerJohn.addTask(toTest);
        System.out.println("Tester with task: " + testerJohn);
        try {
            System.out.println("Find tester Johnny :" + testerService.get("Johnny", "Dow"));
        } catch (IllegalStateException e) {
            System.err.println(e.getMessage());
        }
        System.out.println("Free testers:" +  testerService.getListOfFree());

    }

}
