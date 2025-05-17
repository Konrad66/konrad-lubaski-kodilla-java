package com.kodilla.spring.forum;

import com.kodilla.spring.forum.ForumUser;
import com.kodilla.spring.shape.Shape;
import com.kodilla.spring.shape.Triangle;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ForumUserTestSuite {

    //@Autowired
    //private ForumUser forumUser;

//    @Test
//    void testGetUsername() {
//        //Given
//        ApplicationContext context = new AnnotationConfigApplicationContext("com.kodilla.spring");
//        ForumUser forumUser = context.getBean(ForumUser.class);
//        //When
//        String result = forumUser.getUsername();
//
//        //Then
//        assertEquals("John Smith", result);
//    }
}