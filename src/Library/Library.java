package Library;

import Library.book.book;

import java.util.ArrayList;

public class Library {

    private ArrayList<book> books = new ArrayList<>();

    public void addBook(String title, String author) {
        books.add(new book(title, author));
        System.out.println(">> Book added successfully.");
    }

    public void listBooks() {

        System.out.println("\n--- Library Catalog ---");

        if (books.isEmpty()) {
            System.out.println("No books available.");
            return;
        }

        for (int i = 0; i < books.size(); i++) {

            book b = books.get(i);

            String status = b.isBorrowed() ? "[Borrowed]" : "[Available]";

            System.out.println((i + 1) + ". " +
                    b.getTitle() + " by " +
                    b.getAuthor() + " " + status);
        }
    }

    public void borrowBook(String title) {

        for (book b : books) {

            if (b.getTitle().equalsIgnoreCase(title)) {

                if (!b.isBorrowed()) {
                    b.borrow();
                    System.out.println(">> You borrowed '" + title + "'.");
                } else {
                    System.out.println(">> Book is already borrowed.");
                }
                return;
            }
        }

        System.out.println(">> Book not found.");
    }

    public void returnBook(String title) {

        for (book b : books) {

            if (b.getTitle().equalsIgnoreCase(title)) {

                if (b.isBorrowed()) {
                    b.returnBook();
                    System.out.println(">> Book returned successfully.");
                } else {
                    System.out.println(">> Book wasn't borrowed.");
                }

                return;
            }
        }

        System.out.println(">> Book not found.");
    }

    public void searchBook(String title) {

        for (book b : books) {

            if (b.getTitle().equalsIgnoreCase(title)) {

                String status = b.isBorrowed() ? "[Borrowed]" : "[Available]";

                System.out.println(b.getTitle() + " by " +
                        b.getAuthor() + " " + status);

                return;
            }
        }

        System.out.println(">> Book not found.");
    }

}