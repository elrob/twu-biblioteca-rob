package com.twu.biblioteca;

import com.twu.biblioteca.TestHelpers.FakeInput;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Collections;
import java.util.LinkedList;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.core.StringEndsWith.endsWith;
import static org.hamcrest.core.StringStartsWith.startsWith;

public class BibliotecaAppTest {

    private static final String EXIT_OPTION = "0";
    private static final String LIST_BOOKS_OPTION = "1";
    private BibliotecaApp app;
    private ByteArrayOutputStream outSpy;
    private Book[] books;

    private static final String expectedInvalidOptionMessage = "Select a valid option!\n";
    private static final String expectedMainMenu = String.join("\n",
            "Main Menu",
            "=========",
            "Please select an option:",
            "0 | Exit",
            "1 | List Books") + "\n";
    private static final String expectedBooksList = String.join("\n",
            "Books:",
            "Title                         Author                        Year Published",
            "==========================================================================",
            "A book title                  An author                     1966          ",
            "Another book title            Another author                1977          ") + "\n";

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
    public void showsMainMenuAndExits() {
        app = new BibliotecaApp(books, fakeUserInput(EXIT_OPTION), fakeDisplay(outSpy));
        app.run();

        Assert.assertThat(outSpy.toString(), endsWith(expectedMainMenu));
    }

    @Test
    public void showsBookListWhenSelected() {
        String[] inputs = new String[]{LIST_BOOKS_OPTION, EXIT_OPTION};
        app = new BibliotecaApp(books, fakeUserInput(inputs), fakeDisplay(outSpy));
        app.run();

        Assert.assertThat(outSpy.toString(), containsString(expectedBooksList));
    }

    @Test
    public void showsInvalidOptionMessageWhenUserSelectsAnInvalidOption() {
        String[] inputs = new String[]{"666", EXIT_OPTION};
        app = new BibliotecaApp(books, fakeUserInput(inputs), fakeDisplay(outSpy));
        app.run();

        Assert.assertThat(outSpy.toString(), containsString(expectedInvalidOptionMessage));
    }

    @Test
    public void showsInvalidOptionMessageWhenUserDoesNotInputInteger() {
        String[] inputs = new String[]{"INVALID_OPTION", EXIT_OPTION};
        app = new BibliotecaApp(books, fakeUserInput(inputs), fakeDisplay(outSpy));
        app.run();

        Assert.assertThat(outSpy.toString(), containsString(expectedInvalidOptionMessage));
    }

    @Test
    public void userCanSelectMultipleOptionsBeforeQuitting() {
        String[] inputs = new String[]{LIST_BOOKS_OPTION, "INVALID_OPTION", EXIT_OPTION};
        app = new BibliotecaApp(books, fakeUserInput(inputs), fakeDisplay(outSpy));
        app.run();

        String optionsDisplayedCombined = expectedMainMenu + expectedBooksList +
                expectedMainMenu + expectedInvalidOptionMessage + expectedMainMenu;

        Assert.assertThat(outSpy.toString(), containsString(optionsDisplayedCombined));
    }

    private Display fakeDisplay(ByteArrayOutputStream outSpy) {
        return new Display(new PrintStream(outSpy));
    }

    private FakeInput fakeUserInput(String... input) {
        LinkedList<String> inputList = new LinkedList<>();
        Collections.addAll(inputList, input);
        return new FakeInput(inputList);
    }
}

