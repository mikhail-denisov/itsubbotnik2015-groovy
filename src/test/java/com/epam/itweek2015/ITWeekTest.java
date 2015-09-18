package com.epam.itweek2015;

import org.junit.Assert;
import org.junit.Test;

import com.epam.itsubbotnik2015.ITWeek;

public class ITWeekTest {

	@Test
	public void testHelloWorld() throws Exception {
		Assert.assertEquals(new ITWeek().helloWorld(), "Hello World");
	}
	
}
