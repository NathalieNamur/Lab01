package it.polito.tdp.parole.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Parole {
	
	//ATTRIBUTI:
	private List<String> listaParole;
	
	
	//COSTRUTTORE:
	public Parole() {
		
		listaParole = new ArrayList<String>();
		
		//In alternativa LinkedList:
		//listaParole = new ArrayList<String>();
	}
	
	
	//METODI:
	public void addParola(String p) {
		listaParole.add(p);
	}
	
	public List<String> getElenco() {

		Collections.sort(listaParole);
		return listaParole;
	}
	
	public void reset() {
		listaParole.clear();
	}
	
	public void removeParola(String p) {
		listaParole.remove(p);
	}

}
