package entities;

public class Student {
    public String name;
    public double notaUm;
    public double notaDois;
    public double notaTres;

    public double finalGrade() {
        double sum = notaUm + notaDois + notaTres;
        return sum;
    }
    public String passOrFailed() {
        double sum = notaUm + notaDois + notaTres;
        if (sum < 60) {
            // Retorna uma string formatada.
            return String.format("FAILED%nMISSING %.2f POINTS", 60 - sum);
        } else {
            return "PASS";
        }
    }
}
