package com.twu.biblioteca;

public class BibliotecaApp {

    private final Display display;

    public static void main(String[] args) {
        Display commandLineDisplay = new Display(System.out);
        BibliotecaApp app = new BibliotecaApp(commandLineDisplay);
        app.run();
    }

    public BibliotecaApp(Display display) { this.display = display; }

    public void run() { display.displayMessage("Welcome to Biblioteca!"); }
}
