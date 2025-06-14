package com.example.springboot;

import com.example.springboot.TestPatient;
import com.example.springboot.TestBenhan;
import com.example.springboot.TestRoom;
import com.example.springboot.TestSchedule;

public class Application {

	public static void main(String[] args) {
		TestPatient tpt = new TestPatient();
		tpt.dsMauPatient();
		tpt.inPatient();
		
	}
}
