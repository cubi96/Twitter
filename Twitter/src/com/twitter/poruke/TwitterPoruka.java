package com.twitter.poruke;
/**
 * Klasa koja definise korisnika i poruke 
 * @author Ivan Stanimirovic
 * @version1.0
 */
public class TwitterPoruka {
	/**
	 * atribut korisnik koji sadzrzi String vrednost, i oznacava korisnika 
	 */
	private String korisnik;
	/**
	 * atribut poruka koja sadrzi String vrednost, i oznacava poruku koju korisnik unosi
	 */
	private String poruka;
	
	/**
	 * metoda vraca korisnika
	 * @return vraca String vrednost koja oznacava ime korisnika
	 */
	public String getKorisnik() {
		return korisnik;
	}
	
	/**
	 * metoda postavlja vrednost korisnika na unetu vrednost
	 * @param korisnik oznacava String koji se postavlja kao vrednost privatnog atributa korisnik, koji ne sme da bude:
	 * <ul>
	 * <li>null</li>
	 * <li>prazan String</li>
	 * </ul>
	 * @throws java.lang.RuntimeException ako parametar korisnik ne odgovara uslovima
	 */
	public void setKorisnik(String korisnik) {
		if (korisnik == null || korisnik.isEmpty())
			throw new RuntimeException("Ime korisnika mora biti uneto");
		this.korisnik = korisnik;
	}
	
	/**
	 * Metoda koja vraca poruku
	 * @return String, sadrzaj privatnog atributa poruka
	 */
	public String getPoruka() {
		return poruka;
	}
	
	/**
	 * metoda postavlja vrednost privatnog atrbuta poruka na unetu vrednost
	 * @param korisnik oznacava String koji se postavlja kao vrednost privatnog atributa poruka, koji ne sme da bude:
	 * <ul>
	 * <li>null</li>
	 * <li>prazan String</li>
	 * <li>String veci od 140 znakova</li>
	 * </ul>
	 * @throws java.lang.RuntimeException ako parametar poruka ne odgovara uslovima
	 */
	public void setPoruka(String poruka) {
		if (poruka == null || poruka.equals("") || poruka.length() > 140)
			throw new RuntimeException("Poruka mora biti uneta i mora imati najvise 140 znakova");
		this.poruka = poruka;
	}
	
	/**
	 * Metoda vraca String sa sadrzajem atributa Korisnik i Poruka
	 * @return String vrednost
	 */
	public String toString() {
		return "KORISNIK:" + korisnik + " PORUKA:" + poruka;
	}
}
