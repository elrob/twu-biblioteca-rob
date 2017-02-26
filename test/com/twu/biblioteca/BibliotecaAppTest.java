package com.twu.biblioteca;

import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.assertEquals;

public class BibliotecaAppTest {

    @Test
    public void runShowsWelcomeMessage() {
        ByteArrayOutputStream outSpy = new ByteArrayOutputStream();
        BibliotecaApp app = new BibliotecaApp(new Display(new PrintStream(outSpy)));

        app.run();

        assertEquals("Welcome to Biblioteca!\n", outSpy.toString());
    }
}

