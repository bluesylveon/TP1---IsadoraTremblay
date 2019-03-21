package com.claurendeau;

import java.util.Random;

public class Lapin {
	private int id;
	private int position;
	private int nbCarottes;
	static boolean[] piste;		
	
	public int getId() {
		return id;
	}

	public void setId(int lId) {
		id = lId;
	}

	public int getPosition() {
		return position;
	}

	public void setPosition(int lPosition) {
		position = lPosition;
	}

	public int getNbCarottes() {
		return nbCarottes;
	}
	
	public boolean[] getPiste() {
		return piste;
	}

	public void setNbCarottes(int lNbCarottes) {
		nbCarottes = lNbCarottes;
	}

	public Lapin() {		
		piste = new boolean[10];
		for (int i=1;i<piste.length;i++) {
			int nombreAleatoire = new Random().nextInt(10); // entre 0 et 9
			piste[i]= nombreAleatoire < 1 ? true : false;
		}		
	}		
	
	public void avance() {		
		position++;
		if (position < piste.length)
			accumuleCarottes();
		
		if (position >= piste.length)
			position = piste.length;
		
	}
	
	public int mouvement() {		
		return new Random().nextInt(3) + haveCarottesBonusAvance();			
	}		
	
	public int haveCarottesBonusAvance() {
		return nbCarottes > 0 ? 1 : 0;
	}
	
	void accumuleCarottes() {		
		setNbCarottes(piste[position] == true ? nbCarottes + 1 : nbCarottes);		
	}
	
	void mangeCarottes() {
		nbCarottes= nbCarottes > 0 ? nbCarottes-- : nbCarottes;
	}
	
	public String toString() {
		return String.format("%:%:%", id, position, nbCarottes);
	}
}
