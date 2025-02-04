package com.kodilla.testing.library;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class BookDirectoryTestSuite {

    @Mock
    private LibraryDatabase libraryDatabaseMock;

    private List<Book> generateListOfNBooks(int booksQuantity) {
        List<Book> resultList = new ArrayList<>();
        for (int n = 1; n <= booksQuantity; n++) {
            Book theBook = new Book("Title " + n, "Author " + n, 1970 + n);
            resultList.add(theBook);
        }
        return resultList;
    }

    @Nested
    @DisplayName("Test return list of books with conditions")
    class TestSearchBook {

        @Test
        void testListBooksWithConditionsReturnList() {
            // Given
            BookLibrary bookLibrary = new BookLibrary(libraryDatabaseMock);
            List<Book> resultListOfBooks = new ArrayList<>();
            Book book1 = new Book("Secrets of Alamo", "John Smith", 2008);
            Book book2 = new Book("Secretaries and Directors", "Dilbert Michigan", 2012);
            Book book3 = new Book("Secret life of programmers", "Steve Wolkowitz", 2016);
            Book book4 = new Book("Secrets of Java", "Ian Tenewitch", 2010);
            resultListOfBooks.add(book1);
            resultListOfBooks.add(book2);
            resultListOfBooks.add(book3);
            resultListOfBooks.add(book4);
            when(libraryDatabaseMock.listBooksWithCondition("Secret")).thenReturn(resultListOfBooks);

            // When
            List<Book> theListOfBooks = bookLibrary.listBooksWithCondition("Secret");

            // Then
            assertEquals(4, theListOfBooks.size());
        }

        @Test
        void testListBooksWithConditionMoreThan20() {
            // Given
            BookLibrary bookLibrary = new BookLibrary(libraryDatabaseMock);
            List<Book> resultListOf0Books = new ArrayList<>();
            List<Book> resultListOf15Books = generateListOfNBooks(15);
            List<Book> resultListOf40Books = generateListOfNBooks(40);
            when(libraryDatabaseMock.listBooksWithCondition(anyString()))
                    .thenReturn(resultListOf15Books);
            when(libraryDatabaseMock.listBooksWithCondition("ZeroBooks"))
                    .thenReturn(resultListOf0Books);
            when(libraryDatabaseMock.listBooksWithCondition("FortyBooks"))
                    .thenReturn(resultListOf40Books);

            // When
            List<Book> theListOfBooks0 = bookLibrary.listBooksWithCondition("ZeroBooks");
            List<Book> theListOfBooks15 = bookLibrary.listBooksWithCondition("Any title");
            List<Book> theListOfBooks40 = bookLibrary.listBooksWithCondition("FortyBooks");
            // Then

            assertEquals(0, theListOfBooks0.size());
            assertEquals(15, theListOfBooks15.size());
            assertEquals(0, theListOfBooks40.size());
        }

        @Test
        void testListBooksWithConditionFragmentShorterThan3() {
            // Given
            LibraryDatabase libraryDatabaseMock = mock(LibraryDatabase.class);
            BookLibrary bookLibrary = new BookLibrary(libraryDatabaseMock);

            // When
            List<Book> theListOfBooks10 = bookLibrary.listBooksWithCondition("An");

            // Then
            assertEquals(0, theListOfBooks10.size());
            verify(libraryDatabaseMock, times(0)).listBooksWithCondition(anyString());
        }
    }

    @Nested
    @DisplayName("Test list of books in hands")
    class TestBooksInHands {

        private BookLibrary bookLibrary;
        private List<Book> resultListOfBooks;
        private LibraryUser libraryUser;
        private Book book1;
        private Book book2;
        private Book book3;
        private Book book4;
        private Book book5;

        @BeforeEach
        void setUp() {
            bookLibrary = new BookLibrary(libraryDatabaseMock);
            resultListOfBooks = new ArrayList<>();
            libraryUser = new LibraryUser("Konrad", "Nowak", "98");
            book1 = new Book("Secrets of Alamo", "John Smith", 2008);
            book2 = new Book("Secretaries and Directors", "Dilbert Michigan", 2012);
            book3 = new Book("Secret life of programmers", "Steve Wolkowitz", 2016);
            book4 = new Book("Secrets of Java", "Ian Tenewitch", 2010);
            book5 = new Book("Secrets of Python", "Ian Powazny", 2018);
        }

        @Test
        void testListBooksInHandsWith0Books() {
            //Given
            when(libraryDatabaseMock.listBooksInHandsOf(libraryUser)).thenReturn(resultListOfBooks);

            //When
            List<Book> theListOfBooksInHands = bookLibrary.listBooksInHandsOf(libraryUser);

            //Then
            assertEquals(0, theListOfBooksInHands.size());
        }

        @Test
        void testListBooksInHandsWith1Book() {
            //Given
            resultListOfBooks.add(book1);
            libraryDatabaseMock.rentABook(libraryUser, book1);
            when(libraryDatabaseMock.listBooksInHandsOf(libraryUser)).thenReturn(resultListOfBooks);

            //When
            List<Book> theListOfBooksInHands = bookLibrary.listBooksInHandsOf(libraryUser);

            //Then
            assertEquals(1, theListOfBooksInHands.size());
        }

        @Test
        void testListBooksInHandsWith5Book() {
            //Given
            resultListOfBooks.add(book1);
            resultListOfBooks.add(book2);
            resultListOfBooks.add(book3);
            resultListOfBooks.add(book4);
            resultListOfBooks.add(book5);
            libraryDatabaseMock.rentABook(libraryUser, book1);
            libraryDatabaseMock.rentABook(libraryUser, book2);
            libraryDatabaseMock.rentABook(libraryUser, book3);
            libraryDatabaseMock.rentABook(libraryUser, book4);
            libraryDatabaseMock.rentABook(libraryUser, book5);
            when(libraryDatabaseMock.listBooksInHandsOf(libraryUser)).thenReturn(resultListOfBooks);

            //When
            List<Book> theListOfBooksInHands = bookLibrary.listBooksInHandsOf(libraryUser);

            //Then
            assertEquals(5, theListOfBooksInHands.size());
        }
    }
}