package com.testing;

import java.io.Console;
import java.util.Scanner;

public class CalendarMain {

    static Scanner in = new Scanner(System.in);

    static int day = 0;
    static int month = 0;
    static int year = 0;
    
	public static void main (String[] args)
	{
		String dateString = getDate();
		
		if (validateDate(dateString)){
			print("valid date");
		}
		else {
			print("invalid date");
		}
	}

	/** 
	 * Print Method
	 * @param string
	 */
	private static void print(String string) {
		System.out.println(string);
	}

	/**
	 * Validator for a date entered in the format dd/mm/yyyy 
	 * @param dateString
	 * @return true if valid date
	 */
	private static boolean validateDate(String dateString) {

		if(dateString.length() != 10) {
			return false;
		}
		else if((dateString.charAt(2) != '/') && (dateString.charAt(4) != '/')){
			return false;
		}
		else if (!checkDateInputsAreNumeric(dateString)){
			return false;			
		}
		day =Integer.parseInt(dateString.substring(0,2));
		month = Integer.parseInt(dateString.substring(3,5));
		year = Integer.parseInt(dateString.substring(6,10));
		
		if(day < 1 || month < 1 || year < 1) {
			return false;
		}
		
		if(month > 12 || year > 2017) {
			return false;
		}
		
		if(day > getMaxMonthDays(month)){
			return false;
		}
		return true;
	}

	/**
	 * Calculates the number of days for a month
	 * @return number of days
	 */
	private static int getMaxMonthDays(int myMonth) {
		int monthLength = 31;
		if(myMonth == 9 
				|| myMonth == 4 
				|| myMonth == 6
				|| myMonth == 11){
			monthLength = 30;
		}
		else if(myMonth == 2) {
			if( leapYear(year)){
				monthLength = 29;
			}
			else {
				monthLength = 28;
			}
		}
			
		return monthLength;
	}

	/**
	 * @param year2 integer representing the year.
	 * @return true if leap year
	 */
	private static boolean leapYear(int year2) {
		boolean leap = false;
		if (year2 % 4 == 0) {
			leap = true;
			if(leap)
			{
				if (year2 % 100 == 0) {
					leap = false;
				}
				if(year2 % 400 == 0) {
						leap = true;
				}
			}
		}
		return leap;
	}

	/**
	 * @param dateString Parses date string elements and
	 * checks that day, month and year are numeric characters 
	 * @return true of all characters are numeric
	 */
	private static boolean checkDateInputsAreNumeric(String dateString) {
		try {
			int x =Integer.parseInt(dateString.substring(0,2));
			x = Integer.parseInt(dateString.substring(3,5));
			x = Integer.parseInt(dateString.substring(6,10));
			return true;
		}
		catch(Exception e){
			return false;
		}
	}

	/**
	 * Requests date input at the console
	 * @return date entered as a string 
	 */
	private static String getDate() {
		System.out.println("Enter Date");
        return in.nextLine(); 
	}
}
