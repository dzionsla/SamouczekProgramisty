package com.dzionsla.others.maszynalocujaca;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import com.dzionsla.others.MaszynaLosujaca;

public class TestMaszynaLosujaca {
	
	@Test
	public void checkIfFindEmail() {
		assertTrue(MaszynaLosujaca.findEmail("s@sdf"));
	}
	
	@Test
	public void checkIfFindEmailFalse() {
		assertFalse(MaszynaLosujaca.findEmail("ssdf"));
	}
	
}
