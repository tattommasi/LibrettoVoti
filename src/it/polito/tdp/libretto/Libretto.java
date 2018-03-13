package it.polito.tdp.libretto;

import java.util.ArrayList;
import java.util.List;

public class Libretto {
	
	private List<Voto> voti ;
	
	public Libretto() {
		this.voti = new ArrayList<>() ;
	}
	
	public void add(Voto v) {
		this.voti.add(v) ;
	}
	
	public void stampa() {
		System.out.println("Ci sono "+ voti.size() + " voti");
		for(Voto v: this.voti) {
			System.out.println(v);
		}
	}
}
