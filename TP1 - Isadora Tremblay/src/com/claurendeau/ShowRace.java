package com.claurendeau;

public class ShowRace {

    private static final int SPACESINBOX = 10;
    
    private final Course course;
    
    public ShowRace(Course course) {
        this.course = course;
    }

    public String drawRace() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < course.getNombreLapinsDansLaCourse(); i++) {
            sb.append(drawRabbitAtPosition(i, course.getPositionLapinDansLaCourse(i)));
        }
        return sb.toString();
    }

    public String drawRabbitAtPosition(int rabbitNumber, int rabbitPosition) {
        StringBuilder sb = new StringBuilder();
        if (rabbitNumber == 0)
            sb.append(drawHeader(course.getLongueurPisteDeCourse()) + "\n");
        sb.append(drawEmptyLine() + "\n");
        
        int [] carrotsOnLine = getCarrottesForRabbit(rabbitNumber, rabbitPosition);
        sb.append(drawRabbitAndCarrotsLineAtPosition(rabbitNumber, rabbitPosition, carrotsOnLine) + 
                "  Avancement " + course.getAvancement(rabbitNumber) + " carottes " + course.getNombreCarottesCumul(rabbitNumber) + "\n");
        sb.append(drawEmptyLine() + "\n");
        sb.append(drawFooterLine() + "\n");
        return sb.toString();
    }

    private int[] getCarrottesForRabbit(int rabbitNumber, int rabbitPosition) {
        int [] carrottesOnLine = new int [course.getLongueurPisteDeCourse()];
        for (int i = rabbitPosition; i < course.getLongueurPisteDeCourse(); i++) {
            if (course.isCarotteDansLaPiste(rabbitNumber, i))
                carrottesOnLine[i] = 1;
        }
        return carrottesOnLine;
    }

    public String drawHeader(int raceLength) {
        StringBuilder sb = new StringBuilder();
        sb.append("+");
        for (int i = 0; i <= raceLength; i++) {
            sb.append(repeat("-", 9));
            sb.append("+");
            if (i == 0) {
                String depart = "Départ";
                int start = (SPACESINBOX / 2) - (depart.length() / 2);
                sb.replace(start, start + depart.length(), depart);
            } else {
                String valueOf = String.valueOf(i);
                int start = (i * 10) + (SPACESINBOX / 2);
                sb.replace(start, start + valueOf.length(), valueOf);
            }
        }
        return sb.toString();
    }

    public String drawRabbitAndCarrotsLineAtPosition(int rabbitNumber, int rabbitPosition, int [] carrots) {
        if (rabbitPosition > 10)
            return "";
        StringBuilder emptyLine = new StringBuilder(drawEmptyLine());
    
        String value = String.valueOf(rabbitNumber + 1);
    
        int start = calcCarrottePositionInLine(rabbitPosition);
        emptyLine.replace(start, start + value.length(), Integer.toString(rabbitNumber + 1));
        if (carrots.length > 0)
            for (int i = 0; i < carrots.length; i++) {
                if (i > rabbitPosition && carrots[i] > 0) {
                    start = calcCarrottePositionInLine(i);
                    emptyLine.replace(start, start + value.length(), "C");
                }
            }
        return emptyLine.toString();
    }

    public String drawEmptyLine() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i <= 10; i++) {
            if (i == 0) {
                sb.append("+");
            }
            sb.append(paddLeftSpaces("+", SPACESINBOX));
        }
        return sb.toString();
    }

    public String paddLeftSpaces(String toBePadded, int lenghtToPad) {
        return String.format("%1$" + lenghtToPad + "s", toBePadded);
    }

    private int calcCarrottePositionInLine(int rabbitPosition) {
        return (rabbitPosition * 10) + 5;
    }

    private String drawFooterLine() {
        return "+---------+---------+---------+---------+---------+---------+---------+---------+---------+---------+---------+";
    }

    public static String repeat(String str, int n) {
        if(str == null) {
            return null;
        }
        final StringBuilder sb = new StringBuilder(str.length() * n);
        for(int i = 0; i < n; i++) {
            sb.append(str);
        }
        return sb.toString();
    }

}
