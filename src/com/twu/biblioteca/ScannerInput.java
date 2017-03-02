package com.twu.biblioteca;

import java.io.InputStream;
import java.util.Scanner;

public class ScannerInput implements Input {

    private final InputStream inputStream;

    ScannerInput(InputStream inputStream) {
        this.inputStream = inputStream;
    }

    @Override
    public int readUserOption() {
        return new Scanner(inputStream).nextInt();
    }
}
