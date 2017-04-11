package com.twitte;

import static org.junit.Assert.*;

import java.util.LinkedList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.twitter.poruke.TwitterPoruka;

public class TwitterTest {
	
	Twitter t;

	@Before
	public void setUp() throws Exception {
		t = new Twitter();
	}

	@After
	public void tearDown() throws Exception {
		t = null;
	}

	@Test
	public void testVratiSvePoruke() {
		for(int i = 1; i <= 5; i++)
			t.unesi("Pera", "Peric");
		
		assertEquals(5, t.vratiSvePoruke().size());
	}
	
	@Test
	public void testVratiSvePorukeAkoNema() {
	
		assertEquals(0, t.vratiSvePoruke().size());
	}

	@Test
	public void testUnesi() {
		t.unesi("Pera","Peric");
		LinkedList<TwitterPoruka> l = t.vratiSvePoruke();
		
		
		assertEquals("Pera"+"Peric", l.getLast().getKorisnik()+l.getLast().getPoruka());
	}
	
	
	
	@Test (expected = java.lang.RuntimeException.class)
	public void testVratiPorukeNull(){
		t.vratiPoruke(1,null);
	}
	@Test (expected = java.lang.RuntimeException.class)
	public void testVratiPorukePrazanTag(){
		t.vratiPoruke(1,"");
	}
	
	@Test
	public void testVratiPorukeI() {
		TwitterPoruka[] niz = t.vratiPoruke(10, "bilo sta");
		assertEquals(10,niz.length);
	}
		

}
