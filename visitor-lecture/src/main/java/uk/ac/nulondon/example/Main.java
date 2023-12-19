package uk.ac.nulondon.example;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.function.Function.identity;

public class Main {

    static Map<String, Element> nodes =
            Stream.of("A", "B", "C", "D", "E", "F", "G")
                    .map(Element::new)
                    .collect(Collectors.toMap(Element::getName, identity()));

    static final Graph GRAPH;

    static List<Element> nodes(String... names) {
        return Arrays.stream(names)
                .map(nodes::get)
                .toList();
    }

    static {
        nodes.get("A").adjacent(nodes("B", "E", "G"));
        nodes.get("B").adjacent(nodes("A", "C", "D"));
        nodes.get("C").adjacent(nodes("B"));
        nodes.get("D").adjacent(nodes("B"));
        nodes.get("E").adjacent(nodes("A", "F"));
        nodes.get("F").adjacent(nodes("E", "G"));
        nodes.get("G").adjacent(nodes("A", "F"));

        /*
         *  C --- B --- A --- G
         *        |     |     |
         *        D     E --- F
         */

        GRAPH = new Graph(nodes.get("A"));
    }

    public static void main(String[] args) {
        GRAPH.forEach(node -> System.out.print(node.name + " "));
        System.out.println();
    }
}
