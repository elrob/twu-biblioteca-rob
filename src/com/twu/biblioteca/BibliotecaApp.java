package com.twu.biblioteca;

public class BibliotecaApp {

    private final Display display;
    private final String[] books;

    public BibliotecaApp(Display display, String[] books) {
        this.display = display;
        this.books = books;
    }

    public void run() {
        display.displayMessage("Welcome to Biblioteca!");
        displayBooks();
    }

    private void displayBooks() {
        display.displayMessage("Books:");
        for(String book : books) {
            display.displayMessage(book);
        }
    }
}
