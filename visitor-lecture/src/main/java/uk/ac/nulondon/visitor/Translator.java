package uk.ac.nulondon.visitor;

import uk.ac.nulondon.parser.BinaryOperation;
import uk.ac.nulondon.parser.Element;
import uk.ac.nulondon.parser.Number;
import uk.ac.nulondon.parser.UnaryOperation;
import uk.ac.nulondon.parser.Variable;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.IdentityHashMap;
import java.util.function.Consumer;

public class Translator implements Visitor, Consumer<Element> {
    private final StringWriter sw = new StringWriter();
    private final PrintWriter pw = new PrintWriter(sw);
    private final IdentityHashMap<Object, Integer> identityHashMap = new IdentityHashMap<>();
    private int identityCount = 0;
    public Translator() {
        pw.println("digraph G {");
    }

    @Override
    public void visit(BinaryOperation e) {
        pw.printf("  %s[label=\"%s\",shape=box];%n",
                id(e),
                e.operator().getSymbol());
        pw.printf("  %s -> %s;%n", id(e), id(e.left()));
        pw.printf("  %s -> %s;%n", id(e), id(e.right()));
    }


    @Override
    public void visit(UnaryOperation e) {
        pw.printf("  %s[label=\"%s\",shape=hexagon];%n",
                id(e),
                e.operator().getSymbol());
        pw.printf("  %s -> %s;%n", id(e), id(e.operand()));
    }

    @Override
    public void visit(Number e) {
        pw.printf("  %s[label=\"%s\"];%n",
                id(e),
                e.value());
    }

    @Override
    public void visit(Variable e) {
        pw.printf("  %s[label=\"%s\"];%n",
                id(e),
                e.name());
    }


    private String id(Element element) {
        //Generating a valid DOT node identifier
        return Integer.toString(
                        identityHashMap.computeIfAbsent(element, e -> ++identityCount)
                        , Character.MAX_RADIX);
    }

    public String result() {
        return sw + String.format("}%n");
    }

    @Override
    public void accept(Element expr) {
        //Switch+pattern matching calls the right version of "visit"
        switch (expr) {
            case BinaryOperation e -> visit(e);
            case UnaryOperation e -> visit(e);
            case Number e -> visit(e);
            case Variable e -> visit(e);
        }
    }
}
