package application;

import entity.Book;
import entity.Shelf;

import java.util.Objects;
import java.util.Scanner;


public class Library {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("How many books you want to put in one shelf: ");
        int howManyBooks = sc.nextInt();

        Book[] books = new Book[howManyBooks];

        Shelf shelf = new Shelf(howManyBooks);

        for (int i = 0; i < howManyBooks; i++) {

            System.out.print("Tittle: ");
            sc.nextLine();
            String tittle = sc.nextLine();

            System.out.print("Author: ");
            String author = sc.nextLine();

            System.out.print("Publication year: ");
            int year = sc.nextInt();

            System.out.print("Weight: ");
            double weight = sc.nextDouble();

            if (weight > Shelf.maxWeightPerShelf) {
                break;
            }

            books[i] = new Book(tittle, author, year, weight);
            shelf.sumWeightAndAddBookToShelf(books[i]);
        }

        if (Shelf.sumWeightAllBooks > Shelf.maxWeightPerShelf) {
            System.out.print("Which one will you remove(by id): ");
            int idDelete = sc.nextInt();

            for (int i = 0; i < books.length; i++) {
                if (books[i].getCode() == idDelete) {
                    shelf.removeBookFromBookcase(books[i]);
                }
            }
        }
        System.out.print("Do you want to clean this shelf[y/n]: ");
        sc.nextLine();
        String toClean = sc.nextLine();
        if (Objects.equals(toClean, "y")) {
            shelf.cleanBookcase();
        } else if (!Objects.equals(toClean, "n")) {
            System.out.println("Wrong choice.");
        }
        shelf.totalWeightPerShelf();
    }
}
