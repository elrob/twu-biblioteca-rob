package com.twu.biblioteca;

import java.io.PrintStream;

class Display {
    private final PrintStream outputStream;

    Display(PrintStream outputStream) {
        this.outputStream = outputStream;
    }

    void displayMessage(String message) {
        outputStream.println(message);
    }
}
