package com.kodilla.testing.forum.statistics;

import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class UsersStatisticsTestSuite {

    @Mock
    private Statistics statisticsMock;

    @Nested
    @DisplayName("Test number of posts with Mock")
    class PostsNumberTests {

        private UsersStatistics usersStatistics;

        private List<String> generateUserNames(int numberOfUsers) {
            List<String> userNames = new ArrayList<>();
            for (int i = 0; i < numberOfUsers; i++) {
                userNames.add("user" + i);
            }
            return userNames;
        }

        private static Stream<Arguments> provideDataForTests() {
            return Stream.of(
                    Arguments.of(1, 1, 1, 1.0, 1.0, 1.0),
                    Arguments.of(10, 50, 25, 5.0, 2.5, 0.5),
                    Arguments.of(5, 0, 10, 0.0, 2.0, 0.0),
                    Arguments.of(0, 0, 0, 0.0, 0.0, 0.0),
                    Arguments.of(0, 100, 50, 0.0, 0.0, 0.5)
            );
        }

        @BeforeEach
        void setUp() {
            usersStatistics = new UsersStatistics();
        }

        @ParameterizedTest
        @MethodSource("provideDataForTests")
        void testForAllCases(int userNumber, int postsNumber, int commentsNumber, double avgPostsNumberPerUser, double avgCommentsNumberPerUser, double avgCommentsNumberPerPost) {
            //Given
            List<String> usersNamesList = generateUserNames(userNumber);
            when(statisticsMock.usersNames()).thenReturn(usersNamesList);
            when(statisticsMock.postsCount()).thenReturn(postsNumber);
            when(statisticsMock.commentsCount()).thenReturn(commentsNumber);

            //When
            usersStatistics.calculateAdvStatistics(statisticsMock);

            //Then
            assertEquals(commentsNumber, usersStatistics.getCommentsNumber());
            assertEquals(postsNumber, usersStatistics.getPostsNumber());
            assertEquals(userNumber, usersStatistics.getUsersNumber());
            assertEquals(avgPostsNumberPerUser, usersStatistics.getAvgPostsNumberPerUser());
            assertEquals(avgCommentsNumberPerUser, usersStatistics.getAvgCommentsNumberPerUser());
            assertEquals(avgCommentsNumberPerPost, usersStatistics.getAvgCommentsNumberPerPost());
        }


        @ParameterizedTest
        @ValueSource(ints = {0, 1000})
        void testNumberOfPostsWithMock(int numberOfPosts) {
            //Given
            when(statisticsMock.postsCount()).thenReturn(numberOfPosts);

            //When
            usersStatistics.calculateAdvStatistics(statisticsMock);

            //Then
            verify(statisticsMock).postsCount();
            assertEquals(numberOfPosts, usersStatistics.getPostsNumber());
        }
    }

    @Nested
    @DisplayName("Test number of comments and posts with Mock")
    class CommentsNumberTests {

        private UsersStatistics usersStatistics;

        @BeforeEach
        void setUp() {
            usersStatistics = new UsersStatistics();
        }

        @Test
        void testAvgCommentsNumberPerPostWhereNumberOfCommentsHigherThanPostsWithMock() {
            //Given
            when(statisticsMock.commentsCount()).thenReturn(10);
            when(statisticsMock.postsCount()).thenReturn(1);

            //When
            usersStatistics.calculateAdvStatistics(statisticsMock);

            //Then
            verify(statisticsMock).commentsCount();
            verify(statisticsMock).postsCount();
            assertEquals(10, usersStatistics.getAvgCommentsNumberPerPost());
        }

        @Test
        void testAvgCommentsNumberPerPostWhereNumberOfCommentsLowerThanPostsWithMock() {
            //Given
            when(statisticsMock.commentsCount()).thenReturn(5);
            when(statisticsMock.postsCount()).thenReturn(10);

            //When
            usersStatistics.calculateAdvStatistics(statisticsMock);

            //Then
            verify(statisticsMock).commentsCount();
            verify(statisticsMock).postsCount();
            assertEquals(0.5, usersStatistics.getAvgCommentsNumberPerPost());
        }

        @Test
        void testAvgCommentsNumberPerPostWhereNumberOfCommentsIs0WithMock() {
            //Given
            when(statisticsMock.commentsCount()).thenReturn(0);

            //When
            usersStatistics.calculateAdvStatistics(statisticsMock);

            //Then
            verify(statisticsMock).commentsCount();
            assertEquals(0, usersStatistics.getCommentsNumber());
        }

        @Test
        void testAvgCommentsNumberPerPostWhereNumberOfPostsIs0WithMock() {
            //Given
            when(statisticsMock.postsCount()).thenReturn(0);

            //When
            usersStatistics.calculateAdvStatistics(statisticsMock);

            //Then
            verify(statisticsMock).commentsCount();
            assertEquals(0, usersStatistics.getCommentsNumber());
        }
    }

    @Nested
    @DisplayName("Test number of users with Mock")
    class UsersNumberTests {
        private UsersStatistics usersStatistics;

        private List<String> generateUserNames(int numberOfUsers) {
            List<String> userNames = new ArrayList<>();
            for (int i = 0; i < numberOfUsers; i++) {
                userNames.add("user" + i);
            }
            return userNames;
        }

        @BeforeEach
        void setUp() {
            usersStatistics = new UsersStatistics();
        }

        @ParameterizedTest
        @ValueSource(ints = {0, 100})
        void testNumberOfUsersWithMock(int numberOfUsers) {
            //Given
            List<String> usersList = generateUserNames(numberOfUsers);
            when(statisticsMock.usersNames()).thenReturn(usersList);

            //When
            usersStatistics.calculateAdvStatistics(statisticsMock);

            //Then
            verify(statisticsMock).usersNames();
            assertEquals(numberOfUsers, usersStatistics.getUsersNumber());
        }
    }
}