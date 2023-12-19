package uk.ac.nulondon.parser;

import uk.ac.nulondon.visitor.Visitor;

public sealed interface Element permits
        BinaryOperation,
        UnaryOperation,
        Number,
        Variable {
       void accept(Visitor v);
    //   void accept(Consumer<? super Expr> v);
}


