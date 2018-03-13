package it.polito.tdp.libretto;

public class TestLibretto {

	public static void main(String[] args) {
		
		Libretto lib = new Libretto() ;
		
		lib.add( new Voto("Analisi", 30));
		lib.add( new Voto("Chimica", 28));
		
		lib.stampa();
		
	}

}
