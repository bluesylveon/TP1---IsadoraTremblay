package com.claurendeau;

public class CoureLapinTerminal {
	
	private static final int NOMBRE_LAPINS = 6;
    private static final int LONGUEUR_PISTE = 10;
    private static int _3SECONDS = 3000;

    public static void main(String[] args) {
	    Course course = new Course(LONGUEUR_PISTE, NOMBRE_LAPINS);
	    ShowRace sr = new ShowRace(course);
	    System.out.println("Start!");
	    System.out.println(sr.drawRace());
	    int step = 1;
	    while (!course.isGagnant()) {
	        course.step();
	        System.out.println("Step " + step++);
	        System.out.println(sr.drawRace());
	        sleep(_3SECONDS);
	    }
	    System.out.println(course.getMessageFinal());
	}

    private static void sleep(int millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
