package com.kodilla.stream;

import com.kodilla.stream.beautifier.*;

public class StreamMain {
    public static void main(String[] args) {
        PoemBeautifier poemBeautifier = new PoemBeautifier();

        poemBeautifier.beautify("Ala ma kota", a -> "ABC" + a );
        poemBeautifier.beautify("Ala ma kota", a -> a + "ABC");
        poemBeautifier.beautify("Ala ma kota", a -> a.toUpperCase());
        poemBeautifier.beautify("Ala ma kota", a -> a.toLowerCase());
        poemBeautifier.beautify("Ala ma kota", a -> a.replaceAll("kot", "wieloryb"));

    }

}
