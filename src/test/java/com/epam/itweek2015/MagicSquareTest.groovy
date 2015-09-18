package com.epam.itweek2015;

import com.epam.itsubbotnik2015.MagicSquare;

import org.junit.Test

class MagicSquareTest {

	@Test
	public void magicSquare() { // not 'def magicSquare()'   
		
		def magicSquare = new MagicSquare().magicSquare(3)
		
		// Groovy way to compare lists
		assert magicSquare == [ [6, 1, 8], [7, 5, 3], [2, 9, 4] ]
	}
}



