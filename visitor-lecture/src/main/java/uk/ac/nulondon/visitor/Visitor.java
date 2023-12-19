package uk.ac.nulondon.visitor;

import uk.ac.nulondon.parser.BinaryOperation;
import uk.ac.nulondon.parser.Number;
import uk.ac.nulondon.parser.UnaryOperation;
import uk.ac.nulondon.parser.Variable;

public interface Visitor {

    void visit(BinaryOperation e);

    void visit(UnaryOperation e);

    void visit(Number e);

    void visit(Variable e);
}
