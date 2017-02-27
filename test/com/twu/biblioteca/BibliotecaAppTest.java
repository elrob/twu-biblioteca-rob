package com.twu.biblioteca;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.*;
import java.nio.charset.StandardCharsets;

import static org.hamcrest.core.StringEndsWith.endsWith;
import static org.hamcrest.core.StringStartsWith.startsWith;

public class BibliotecaAppTest {

    private static final String EXIT_OPTION = "0";
    private static final String LIST_BOOKS_OPTION = "1";
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
    public void showsWelcomeMessageFirst() {
        app = new BibliotecaApp(books, fakeUserInput(EXIT_OPTION), fakeDisplay(outSpy));
        app.run();
        Assert.assertThat(outSpy.toString(), startsWith("Welcome to Biblioteca!\n"));
    }

    @Test
    public void showsMainMenu() {
        app = new BibliotecaApp(books, fakeUserInput(EXIT_OPTION), fakeDisplay(outSpy));
        app.run();

        StringBuilder expected = new StringBuilder();
        expected.append("Main Menu\n");
        expected.append("=========\n");
        expected.append("Please select an option:\n");
        expected.append("0 | Exit\n");
        expected.append("1 | List Books\n");

        Assert.assertThat(outSpy.toString(), endsWith(expected.toString()));
    }

    @Test
    public void showsBookListWhenSelected() {
        app = new BibliotecaApp(books, fakeUserInput(LIST_BOOKS_OPTION), fakeDisplay(outSpy));
        app.run();

        StringBuilder expected = new StringBuilder();
        expected.append("Books:\n");
        expected.append("Title                         Author                        Year Published\n");
        expected.append("==========================================================================\n");
        expected.append("A book title                  An author                     1966          \n");
        expected.append("Another book title            Another author                1977          \n");

        Assert.assertThat(outSpy.toString(), endsWith(expected.toString()));
    }

    @Test
    public void showsInvalidOptionMessageWhenUserSelectsAnInvalidOption() {
        String invalidOption = "666";
        app = new BibliotecaApp(books, fakeUserInput(invalidOption), fakeDisplay(outSpy));
        app.run();

        Assert.assertThat(outSpy.toString(), endsWith("Select a valid option!\n"));
    }

    private Display fakeDisplay(ByteArrayOutputStream outSpy) {
        return new Display(new PrintStream(outSpy));
    }

    private Input fakeUserInput(String input) {
        return new Input(new ByteArrayInputStream(input.getBytes(StandardCharsets.UTF_8)));
    }
}

