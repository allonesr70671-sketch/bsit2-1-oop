package Library;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Library library = new Library();
        Scanner input = new Scanner(System.in);

        int choice;

        do {
            System.out.println("\n===== LIBRARY INFORMATION SYSTEM =====");
            System.out.println("1. Add a book");
            System.out.println("2. List all books");
            System.out.println("3. Borrow a book");
            System.out.println("4. Return a book");
            System.out.println("5. Search a book");
            System.out.println("0. Exit");

            System.out.print("Enter your choice: ");
            choice = input.nextInt();
            input.nextLine(); // Clear the newline

            switch (choice) {

                case 1:
                    System.out.print("Enter title: ");
                    String title = input.nextLine();

                    System.out.print("Enter author: ");
                    String author = input.nextLine();

                    library.addBook(title, author);
                    break;

                case 2:
                    library.listBooks();
                    break;

                case 3:
                    System.out.print("Enter title to borrow: ");
                    String borrowTitle = input.nextLine();

                    library.borrowBook(borrowTitle);
                    break;

                case 4:
                    System.out.print("Enter title to return: ");
                    String returnTitle = input.nextLine();

                    library.returnBook(returnTitle);
                    break;

                case 5:
                    System.out.print("Enter title to search: ");
                    String searchTitle = input.nextLine();

                    library.searchBook(searchTitle);
                    break;

                case 0:
                    System.out.println(">> Thank you for using the Library System. Goodbye!");
                    break;

                default:
                    System.out.println("Invalid choice. Please try again.");
            }

        } while (choice != 0);

        input.close();
    }
}