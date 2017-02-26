package com.twu.biblioteca;

public class BibliotecaApp {

    private final Display display;
    private final Book[] books;

    public BibliotecaApp(Display display, Book[] books) {
        this.display = display;
        this.books = books;
    }

    public void run() {
        display.displayMessage("Welcome to Biblioteca!");
        displayBooks();
    }

    private void displayBooks() {
        display.displayMessage("Books:");
        for(Book book : books) {
            display.displayMessage(book.getTitle());
        }
    }
}
