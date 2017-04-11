package com.twitter.poruke;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class TwitterPorukaTest {

	private TwitterPoruka t;

	@Before
	public void setUp() throws Exception {
		t = new TwitterPoruka();
	}

	@After
	public void tearDown() throws Exception {
		t = null;
	}

	@Test
	public void testSetKorisnik() {
		t.setKorisnik("Pera");
		assertEquals("Pera", t.getKorisnik());
	}

	@Test(expected = java.lang.RuntimeException.class)
	public void testSetKorisnikNull() {
		t.setKorisnik(null);

	}

	@Test(expected = java.lang.RuntimeException.class)
	public void testSetKorisnikPrazanString() {
		t.setKorisnik("");

	}

	@Test
	public void testSetPoruka() {
		t.setPoruka("I u Javi i u snu.");
		assertEquals("I u Javi i u snu.", t.getPoruka());
	}
	
	@Test (expected = java.lang.RuntimeException.class)
	public void testSetPorukaNull(){
		t.setPoruka(null);
	}
	
	public void testSetPorukaPrazanString(){
		t.setPoruka("");
	}
	
	@Test //(expected = java.lang.RuntimeException.class)
	public void testSetPorukaDugacka(){
		String poruka = "Contrary to popular belief, Lorem Ipsum is not simply random text. It has roots in a piece of classical Latin literature from 45 BC, making it over 2000 years old. Richard McClintock, a Latin professor at Hampden-Sydney College in Virginia, looked up one of the more obscure Latin words, consectetur, from a Lorem Ipsum passage, and going through the cites of the word in classical literature, discovered the undoubtable source. Lorem Ipsum comes from sections 1.10.32 and 1.10.33 of de Finibus Bonorum et Malorum (The Extremes of Good and Evil) by Cicero, written in 45 BC. This book is a treatise on the theory of ethics, very popular during the Renaissance. The first line of Lorem Ipsum, Lorem ipsum dolor sit ame, comes from a line in section 1.10.32.";

		t.setPoruka(poruka);
		assertEquals(poruka, t.getPoruka());
	}

	@Test
	public void testToString() {
		t.setKorisnik("Pera");
		t.setPoruka("Ima dva sina");

		assertEquals("KORISNIK:Pera PORUKA:Ima dva sina", t.toString());
	}

}
