package com.testing;

import static org.junit.Assert.assertFalse;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class TestsTester {

	@Test
	void testvalidateDateValidJan1st() {
		assertTrue(CalendarMain.validateDate("01/01/1990"));
	}
}
