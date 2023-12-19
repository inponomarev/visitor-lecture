package uk.ac.nulondon.example;

import lombok.RequiredArgsConstructor;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashSet;
import java.util.Set;
import java.util.function.Consumer;

@RequiredArgsConstructor
public class Graph {
    private final Element root;

    public void forEach(Consumer<? super Element> visitor) {
        Set<Object> visited = new HashSet<>();
        root.accept(visited, visitor);
//        Deque<Element> deque = new ArrayDeque<>();
//        Element e = root;
//        do {
//            if (visited.add(e)) {
//                visitor.accept(e);
//                for (Element n : e.adjacent) {
//                    deque.addFirst(n);
//                }
//            }
//            e = deque.pollFirst();
//        } while (e != null);
    }
}
