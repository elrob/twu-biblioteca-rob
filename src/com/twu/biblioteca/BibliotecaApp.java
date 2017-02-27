package com.twu.biblioteca;

public class BibliotecaApp {

    private final Book[] books;
    private final Input input;
    private final Display display;

    public BibliotecaApp(Book[] books, Input input, Display display) {
        this.input = input;
        this.display = display;
        this.books = books;
    }

    public void run() {
        display.displayMessage("Welcome to Biblioteca!");
        displayMainMenu();
    }

    private void displayMainMenu() {
        display.displayMessage("Main Menu");
        display.displayMessage("=========");
        display.displayMessage("Please select an option:");
        display.displayMessage("0 | Exit");
        display.displayMessage("1 | List Books");

        int option = input.readUserOption();
        if (option == 0) return;
        displayBooks();
    }

    private void displayBooks() {
        display.displayMessage("Books:");
        String tableFormatString = "%-30s%-30s%-14s";
        display.displayMessage(String.format(tableFormatString, "Title", "Author", "Year Published"));
        display.displayMessage("==========================================================================");
        for(Book book : books) {
            String bookRow = String.format(tableFormatString, book.getTitle(), book.getAuthor(), book.getYearPublished());
            display.displayMessage(bookRow);
        }
    }
}
