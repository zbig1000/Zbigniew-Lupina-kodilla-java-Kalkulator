package com.kodilla.exception.io;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;


public class StringSplitter {
	public void split()  {
	
    ClassLoader classLoader = getClass().getClassLoader();
    File file = new File(classLoader.getResource("files/names.txt").getFile());
    Path path = Paths.get("files/test2.txt");
////    Path path = Paths.get(file.getPath());
    
    String[] arrayOfString =  {"1:12","2:11", "3:2", "4:1"};
    
    Map<String, String> mymap = Arrays.asList(arrayOfString)
    	      .stream()
    	      .map(str -> str.split(":"))
    	      .collect(Collectors.toMap(str -> str[0], str -> str[1]));
    

    for(Map.Entry<String, String> entry : mymap.entrySet() ) {
    	System.out.println("klucz: "+ entry.getKey() + "value: " + entry.getValue());
    }
    
   // Stream<String>
}
}