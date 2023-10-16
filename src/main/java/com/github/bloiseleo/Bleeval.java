package com.github.bloiseleo;

import com.github.bloiseleo.Operators.MinusOperator;
import com.github.bloiseleo.Operators.Operator;
import com.github.bloiseleo.Operators.PlusOperator;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Stack;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Bleeval {
    private int curr = 0;
    private String expression;
    private final Pattern digitPattern = Pattern.compile("^\\d+$");
    private final HashMap<Character, Operator> operatorHashMap = new HashMap<>();
    {
        operatorHashMap.put('+', new PlusOperator());
        operatorHashMap.put('-', new MinusOperator());
    }
    public Bleeval(String expression) {
        this.expression = expression;
    }
    public String getExpression() {
        return expression;
    }
    public void setExpression(String expression) {
        this.expression = expression;
    }
    private boolean isDigit(char c) {
        Matcher matcher = digitPattern.matcher(String.valueOf(c));
        return matcher.find();
    }
    private char peek(int pos) {
        if(pos >= expression.length()) {
            return 0;
        }
        return expression.charAt(pos);
    }
    private int number() {
        StringBuilder number = new StringBuilder();
        do {
            number.append(expression.charAt(curr));
            curr++;
        } while(isDigit(peek(curr)));
        return Integer.valueOf(number.toString(), 10);
    }
    private boolean isOperator(char c) {
        return  operatorHashMap.containsKey(c);
    }
    private int consume(ArrayList<Operator> operators, ArrayList<Integer> operands) {
        while (!operators.isEmpty()) {
            Operator op = operators.remove(0);
            int x = operands.remove(0);
            int y = operands.remove(0);
            operands.add(0, op.execute(x, y));
        }
        return operands.remove(0);
    }
    public int evaluate() {
        ArrayList<Operator> operators = new ArrayList<>();
        ArrayList<Integer> numbers = new ArrayList<>();
        int qtdChars = expression.length();
        while (curr < qtdChars) {
            char c = expression.charAt(curr);
            if (isDigit(c)) {
                int number = number();
                numbers.add(number);
                continue;
            }
            if (isOperator(c)) {
                Operator op = operatorHashMap.get(c);
                operators.add(op);
                if (curr == 0) {
                    numbers.add(0);
                }
                curr++;
                continue;
            }
            throw new RuntimeException(String.format("Unexpected token '%c' at %d", c, curr));
        }
        reset();
        return consume(operators, numbers);
    }
    private void reset() {
        curr = 0;
    }
}
