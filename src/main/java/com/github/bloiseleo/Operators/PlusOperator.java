package com.github.bloiseleo.Operators;

public class PlusOperator extends Operator{
    public PlusOperator() {
        super(0);
    }

    @Override
    public int execute(int x, int y) {
        return x + y;
    }
}
