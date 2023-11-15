package ru.sberbank.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.sberbank.data.Developer;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class DeveloperServiceTest {

    private DeveloperService developerService;

    @BeforeEach
    void setUp() {
        this.developerService = new DeveloperService();
    }

    @Test
    public void createDeveloperTest_sucsess() {
        developerService.createDeveloper(1, "Petia", "Petrov");
        assertEquals("1", developerService.list.size());
    }

    @Test
    public void getDeveloperTest_sucsess() {
        developerService.createDeveloper(1, "Petia", "Petrov");
        Developer developer = developerService.getDeveloper("Petia", "Petrov");
        assertNotNull(developer);
    }

    @Test
    public void getFreeDevelopersTest_sucsess() {
        developerService.createDeveloper(1, "Vova", "Ivanov");
        developerService.createDeveloper(2, "Petia", "Petrov");
        developerService.list.get(1).isFree = false;
        ArrayList<Developer> freeDevelopers = developerService.getFreeDevelopers();
        assertEquals(1, freeDevelopers.size());
    }
}