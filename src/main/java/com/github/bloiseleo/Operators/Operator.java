package com.github.bloiseleo.Operators;

public abstract class Operator implements Comparable<Operator> {
    private int precedence;
    public Operator(int precedence) {
        this.precedence = precedence;
    }
    abstract public int execute(int x, int y);

    @Override
    public int compareTo(Operator o) {
        return Integer.compare(precedence, o.precedence);
    }
}
