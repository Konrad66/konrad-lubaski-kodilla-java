package com.kodilla.spring.portfolio;

import com.kodilla.spring.reader.ReaderConfig;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.scheduling.config.Task;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class BoardTestSuite {

    @Test
    void testTaskAdd(){
        //Given
        ApplicationContext context = new AnnotationConfigApplicationContext(BoardConfig.class);
        Board board = (Board) context.getBean(Board.class);

        //When
        board.getToDoList().getTasks().add("Plan wydatkow");
        board.getInProgressList().getTasks().add("Nauka");
        board.getDoneList().getTasks().add("Zadanie zrobione");

        //Then
        assertEquals(1, board.getToDoList().getTasks().size());
        assertEquals("Plan wydatkow", board.getToDoList().getTasks().get(0));

        assertEquals(1, board.getToDoList().getTasks().size());
        assertEquals("Nauka", board.getInProgressList().getTasks().get(0));

        assertEquals(1, board.getToDoList().getTasks().size());
        assertEquals("Zadanie zrobione", board.getDoneList().getTasks().get(0));
    }
}