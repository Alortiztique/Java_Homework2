    // Code Made By Al.ortiztique for Programming 1
    // Professor Rajesh Soni

import java.util.HashMap;
import java.util.Scanner;

public class LibrarySystem {

    // Inner class to represent a book with author and quantity attributes
    static class Book {
        int quantity;

        public Book(String author, int quantity) {
            this.quantity = quantity;
        }
    }

    // HashMap to store books; keys are book titles and values are Book objects
    private final HashMap<String, Book> library = new HashMap<>();
    private final Scanner scanner = new Scanner(System.in);

    // Method to start the library system and handle user input
    public void startLibrarySystem() {
        while (true) {
            System.out.println("\n📚 What would you like to do? 📚");
            System.out.println("1. Add Books 📖");
            System.out.println("2. Borrow Books 🏃‍♂️");
            System.out.println("3. Return Books 🔄");
            System.out.println("4. Exit 🚪");
            System.out.print("Pick an option (just type the number!): ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // consume the remaining newline

            switch (choice) {
                case 1 -> addBook();
                case 2 -> borrowBook();
                case 3 -> returnBook();
                case 4 -> {
                    System.out.println("See you next time! Exiting library system. 👋");
                    return;
                }
                default -> System.out.println("Oops! That's not a valid choice. Try again! 🙈");
            }
        }
    }

    // Method to add books to the library
    private void addBook() {
        System.out.print("What's the book title? 📖: ");
        String title = scanner.nextLine();
        System.out.print("Who's the author? 🖋: ");
        String author = scanner.nextLine();
        System.out.print("How many copies do we have? 📚: ");
        int quantity = scanner.nextInt();
        scanner.nextLine(); // consume newline

        // Check if book already exists in the library
        if (library.containsKey(title)) {
            Book book = library.get(title);
            book.quantity += quantity; // Update quantity of existing book
            System.out.println("Nice! More copies added for \"" + title + "\" 🎉.");
        } else {
            // Add new book to the library
            library.put(title, new Book(author, quantity));
            System.out.println("Woohoo! New book added to our family! 🎉");
        }
    }

    // Method to borrow books from the library
    private void borrowBook() {
        System.out.print("Which book do you want to take for a spin? 🏃‍♂️: ");
        String title = scanner.nextLine();
        System.out.print("How many copies are you taking? 🤔: ");
        int quantity = scanner.nextInt();
        scanner.nextLine(); // consume newline

        // Check if the book is available in the library
        if (library.containsKey(title)) {
            Book book = library.get(title);
            if (book.quantity >= quantity) {
                book.quantity -= quantity; // Decrease the quantity of the book
                System.out.println("All set! Enjoy your " + quantity + " copies of \"" + title + "\" 😊");
            } else {
                System.out.println("Oh no! We don't have enough copies right now 😢.");
            }
        } else {
            System.out.println("Hmm... we can't find that book 🤔.");
        }
    }

    // Method to return books to the library
    private void returnBook() {
        System.out.print("Which book are you returning today? 🔄: ");
        String title = scanner.nextLine();
        System.out.print("How many copies are you returning? 📚: ");
        int quantity = scanner.nextInt();
        scanner.nextLine(); // consume newline

        // Check if the book exists in the library
        if (library.containsKey(title)) {
            Book book = library.get(title);
            book.quantity += quantity; // Increase the quantity of the book
            System.out.println("Thanks for returning your books! Hope you had a great time reading them 😊");
        } else {
            System.out.println("This is a bit awkward... It looks like these aren't our books 😬.");
        }
    }

    // Main method to launch the library system
    public static void main(String[] args) {
        LibrarySystem system = new LibrarySystem();
        system.startLibrarySystem();
    }
}