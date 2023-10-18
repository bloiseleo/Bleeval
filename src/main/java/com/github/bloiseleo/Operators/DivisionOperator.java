package com.github.bloiseleo.Operators;

public class DivisionOperator extends Operator{
    public DivisionOperator() {
        super(1);
    }
    @Override
    public int execute(int x, int y) {
        return x / y;
    }
}
