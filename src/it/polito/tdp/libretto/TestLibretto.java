package it.polito.tdp.libretto;

import java.util.Collections;
import java.util.Comparator;

public class TestLibretto {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Libretto lib = new Libretto();
		lib.add( new Voto(30, "Analisi"));
		lib.add( new Voto(28, "Chimica"));
		lib.add( new Voto(25, "TdP"));
		lib.add( new Voto(18, "Fisica"));
		
		lib.print();
		System.out.println(lib.toString());
		
		System.out.println("Votes equal to 25");
		lib.print25();
		
		System.out.println("TdP mark:");
		System.out.println(lib.getMarkfromExam("TdP"));
		System.out.println("TdP mark:");
		System.out.println(lib.getMarkfromExam("tdp"));
		
		lib.add( new Voto(25, "TdP"));
		lib.add( new Voto(27, "TdP"));
		
		System.out.println(lib.toString()); //ristampo per verificare l'aggiornamento
		
		// nuovo oggetto libretto
		// voglio una lista uguale a quella del libretto precedente
		// quindi creo un costruttore che si prenda come parametro la lista del precedente libretto
		Libretto newlib = new Libretto(lib.getVotes());
		System.out.println("\nPrint of the new version of libretto");
		System.out.println(newlib.toString());
		
		newlib.increasevotes();
		System.out.println("\nPrint of the new version of libretto");
		System.out.println(newlib.toString());
		
		//quando il nuovo libretto è fatto bene e ristampo quello vecchio vedo che appunto il vecchio
		//non ha subito cambiamenti
		//System.out.println(lib.toString()); 
		
		// sort degli esami in ordine alfabetico
		Collections.sort(newlib.getVotes());
		System.out.println(newlib.toString());
		
		// utile nel caso io voglia ordinare la lista secondo un criterio diverso da quello standard
		Collections.sort(newlib.getVotes(), new Comparator<Voto>(){
			public int compare(Voto o1, Voto o2) {
				return -(o1.getVote()-o2.getVote());
			}
		});
		System.out.println(newlib.toString());
		
	}

}
