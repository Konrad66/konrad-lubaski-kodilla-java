package com.kodilla.hibernate.tasklist.dao;

import com.kodilla.hibernate.tasklist.TaskList;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class TaskListDaoTestSuite {

    @Autowired
    private TaskListDao taskListDao;

    @Test
    void testFindByListName() {
        // Given
        String listName = "My Test List";
        String description = "This is a test task list.";
        TaskList taskList = new TaskList(listName, description);
        taskListDao.save(taskList);

        // When
        List<TaskList> result = taskListDao.findByListName(listName);

        // Then
        assertEquals(1, result.size());
        assertEquals(description, result.get(0).getDescription());

        // CleanUp
        taskListDao.deleteById(result.get(0).getId());
    }
}