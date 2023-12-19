package uk.ac.nulondon.parser;

import uk.ac.nulondon.visitor.Visitor;

public record Variable(String name) implements Element {

    @Override
    public void accept(Visitor v) {
        v.visit(this);
    }
}
