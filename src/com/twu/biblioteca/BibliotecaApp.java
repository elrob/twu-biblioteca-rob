package com.twu.biblioteca;

public class BibliotecaApp {

    private final Display display;
    private final String[] books;

    public static void main(String[] args) {
        Display commandLineDisplay = new Display(System.out);
        String[] books = new String[]{ "Don Quixote", "Pilgrim's Progress" };
        BibliotecaApp app = new BibliotecaApp(commandLineDisplay, books);
        app.run();
    }

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
