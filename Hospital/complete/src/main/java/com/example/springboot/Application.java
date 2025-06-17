package com.example.springboot;

import com.example.springboot.Test.TestPatient;

public class Application {

	public static void main(String[] args) {
		System.out.println("Hello, Spring Boot!");
		System.out.println();

		TestPatient testPatient = new TestPatient();
		testPatient.dsMauPatient();
		testPatient.inPatient();

	}
}
