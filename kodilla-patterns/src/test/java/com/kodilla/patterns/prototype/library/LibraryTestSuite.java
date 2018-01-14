package com.kodilla.patterns.prototype.library;

import org.junit.Assert;
import org.junit.Test;

import java.time.LocalDate;
import java.util.stream.LongStream;

public class LibraryTestSuite {

    @Test
    public void testGetBooks() {

        //Given
        //creating Library
        Library library = new Library("Great Library");
        LongStream.iterate(1, n -> n + 1)
                .limit(3)
                .forEach(n -> library.getBooks().add(new Book("T"+n, "A"+n, LocalDate.now().minusWeeks(n))));

        Library clonedLibrary = null;
        try {
            clonedLibrary = library.clone();
            clonedLibrary.setName("New small library");
        } catch (CloneNotSupportedException e) {
            System.out.println(e);
        }

        //making a deep copy of object board
        Library deepClonedLibrary = null;
        try {
            deepClonedLibrary = library.deepCopy();
            deepClonedLibrary.setName("Another library");
        } catch (CloneNotSupportedException e) {
            System.out.println(e);
        }

        //When
        Book testBook = new Book("Forbidden in small library", "Z", LocalDate.now().minusWeeks(100));
        library.getBooks().add(testBook);

        //Then
        System.out.println(library);
        System.out.println(clonedLibrary);
        System.out.println(deepClonedLibrary);

        Assert.assertEquals(4, library.getBooks().size());
        Assert.assertEquals(4, clonedLibrary.getBooks().size());
        Assert.assertEquals(3, deepClonedLibrary.getBooks().size());
    }

}
