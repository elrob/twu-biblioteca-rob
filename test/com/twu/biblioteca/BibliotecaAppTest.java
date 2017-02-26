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
        Book aBook = new Book("A book title", "An author", 1966);
        Book anotherBook = new Book("Another book title", "Another author", 1977);
        books = new Book[]{aBook,  anotherBook};
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

        StringBuilder expected = new StringBuilder();
        expected.append("Books:\n");
        expected.append("Title                         Author                        Year Published\n");
        expected.append("==========================================================================\n");
        expected.append("A book title                  An author                     1966          \n");
        expected.append("Another book title            Another author                1977          \n");

        Assert.assertThat(outSpy.toString(), endsWith(expected.toString()));
    }
}

