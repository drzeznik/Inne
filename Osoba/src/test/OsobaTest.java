package test;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;

import glowny.Osoba;

class OsobaTest {
	@Test
	void testWiek() 
	{
		String im1="Imie";
		LocalDate daTe1=LocalDate.of(2017,2,11);
		Osoba o1=new Osoba(im1,im1,daTe1,im1);
		assertEquals("Imie,Imie,2,Imie", o1.opisOsoby());
	}
		
	@Test
	void testBledneWczytanie() 
	{
		String im2="";
		LocalDate daTe2=LocalDate.of(2000,2,11);
		Osoba o1=new Osoba(im2,im2,daTe2,im2);
		assertEquals(",,19,", o1.opisOsoby());
	}
	@Test
	void testBledneWczytanie2() 
	{
		String im3=" 342";
		LocalDate daTe3=LocalDate.of(2013,4,13);
		Osoba o1=new Osoba(im3,im3,daTe3,im3);
		assertEquals(" 342, 342,5, 342", o1.opisOsoby());
	}

}
