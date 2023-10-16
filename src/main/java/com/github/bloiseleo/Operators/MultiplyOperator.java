package com.github.bloiseleo.Operators;

public class MultiplyOperator extends Operator{

    public MultiplyOperator() {
        super(1);
    }

    @Override
    public int execute(int x, int y) {
        return x * y;
    }
}
