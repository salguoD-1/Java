package entities;

public class PersonData {
    private double height;
    private char sex;

    public PersonData(double height, char sex) {
        this.height = height;
        this.sex = sex;
    }

    public double getHeight() {
        return height;
    }

    public char getSex() {
        return sex;
    }

}
