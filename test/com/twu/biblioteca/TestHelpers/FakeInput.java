package com.twu.biblioteca.TestHelpers;

import com.twu.biblioteca.Input;

import java.util.List;

public class FakeInput implements Input {

    private List<String> inputs;

    public FakeInput(List<String> inputs){
        this.inputs = inputs;
    }

    @Override
    public int readUserOption() {
        String option = inputs.get(0);
        inputs = inputs.subList(1, inputs.size());
        return Integer.parseInt(option);
    }
}
