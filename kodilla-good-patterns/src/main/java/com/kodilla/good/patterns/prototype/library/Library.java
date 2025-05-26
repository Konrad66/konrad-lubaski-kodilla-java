package com.kodilla.good.patterns.prototype.library;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class Library extends Prototype<Library> {

    private String name;
    private Set<Book> books = new HashSet<>();

    public Library(final String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public Set<Book> getBooks() {
        return books;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Library shallowCopy() throws CloneNotSupportedException {
        return super.clone();
    }

    public Library deepCopy() throws CloneNotSupportedException {
        Library clonedLibrary = super.clone();
        clonedLibrary.books = new HashSet<>();
        for (Book book : books) {
            clonedLibrary.books.add(new Book(book.getTitle(), book.getAuthor(), book.getPublicationDate()));
        }
        return clonedLibrary;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("Library [" + name + "]\n");
        books.forEach(book -> sb.append(book.toString()).append("\n"));
        return sb.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Library)) return false;
        Library library = (Library) o;
        return Objects.equals(name, library.name) &&
                Objects.equals(books, library.books);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, books);
    }
}