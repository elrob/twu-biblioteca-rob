package com.twu.biblioteca;

class BibliotecaApp {

    private final Book[] books;
    private final Input input;
    private final Display display;

    BibliotecaApp(Book[] books, Input input, Display display) {
        this.input = input;
        this.display = display;
        this.books = books;
    }

    void run() {
        display.displayMessage("Welcome to Biblioteca!");
        boolean continueRunning = true;
        while(continueRunning) {
            displayMainMenu();
            continueRunning = handleUserInput();
        }
    }

    private void displayMainMenu() {
        display.displayMessage("Main Menu");
        display.displayMessage("=========");
        display.displayMessage("Please select an option:");
        display.displayMessage("0 | Exit");
        display.displayMessage("1 | List Books");
    }

    private boolean handleUserInput() {
        int userOption;
        try {
            userOption = input.readUserOption();
        } catch(Exception e){
            userOption = -1;
        }

        switch(userOption) {
            case 0: return false;
            case 1: displayBooks(); break;
            default: displayInvalidOptionMessage();
        }

        return true;
    }

    private void displayInvalidOptionMessage() {
        display.displayMessage("Select a valid option!");
    }

    private void displayBooks() {
        display.displayMessage("Books:");
        String tableFormatString = "%-30s%-30s%-14s";
        display.displayMessage(String.format(tableFormatString, "Title", "Author", "Year Published"));
        display.displayMessage("==========================================================================");
        for(Book book : books) {
            String bookRow = String.format(tableFormatString, book.getTitle(), book.getAuthor(), book.getYearPublished());
            display.displayMessage(bookRow);
        }
    }
}
