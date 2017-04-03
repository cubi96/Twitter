package com.twitter.poruke;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class TwitterPorukaTest {
	TwitterPoruka t;

	@Before
	public void setUp() throws Exception {
		t = new TwitterPoruka();
	}

	@After
	public void tearDown() throws Exception {
		t = null;
	}

	@Test
	public void testGetKorisnik() {
		t.setKorisnik("Ivan");
		assertEquals("Ivan", t.getKorisnik());
	}

	@Test
	public void testSetKorisnik() {
		t.setKorisnik("Ivan");
		assertEquals("Ivan", t.getKorisnik());
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
	public void testGetPoruka() {
		t.setPoruka("Poruka");
		assertEquals("Poruka", t.getPoruka());
	}

	@Test
	public void testSetPoruka() {
		t.setPoruka("Poruka");
		assertEquals("Poruka", t.getPoruka());
	}

	@Test(expected = java.lang.RuntimeException.class)
	public void testSetPorukaNull() {
		t.setPoruka(null);

	}

	@Test(expected = java.lang.RuntimeException.class)
	public void testSetPorukaPrazanString() {
		t.setPoruka("");

	}

	@Test(expected = java.lang.RuntimeException.class)
	public void testSetPorukaViseZnakova() {

		t.setPoruka("Napraviti repozitorijum na GitHub-u koji se zove „Twitter“ i "
				+ "postaviti Eclipse projekat Twitter koji je povezan sa ovim repozitorijumom. "
				+ "Napomena: ako commit-ova bude i vise nego što je naznaceno, nema veze. "
				+ "Uvodenje novih grana I tagova je opciono. Takode, sa vremena na vreme treba uraditi push na GitHub repozitorijum."
				+ "Napraviti javnu klasu TwitterPoruka u paketu com.twitter.poruke i u nju copy-paste-ovati sledeci kod:");

	}

	@Test
	public void testToString() {
		t.setKorisnik("Ivan");
		t.setPoruka("Poruka");
		assertEquals("KORISNIK:Ivan PORUKA:Poruka", t.toString());
	}

}