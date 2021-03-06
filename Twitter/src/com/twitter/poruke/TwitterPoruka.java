package com.twitter.poruke;


/**
 * Klasa koja cuva poruke
 * 
 * @author Milos
 *@version 1.0
 */

public class TwitterPoruka {

	/**
	 * Ime korisnika
	 */
	private String korisnik;
	/**
	 * Sadrzina poruke korisnika.
	 */
	private String poruka;
	
	/**
	 * Vraca vrednost atributa korisnik.
	 * @return ime korisnika kao String.
	 */
	public String getKorisnik() {
		return korisnik;
	}
	/**
	 * Postavlja vrednost atributa korisnik.
	 * @param korisnik kao novo ime korisnika.
	 * @throws java.lang.RuntimeException ako je uneto ime:
	 * <ul>
	 * <li>null</li>
	 * <li>prazan String</li>
	 * </ul>
	 */
	public void setKorisnik(String korisnik) {
		if (korisnik == null || korisnik.isEmpty())
			
			throw new RuntimeException("Ime korisnika mora biti uneto");
		this.korisnik = korisnik;
	}
	/**
	 * Vraca vrednost atributa poruka.
	 * @return tekst poruke kao String.
	 */
	public String getPoruka() {
		return poruka;
	}
	/**
	 * Postavlja vrednost atributa poruka.
	 * @param poruka kao novi tekst poruke.
	 * @throws java.lang.RuntimeException ako je unet tekst poruke:
	 * <ul>
	 * <li>null</li>
	 * <li>prazan String</li>
	 * <li>poruka duza od 140 karaktera</li>
	 * </ul>
	 */
	public void setPoruka(String poruka) {
		if (poruka == null || poruka.equals("") )
			throw new RuntimeException("Poruka mora biti uneta");
		this.poruka = poruka;
	}
	
	/**
	 * Vraca podatke o korisniku i njegovoj poruci.
	 * @return naziv korisnika i tekst poruke kao String.
	 */
	public String toString() {
		return "KORISNIK:" + korisnik + " PORUKA:" + poruka;
	}
}
