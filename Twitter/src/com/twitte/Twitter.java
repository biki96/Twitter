package com.twitte;

import java.util.LinkedList;
import com.twitter.poruke.TwitterPoruka;

/**
 * 
 *@author Milos Bijanic
 *@version 2.0
 *	Klasa kreira listu poruka i: 
 * <ul>
 * <li>Unosi poruke na kraj liste</li>
 * <li>Vrsi pretragu liste</li>
 * </ul>
 */

public class Twitter {
	/**
	 * Lista objekata  TwitterPoruka.
	 */
	private LinkedList<TwitterPoruka> poruke = new LinkedList<TwitterPoruka>();

	
	/**
	 * Vraca celu listu sa svim porukama.
	 * @return lista tipa TwitterPoruka.
	 */
	public LinkedList<TwitterPoruka> vratiSvePoruke() {
		return poruke;
	}

	/***
	 * Unosi novu poruku na kraj liste.
	 * @param ime korisnika koji je napravio poruku
	 * @param sam tekst poruke.
	 */
	public void unesi(String korisnik, String poruka) {
		// Pravi se nova poruka i puni podacima.
		TwitterPoruka tp = new TwitterPoruka();
		tp.setKorisnik(korisnik);
		tp.setPoruka(poruka);
		// Poruka se unosi u listu na kraj
		poruke.addLast(tp);
	}

	
	/**
	 * Pretrazuje poruke koje sadrze po 'tagu', i pravi niz od tih poruka.
	 * @param maxBroj maksimalna duzina niza.
	 * @param tag kriterijum za pretragu.
	 * @return niz objekata TwitterPoruka koje su pronadjene prema tagu.
	 * @throws java.lang.RuntimeException ako je tag:
	 * <ul>
	 * <li>null</li>
	 * <li>prazan String</li>
	 * </ul>
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
		// Ako se nadje neka takva, i ako nije prekoracen maxBroj
		// ona se upisuje u niz. Ako je prekoracen maxBroj,pretraga
		// se prekida.
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