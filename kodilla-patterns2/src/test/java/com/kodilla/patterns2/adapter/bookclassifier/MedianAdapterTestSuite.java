package com.kodilla.patterns2.adapter.bookclassifier;

import com.kodilla.patterns2.adapter.bookclasifier.MedianAdaptee;
import com.kodilla.patterns2.adapter.bookclasifier.MedianAdapter;
import com.kodilla.patterns2.adapter.bookclasifier.librarya.Book;
import org.junit.Assert;
import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

public class MedianAdapterTestSuite {
    @Test
    public void publicationYearMedianTest() {
        //Given
        Set<Book> bookSet = new HashSet<>();

        bookSet.add(new Book("jan", "number1", 2001, "lib00101"));
        bookSet.add(new Book("john", "number2", 1999, "lib20101"));
        bookSet.add(new Book("jura", "number3", 1993, "lib09801"));
        bookSet.add(new Book("jura", "number4", 1995, "lib09181"));

        //When
        MedianAdapter medianAdapter = new MedianAdapter(new MedianAdaptee());
        int publicationYearMedian = medianAdapter.publicationYearMedian(bookSet);

        //Then
        Assert.assertEquals(1999, publicationYearMedian);
    }
}
