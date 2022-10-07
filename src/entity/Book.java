package entity;

public class Book { // entity book

    private int code;

    private static int autoIncrementCode = 1;

    private String tittle;

    private String author;

    private int year;

    private double weight;

    public Book(String tittle, String author, int year, double weight) {
        this.tittle = tittle;
        this.author = author;
        this.year = year;
        this.weight = weight;
        code = autoIncrementCode++; // gerador de código auto
    }

    public String getTittle() {

        return tittle;
    }

    public void setTittle(String tittle) {

        this.tittle = tittle;
    }

    public String getAuthor() {

        return author;
    }

    public void setAuthor(String author) {

        this.author = author;
    }

    public int getYear() {

        return year;
    }

    public void setYear(int year) {

        this.year = year;
    }

    public double getWeight() {

        return weight;
    }

    public void setWeight(double weight) {

        this.weight = weight;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    @Override
    public String toString() {
        return "Obra{" +
                "code = " + code +
                " tittle = '" + tittle + '\'' +
                ", author = '" + author + '\'' +
                ", year = " + year +
                ", weight = " + weight +
                '}';
    }
}
