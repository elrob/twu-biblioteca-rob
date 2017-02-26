package com.twu.biblioteca;

public class BibliotecaApp {

    private final Display display;

    public static void main(String[] args) {
        BibliotecaApp app = new BibliotecaApp(null);
        app.run();
    }

    public void run() {
    }

    public BibliotecaApp(Display display) {
        this.display = display;
    }

}
