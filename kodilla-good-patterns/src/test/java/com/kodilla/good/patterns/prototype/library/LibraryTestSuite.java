package com.kodilla.good.patterns.prototype.library;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class LibraryTestSuite {

    @Test
    void testGetBooks() {
        // Given
        Library library = new Library("Main Library");
        library.getBooks().add(new Book("Hobbit", "Tolkien", LocalDate.of(1937, 9, 21)));
        library.getBooks().add(new Book("Dune", "Herbert", LocalDate.of(1965, 8, 1)));
        library.getBooks().add(new Book("2017", "Cuenca", LocalDate.of(1949, 6, 8)));

        // When - Shallow Copy
        Library shallowClonedLibrary = null;
        try {
            shallowClonedLibrary = library.shallowCopy();
            shallowClonedLibrary.setName("Shallow Copy Library");
        } catch (CloneNotSupportedException e) {
            fail("Shallow copy failed: " + e.getMessage());
        }

        // When - Deep Copy
        Library deepClonedLibrary = null;
        try {
            deepClonedLibrary = library.deepCopy();
            deepClonedLibrary.setName("Deep Copy Library");
        } catch (CloneNotSupportedException e) {
            fail("Deep copy failed: " + e.getMessage());
        }

        // Then
        library.getBooks().removeIf(book -> book.getTitle().equals("Dune"));

        System.out.println("Original: \n" + library);
        System.out.println("Shallow: \n" + shallowClonedLibrary);
        System.out.println("Deep: \n" + deepClonedLibrary);

        assertEquals(2, library.getBooks().size());
        assertEquals(2, shallowClonedLibrary.getBooks().size());
        assertEquals(3, deepClonedLibrary.getBooks().size());
        assertEquals(library.getBooks(), shallowClonedLibrary.getBooks());
        assertNotEquals(library.getBooks(), deepClonedLibrary.getBooks());
    }
}