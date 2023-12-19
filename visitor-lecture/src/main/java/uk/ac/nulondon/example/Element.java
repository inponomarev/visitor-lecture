package uk.ac.nulondon.example;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.function.Consumer;

@RequiredArgsConstructor
public class Element {
    @Getter
    final String name;
    final List<Element> adjacent = new ArrayList<>();

    public void adjacent(List<Element> nodes) {
        adjacent.addAll(nodes);
    }

    void accept(Set<Object> visited, Consumer<? super Element> visitor) {
        if (visited.add(this)) {
            for (Element node : adjacent.reversed()) {
                node.accept(visited, visitor);
            }
            visitor.accept(this);
        }
    }

}
