package com.kodilla.testing.forum;

import com.kodilla.testing.user.SimpleUser;
import org.junit.jupiter.api.*;

@DisplayName("Forum Test Suite")
public class ForumTestSuite {

    @BeforeEach
    public void beforeEach() {
        System.out.println("Test case: begun");
    }

    @AfterEach
    public void afterEach() {
        System.out.println("Test case: end");
    }

    @BeforeAll
    public static void beforeAll() {
        System.out.println("Test case: before all");
    }

    @AfterAll
    public static void afterAll() {
        System.out.println("Test case: after all");
    }

    @Test
    void testCaseRealName(){
        //Given
        SimpleUser simpleUser = new SimpleUser("theForumUser", "John Smith");
        //When
        String result = simpleUser.getRealName();
        System.out.println("Test case: " + result);
        //Then
        Assertions.assertEquals("John Smith", result);
    }


    @DisplayName(
            "When created SimpleUser with name, " +
                    "then getUsername should return correct name"
    )
    @Test
    void testCaseUsername() {
        //Given
        SimpleUser simpleUser = new SimpleUser("theForumUser");

        //When
        String result = simpleUser.getUsername();
        String expected = "theForumUser";

        //Then
        Assertions.assertEquals(expected, result);
    }
}
