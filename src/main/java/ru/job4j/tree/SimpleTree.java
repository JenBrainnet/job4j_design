package ru.job4j.tree;

import java.util.LinkedList;
import java.util.Optional;
import java.util.Queue;
import java.util.function.Predicate;

public class SimpleTree<E> implements Tree<E> {

    private final Node<E> root;

    public SimpleTree(final E root) {
        this.root = new Node<>(root);
    }

    @Override
    public boolean add(E parent, E child) {
        Optional<Node<E>> parentNode = findBy(parent);
        boolean result = parentNode.isPresent() && findBy(child).isEmpty();
        if (result) {
            parentNode.get().children.add(new Node<>(child));
        }
        return result;
    }

    @Override
    public Optional<Node<E>> findBy(E value) {
        Predicate<Node<E>> condition = node -> node.value.equals(value);
        return findByPredicate(condition);
    }

    @Override
    public boolean isBinary() {
        Predicate<Node<E>> condition = node -> node.children.size() > 2;
        return findByPredicate(condition).isEmpty();
    }

    private Optional<Node<E>> findByPredicate(Predicate<Node<E>> condition) {
        Optional<Node<E>> result = Optional.empty();
        Queue<Node<E>> queue = new LinkedList<>();
        queue.offer(this.root);
        while (!queue.isEmpty()) {
            Node<E> element = queue.poll();
            if (condition.test(element)) {
                result = Optional.of(element);
                break;
            }
            queue.addAll(element.children);
        }
        return result;
    }

}
