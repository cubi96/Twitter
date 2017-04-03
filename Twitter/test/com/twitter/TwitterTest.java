package com.twitter;

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
		LinkedList<TwitterPoruka> tp = new LinkedList<TwitterPoruka>();
		LinkedList<TwitterPoruka> te = new LinkedList<TwitterPoruka>();
		TwitterPoruka tw = new TwitterPoruka();
		t.unesi("Korisnik", "Poruka");
		tw.setKorisnik("Korisnik");
		tw.setPoruka("Poruka");
		tp.addLast(tw);
		te = t.vratiSvePoruke();
		assertEquals(tp.getLast().getPoruka(), te.getLast().getPoruka());
		assertEquals(tp.getLast().getKorisnik(), te.getLast().getKorisnik());

	}

	@Test
	public void testUnesi() {
		LinkedList<TwitterPoruka> tp = new LinkedList<TwitterPoruka>();
		LinkedList<TwitterPoruka> te = new LinkedList<TwitterPoruka>();
		TwitterPoruka tw = new TwitterPoruka();
		t.unesi("Korisnik", "Poruka");
		tw.setKorisnik("Korisnik");
		tw.setPoruka("Poruka");
		tp.addLast(tw);
		te = t.vratiSvePoruke();
		assertEquals(tp.getLast().getPoruka(), te.getLast().getPoruka());
		assertEquals(tp.getLast().getKorisnik(), te.getLast().getKorisnik());
	}

	@Test
	public void testVratiPoruke() {
		t.unesi("Korisnik", "#p Poruka1");
		t.unesi("Korisnik", "#p Poruka1");
		t.unesi("Korisnik", "#p Poruka1");
		t.unesi("Korisnik", "#c Poruka");
		TwitterPoruka t1 = new TwitterPoruka();
		t1.setKorisnik("Korisnik");
		t1.setPoruka("#p Poruka1");
		TwitterPoruka t2 = new TwitterPoruka();
		t2.setKorisnik("Korisnik");
		t2.setPoruka("#p Poruka1");
		TwitterPoruka t3 = new TwitterPoruka();
		t3.setKorisnik("Korisnik");
		t3.setPoruka("#p Poruka1");
		TwitterPoruka[] rez = new TwitterPoruka[3];
		rez[0]=t1;
		rez[1]=t2;
		rez[2]=t3;
		TwitterPoruka[] rezP = t.vratiPoruke(3, "#p");
		for(int i=0; i<rez.length;i++){
			if(!rez[i].getPoruka().equals(rezP[i].getPoruka())){
				fail();
			}
		}
	}
	@Test(expected = java.lang.RuntimeException.class)
	public void testVratiPorukeNull() {
		t.unesi("Korisnik", "#p Poruka1");
		t.unesi("Korisnik", "#p Poruka1");
		t.unesi("Korisnik", "#p Poruka1");
		t.unesi("Korisnik", "#c Poruka");
		t.vratiPoruke(3, null);
	}
	@Test(expected = java.lang.RuntimeException.class)
	public void testVratiPorukePrazanString() {
		t.unesi("Korisnik", "#p Poruka1");
		t.unesi("Korisnik", "#p Poruka1");
		t.unesi("Korisnik", "#p Poruka1");
		t.unesi("Korisnik", "#c Poruka");
		t.vratiPoruke(3, "");
	}

}
