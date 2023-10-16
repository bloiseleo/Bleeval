package com.github.bloiseleo.Operators;

public class MinusOperator extends Operator{
    public MinusOperator() {
        super(0);
    }

    @Override
    public int execute(int x, int y) {
        return x - y;
    }
}
