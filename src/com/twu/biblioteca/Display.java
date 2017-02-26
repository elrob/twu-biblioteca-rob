package com.twu.biblioteca;

import java.io.PrintStream;

public class Display {
    private final PrintStream outputStream;

    public Display(PrintStream outputStream) {
        this.outputStream = outputStream;
    }

    public void displayMessage(String message) {
        outputStream.println(message);
    }
}
