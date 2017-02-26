package com.twu.biblioteca;

public class BibliotecaRunner {
    public static void main(String[] args) {
        Display commandLineDisplay = new Display(System.out);
        Book book1 = new Book("Don Quixote", "Miguel De Cervantes", 1605);
        Book book2 = new Book("Pilgrim's Progress", "John Bunyan", 1678);
        Book[] books = new Book[]{book1, book2};
        BibliotecaApp app = new BibliotecaApp(commandLineDisplay, books);
        app.run();
    }
}
