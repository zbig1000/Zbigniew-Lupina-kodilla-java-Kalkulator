package com.kodilla;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.*;

@SpringBootApplication
public class KodillaCourseApplication {

	public static void main(String[] args) {
//		SpringApplication.run(KodillaCourseApplication.class, args);


		Calculator kalkulator = new Calculator();
		System.out.println("dodawanie 2+2 = " + kalkulator.add(2d, 2d));
		System.out.println("odejmowanie 4.6 - 2.1 = " + kalkulator.substract(4.6, 2.1));
		System.out.println("UHU test GITa !");

	}
}