package uk.ac.nulondon.parser;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import uk.ac.nulondon.visitor.Visitor;

public record UnaryOperation(Operator operator, Element operand) implements Element {

    @Override
    public void accept(Visitor v) {
        operand.accept(v);
        v.visit(this);
    }

    @Getter
    @RequiredArgsConstructor
    public enum Operator {
        NEGATE('-'), SQUARE_ROOT('√');
        final char symbol;
    }

}
