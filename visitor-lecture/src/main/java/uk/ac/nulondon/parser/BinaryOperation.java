package uk.ac.nulondon.parser;


import lombok.Getter;
import lombok.RequiredArgsConstructor;
import uk.ac.nulondon.visitor.Visitor;

public record BinaryOperation(Operator operator, Element left, Element right)
        implements Element {

    @Override
    public void accept(Visitor v) {
        left.accept(v);
        right.accept(v);
        v.visit(this);
    }

    @Getter
    @RequiredArgsConstructor
    public enum Operator {
        ADD('+'), SUBTRACT('−'), MULTIPLY('×'), DIVIDE('÷');
        private final char symbol;
    }

}
