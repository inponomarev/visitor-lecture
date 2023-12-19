package uk.ac.nulondon;

import uk.ac.nulondon.parser.Element;
import uk.ac.nulondon.parser.SimpleCalculator;
import uk.ac.nulondon.visitor.Interpreter;

import java.util.Map;

public class Calculate {
    public static void main(String[] args) throws Exception {
        //Let's solve x^2 + 2024x + 2023 = 0
        //
        // (roots are -2023 and -1, obviously)
        //

        String script = "(-b - sqrt (b*b- 4*a*c)) / (2 * a)";
        Element expr = SimpleCalculator.parseScript(script);


        //Initialize the visitor and run trans
        Interpreter interpreter = new Interpreter(
                Map.of("a", 1.,
                        "b", 2024.,
                        "c", 2023.)
        );
        expr.accept(interpreter);
        System.out.println(interpreter.result());
    }
}
