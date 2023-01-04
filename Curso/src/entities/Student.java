package entities;

public class Student {
    public String name;
    public double notaUm;
    public double notaDois;
    public double notaTres;

    public double finalGrade() {
        return notaUm + notaDois + notaTres;
    }
    public String passOrFailed() {
        if (finalGrade() < 60) {
            // Retorna uma string formatada.
            return String.format("FAILED%nMISSING %.2f POINTS", 60 - finalGrade());
        } else {
            return "PASS";
        }
    }
}
