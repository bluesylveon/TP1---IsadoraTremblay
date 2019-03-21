package com.claurendeau;
//TEST
public class Course {
	
	private int nbLapins = getNombreLapinsDansLaCourse();
	private Lapin[] lapins = new Lapin[nbLapins];
	private int longueur = getLongueurPisteDeCourse();	
	private boolean[][] piste;

    public Course(int longueurPiste, int nombreLapins) {
    	piste = new boolean[nombreLapins][longueurPiste];
    	for (int i = 0; i < nbLapins; i++) {
    		lapins[i] = new Lapin();
    		lapins[i].setId(i+1);
    		lapins[i].setPosition(0);
    		lapins[i].setNbCarottes(0);
    		setPiste(i);
    	}    	    	 
    }

    public boolean isCarotteDansLaPiste(int rangee, int colonne) {
        return piste[rangee][colonne];
    }
    
    public void setPiste(int lapin) {  			
		piste[lapin] = lapins[lapin].getPiste();   	
    }

    public int getNombreLapinsDansLaCourse() {
        return 6;
    }

    public int getLongueurPisteDeCourse() {
        return 10;
    }

    public int getNombreCarottesCumul(int indexLapin) {
        return lapins[indexLapin].getNbCarottes();
    }

    public int getPositionLapinDansLaCourse(int indexLapin) {
        return lapins[indexLapin].getPosition();
    }

    public void step() {
    	for (int i = 0; i < nbLapins; i++) {
    		int move = getAvancement(i);
    		for (int j = 0; j < move; j++) {
    			lapins[i].avance(); 
    			
    			
    		}
    		lapins[i].mangeCarottes();   		    		
    	}
    }

    /**
     * Retourne une represention sous forme de chaine de caracteres de la piste de
     * course. Vous pouvez simplement afficher chacun des lapins et le tableau de
     * carottes pour voir les position des carottes
     *
     * @return String la chaine de caractere representant la Course
     */
    public String toString() {
    	String lapinsString = "";
    	for (int i = 0; i < nbLapins; i++) {
    		lapinsString += lapins[i].toString() + "/n";
    	}
        return lapinsString;
    }

    public String getMessageFinal() {
    	String msg = "Course gagnée par le(s) lapin(s) ";
    	for (int i = 0; i < nbLapins; i++)
    		msg += lapinWin(i) ? lapins[i].getId() + " " : "";
        return msg;
    }

    public boolean isGagnant() {
    	for (int i = 0; i < nbLapins; i++) {
    		if (lapins[i].getPosition() >= longueur)
    			return true;
    	}
        return false;
    }
    public boolean lapinWin (int lapin) {
    	return lapins[lapin].getPosition() >= longueur ? true : false;
    }

    public void setCarrots(boolean[][] carrots) {
    	
    }
    
    public int getAvancement(int lapin) {
        return lapins[lapin].mouvement();
    }

}
