package com.twu.biblioteca;

public class BibliotecaRunner {
    public static void main(String[] args) {
        Display commandLineDisplay = new Display(System.out);
        Book[] books = new Book[]{ new Book("Don Quixote"), new Book("Pilgrim's Progress") };
        BibliotecaApp app = new BibliotecaApp(commandLineDisplay, books);
        app.run();
    }
}
