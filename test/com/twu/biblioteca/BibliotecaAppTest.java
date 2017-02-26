package com.twu.biblioteca;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.hamcrest.core.StringEndsWith.endsWith;
import static org.hamcrest.core.StringStartsWith.startsWith;

public class BibliotecaAppTest {

    private BibliotecaApp app;
    private ByteArrayOutputStream outSpy;
    private Book[] books;

    @Before
    public void setUp() {
        outSpy = new ByteArrayOutputStream();
        books = new Book[]{ new Book("A book title"), new Book("Another book title") };
    }

    @Test
    public void runShowsWelcomeMessageFirst() {
        app = new BibliotecaApp(new Display(new PrintStream(outSpy)), books);
        app.run();
        Assert.assertThat(outSpy.toString(), startsWith("Welcome to Biblioteca!\n"));
    }

    @Test
    public void runShowsBookListLast() {
        app = new BibliotecaApp(new Display(new PrintStream(outSpy)), books);
        app.run();
        Assert.assertThat(outSpy.toString(), endsWith("Books:\nA book title\nAnother book title\n"));
    }
}

