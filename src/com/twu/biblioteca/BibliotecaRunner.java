package com.twu.biblioteca;

public class BibliotecaRunner {
    public static void main(String[] args) {
        Display commandLineDisplay = new Display(System.out);
        String[] books = new String[]{ "Don Quixote", "Pilgrim's Progress" };
        BibliotecaApp app = new BibliotecaApp(commandLineDisplay, books);
        app.run();
    }
}
