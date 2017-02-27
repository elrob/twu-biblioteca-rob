package com.twu.biblioteca;

import java.io.InputStream;
import java.util.Scanner;

public class Input {

    private final Scanner input;

    public Input(InputStream inputStream) {
        input = new Scanner(inputStream);
    }

    public int readUserOption() {
        return input.nextInt();
    }
}
