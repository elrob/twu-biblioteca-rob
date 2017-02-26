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
        String tableFormatString = "%-30s%-30s%-14s";
        display.displayMessage(String.format(tableFormatString, "Title", "Author", "Year Published"));
        display.displayMessage("==========================================================================");
        for(Book book : books) {
            String bookRow = String.format(tableFormatString, book.getTitle(), book.getAuthor(), book.getYearPublished());
            display.displayMessage(bookRow);
        }
    }
}
