package it.polito.tdp.libretto;

//import java.time.LocalDate;

public class Voto implements Comparable<Voto> {
	public Voto(int vote, String exam) {
		super();
		this.vote = vote;
		this.exam = exam;
	}
	private int vote;
	private String exam;
	//private LocalDate day;
	
	public int getVote() {
		return vote;
	}
	
	public void setVote(int vote) {
		//if(vote<18 || vote>30) // change this control to take care of the newlibretto
		if(vote<18 || vote>34)
			throw new IllegalArgumentException("Value out of the acceptable range");
		this.vote = vote;
	}
	
	public String getExam() {
		return exam;
	}
	public void setExam(String exam) {
		this.exam = exam;
	}
	
	@Override
	public String toString() { // chiamato ogni volta che voglio rappresentare l'oggetto nella sua versione leggibile
		return "Voto [vote=" + vote + ", exam=" + exam + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((exam == null) ? 0 : exam.hashCode());
		result = prime * result + vote;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Voto other = (Voto) obj;
		if (exam == null) {
			if (other.exam != null)
				return false;
		} else if (!exam.equals(other.exam))
			return false;
		if (vote != other.vote)
			return false;
		return true;
	}

	@Override
	public int compareTo(Voto v) {
		return this.exam.compareTo(v.getExam());
	}
	
	
	
}
