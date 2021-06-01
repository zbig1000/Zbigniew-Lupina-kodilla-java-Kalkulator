package com.kodilla.exception.main;

import com.kodilla.exception.io.FileReader;
import com.kodilla.exception.io.FileReaderException;
import com.kodilla.exception.io.StringSplitter;

public class ExceptionModuleRunner {
    public static void main(String args[]) {
        FileReader fileReader = new FileReader();
        try {
            fileReader.readFile();
        }
        catch (FileReaderException e) {
        System.out.println("Problem while reading the file "+e);
        }

        StringSplitter sp = new StringSplitter();
        sp.split();
        
        
    }
}
