package ru.sberbank.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.sberbank.data.Task;

import static org.junit.jupiter.api.Assertions.*;

class TaskServiceTest {
    private TaskService taskService;

    @BeforeEach
    void setUp() {
        taskService = new TaskService();
    }

    @Test
    void getTaskTest_Sucsess() {
        TaskService taskService = new TaskService();
        String sum = "test";
        taskService.createTask(5, sum);
        Task actual = taskService.getTask(sum);
        Assertions.assertNotNull(actual);
        Assertions.assertEquals(5, actual.id);
        Assertions.assertEquals("test", actual.summary);
    }

    @Test
    void createTaskTest_sucsess() {
        taskService.createTask(1, "Test");
        assertEquals(1, taskService.arrayList.size());
    }

    @Test
    void getTaskTest_sucsess() {
        taskService.createTask(1, "Test");
        Task task = taskService.getTask("Test");
        assertNotNull(task);
        assertEquals("Test", task.summary);
    }

    @Test
    void getTasksForDevelopingTest_sucsess() {
        taskService.createTask(1, "Test1");
        taskService.createTask(2, "Test2");
        taskService.arrayList.get(1).isDeveloped = true;
        assertEquals(1, taskService.getTasksForDeveloping().size());
    }
}