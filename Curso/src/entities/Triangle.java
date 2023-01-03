package entities; // O triângulo é uma entidade

public class Triangle {
    // Atributos que podem ser usados por outras classes
    public double a;
    public double b;
    public double c;

    // Método que cálcula a área de um triângulo
    public double area() {
        // Estamos trabalhando com os atributos da classe
        double p = (a + b + c) / 2.0;
        // Retorna o cálculo da área
        return Math.sqrt(p * (p - a) * (p - b) * (p - c));
    }
}
