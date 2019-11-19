package com.testing;

public class Tester {

	public static void main(String[] args) {
		if(testMaxMonthDaysJan()) {
			print("testMaxMonthDaysJan - pass");
		}
		else {
			print("testMaxMonthDaysJan - fail");
		}
		if(testMaxMonthDaysFebLeap()) {
			print("testMaxMonthDaysFebLeap - pass");
		}
		else {
			print("testMaxMonthDaysFebLeap - fail");
		}

	}

	private static boolean testMaxMonthDaysFebLeap() {
		return CalendarMain.getMaxMonthDays(2,2000) == 29;
	}

	private static boolean testMaxMonthDaysJan() {
		return CalendarMain.getMaxMonthDays(1,1990) == 31;
	}

	private static void print(String myString) {
		System.out.println(myString);
		
	}

}
