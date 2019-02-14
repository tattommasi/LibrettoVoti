package it.polito.tdp.libretto;

import java.util.ArrayList;
import java.util.List;

public class Libretto  {
	private List<Voto> votes; // oggetto di tipo list che contiene i voti
	
	public Libretto() {
		this.votes = new ArrayList<>(); // oggetto di tipo libretto che di fatto inizializza un oggetto di tipo voto
        //this.votes = new ArrayList<Voto>(); // non è necessario specificarlo, java lo compila da solo
	}
	
	// nota che una classe può anche avere più costruttori purchè sia definita con parametri diversi
	public Libretto(List<Voto> votes) {
		//this.votes = votes; //copia la lista del vecchio nel nuovo
		//la riga sopra non va bene: non ho duplicato la lista, ho copiato il puntatore e quindi quando
		//aggiorno il libretto nuovo mi aggiorna il contenuto del puntatore originale...
		//Questa è una shallow copy, a me serve una deep copy!
		
		//this.votes = new ArrayList<Voto>(votes); 
		// oppure
		//this.votes = new ArrayList<Voto>();
		//for (Voto v: votes){
		//	this.votes.add(v);
		//}
		//fanno esattamente la stessa cosa, comunque sbagliata
		
		this.votes = new ArrayList<Voto>();
		for (Voto v: votes){
			this.votes.add(new Voto(v.getVote(), v.getExam()));
		}
		
	}
	
	public void add(Voto v) { //metodo ADD del libretto, viene delegato alla struttura dati sottostante che è la lista
		// questo confronto si basa sull'equals dell'oggetto voto che confronta sia voto che esame
		if (this.votes.contains(v)) {
			System.out.println("Vote already existent");
			return;
		}
		// invece il confronto successivo si focalizza solo su esame
		for (Voto vv: this.votes){
			if(vv.getExam().equals(v.getExam())) {
				System.out.println("This exam name was already included (the vote will be updated!)");
				vv.setVote(v.getVote());
				return;
			}
		}
		this.votes.add(v);
	}
	
	public void increasevotes() {
		for (Voto v: this.votes) {
			if(v.getVote()>=24) {
				v.setVote(v.getVote()+2);
		} else if (v.getVote()>=18) {
			v.setVote(v.getVote()+1);
		}
	}
	}
	
	
	public void print() {
		System.out.println("There are " + votes.size() + " votes\n");
		for(Voto v: this.votes) {
			System.out.println(v);
		}
	}
	
	
	public void print25() {
		for(Voto v: this.votes) {
			if (v.getVote()==25) {
			System.out.println(v);
			}
		}
	}

	public List<Voto> getVotes()
	{
		return this.votes;
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("There are " + votes.size() + " votes\n");
		for(Voto v: this.votes) {
			//sb.append(v.toString());  // si può anche non esplicitare
			sb.append(v);
			sb.append("\n");
		}
		return sb.toString();
	}

	public String getMarkfromExam(String CourseName) {
		for(Voto v: this.votes) {
			//if (v.getExam()==CourseName) { //non andrebbe mai usato l'==!! è un errore confrontare due oggetti così
			//if (v.getExam().toLowerCase()==CourseName.toLowerCase()) { // prima funzionava ora non funziona più...
			// il primo tentativo per qualche motivo funzionava ma è una eccezione!!!
			// l'aggiunta del tolowercase per entrambi mi assicura che la ricerca non sia casesensitive
			if (v.getExam().toLowerCase().equals(CourseName.toLowerCase())) {
				return String.valueOf(v.getVote());
			}
		}
		return "course name not found";
	}


	
	
	
}
