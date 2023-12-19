package uk.ac.nulondon;

import uk.ac.nulondon.parser.Element;
import uk.ac.nulondon.parser.SimpleCalculator;
import uk.ac.nulondon.visitor.Translator;

import java.awt.*;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URLEncoder;

public final class Visualize {
    private Visualize() {
    }

    public static void main(String[] args) throws Exception {
        // String script = "a + b + c * d" ;
        String script = "(-b - sqrt (b*b- 4*a*c)) / (2 * a)";

        Element expr = SimpleCalculator.parseScript(script);

        //Initialize the visitor and run transformation
        Translator translator = new Translator();
        expr.accept(translator);
        show(translator.result());
    }

    private static void show(String dot) throws IOException, URISyntaxException {
        String encoded = URLEncoder.encode(dot, "UTF8")
                .replaceAll("\\+", "%20");
        Desktop.getDesktop().browse(
                new URI("https://dreampuf.github.io/GraphvizOnline/#"
                        + encoded));
    }

}
