package com.kodilla.patterns2.adapter.bookclasifier;

import com.kodilla.patterns2.adapter.bookclasifier.libraryb.Book;
import com.kodilla.patterns2.adapter.bookclasifier.librarya.Classifier;
import com.kodilla.patterns2.adapter.bookclasifier.libraryb.BookSignature;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class MedianAdapter implements Classifier {
    MedianAdaptee medianAdaptee = new MedianAdaptee();

    @Override
    public int publicationYearMedian(Set<com.kodilla.patterns2.adapter.bookclasifier.librarya.Book> bookSet) {
        Map<BookSignature, Book> books =
                new HashMap<>();
        bookSet.forEach(t -> books.put(new BookSignature(t.getSignature()), new Book(t.getAuthor(), t.getTitle(), t.getPublicationYear())));
        return medianAdaptee.medianPublicationYear(books);
    }
}
