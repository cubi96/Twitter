package com.twitter;

import java.util.LinkedList;
import com.twitter.poruke.TwitterPoruka;

/**
 * 
 * @author Ivan Stanimirovic 
 * @version 1.0
 */
public class Twitter {
	/**
	 * Atribut poruke predstavlja listu poruka
	 */
	private LinkedList<TwitterPoruka> poruke = new LinkedList<TwitterPoruka>();

	/**
	 * Metoda vratiSvePoruke vraca listu poruka
	 * @return listu TwitterPoruka
	 */
	public LinkedList<TwitterPoruka> vratiSvePoruke() {
		return poruke;
	}
	/**
	 * Metoda unosi novu poruku na kraj liste
	 * @param korisnik predstavlja ime korisnika
	 * @param poruka predstavlja sadrzaj poruke koja se unosi
	 */
	public void unesi(String korisnik, String poruka) {
		// Pravi se nova poruka i puni podacima.
		TwitterPoruka tp = new TwitterPoruka();
		tp.setKorisnik("korisnik");
		tp.setPoruka(poruka);
		// Poruka se unosi u listu na kraj
		poruke.addLast(tp);
	}
	/**
	 * Metoda pretrazuje listu poruke na osnovu parametra tag koji se unosi kao parametar i vraca se niz sa pronadjenim porukama
	 * @param maxBroj oznacava maksimalni broj poruka koji treba da bude vracen, ako je unesen negativan broj automatski se vrednost parametra postavlja na 100
	 * @param tag oznacava String koji se koristi kao uslov za pretragu poruka, koji ne sme da bude:
	 * <ul>
	 * <li>null</li>
	 * <li>prazan String</li>
	 * </ul>
	 * @return vraca niz pronadjenih poruka
	 * @throws java.lang.RuntimeException ako parametar tag ne odgovara uslovima
	 */
	public TwitterPoruka[] vratiPoruke(int maxBroj, String tag) {
		if (tag == null || tag.isEmpty())
			throw new RuntimeException("Morate uneti tag");
		// Ako je maxBroj <=0, vraca maxBroj se postavlja na 100 poruka
		if (maxBroj <= 0)
			maxBroj = 100;
		// Pomocna promenljiva koja predstavlja brojac upisanih poruka
		int brojac = 0;
		// Pomocni niz koja predstavlja rezultat pretrage tj. sadrzace
		// sve poruke koje u sebi imaju zadati tag
		TwitterPoruka[] rezultat = new TwitterPoruka[maxBroj];
		// Pretrazuju se poruke i traze se one koje sadrze tag.
		//Ako se nadje neka takva, i ako nije prekoracen maxBroj 
		//ona se upisuje u niz. Ako
		// je prekoracen maxBroj,pretraga
		//se prekida.
		for (int i = 0; i < poruke.size(); i++)
			if (poruke.get(i).getPoruka().indexOf(tag) != -1)
				if (brojac < maxBroj) {
					rezultat[brojac + 1] = poruke.get(i);
					brojac++;
				} else
					break;
		return rezultat;
	}

}
