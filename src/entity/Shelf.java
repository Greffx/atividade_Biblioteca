package entity;

public class Shelf {

    private static Book[] shelf;

    public static final double maxWeightPerShelf = 550;

    public final double maxBooksPerShelf = 4;

    public static double sumWeightAllBooks = 0;

    public Shelf(int howManyBooks) {
        shelf = new Book[howManyBooks];
        if (howManyBooks > maxBooksPerShelf) {
            System.out.println("You have reached the limit of this shelf, remove or put in another one.");
        }
    }

    public boolean sumWeightAndAddBookToShelf(Book book) { // to add an array to a small bookcase and sum weight

        for (int i = 0; i < shelf.length; i++) {
            if (shelf[i] == null) {
                shelf[i] = book;
                sumWeightAllBooks += shelf[i].getWeight();
                if (sumWeightAllBooks > maxWeightPerShelf) {
                    System.out.println("Way to heavy, this shelf only hold " + maxWeightPerShelf + " grams and those books are " + sumWeightAllBooks +
                            " grams, need to switch to another bookcase.");
                }
                return true;
            }
        }
        return false;
    }

    public void removeBookFromBookcase(Book book) { // to remove a book from a bookcase
        for (int i = 0; i < shelf.length; i++) {
            if (shelf[i] == book) {
                sumWeightAllBooks -= shelf[i].getWeight();
                shelf[i] = null;
                System.out.println("Book got deleted.");
                if (sumWeightAllBooks > maxWeightPerShelf) {
                    System.out.println("Still need to switch another book, too much weight.");
                } else {
                    double weightLeft = maxWeightPerShelf - sumWeightAllBooks;
                    System.out.println("There is some weight now, " + weightLeft + " grams free to use.");
                }
            }
        }
    }

    public void cleanBookcase() { // to remove a book from a bookcase
        for (int i = 0; i < shelf.length; i++) {
            sumWeightAllBooks -= shelf[i].getWeight();
            shelf[i] = null;
            double weightLeft = maxWeightPerShelf - sumWeightAllBooks;
            System.out.println("This shelf is clean, " + weightLeft + " grams free to use.");
        }
    }

    public void totalWeightPerShelf() {
        int total = 0;
        for (int i = 0; i < shelf.length; i++) {
            total++;
        }
        System.out.print("Total of weight in this shelf: " + sumWeightAllBooks + " grams, and total of books: " + total);
    }
}
