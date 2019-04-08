package ru.job4j.tree;

import java.util.*;

public class MyTree<E extends Comparable<E>> implements SimpleTree<E> {
    private Node<E> root;
    private int modCount;

    public MyTree(E root) {
        this.root = new Node(root);
    }

    @Override
    public boolean add(E parent, E child) {
        boolean rst = false;
        Optional<Node<E>> par = findBy(parent);
        if (par.isPresent()) {
            Optional<Node<E>> childNode = findBy(child);
            if (childNode.isPresent()) {
                par.get().add(new Node<>(child));
                rst = true;
                modCount++;
            }
        }
        return rst;
    }

    @Override
    public Optional<Node<E>> findBy(E value) {
        Optional<Node<E>> rsl = Optional.empty();
        Queue<Node<E>> data = new LinkedList<>();
        data.offer(this.root);
        while (!data.isEmpty()) {
            Node<E> el = data.poll();
            if (el.eqValue(value)) {
                rsl = Optional.of(el);
                break;
            }
            for (Node<E> child : el.leaves()) {
                data.offer(child);
            }
        }
        return rsl;
    }

    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {
            int count = modCount;
            Node<E> node = root;
            Queue<Node<E>> data = new LinkedList<>();

            @Override
            public boolean hasNext() throws ConcurrentModificationException {
                if (count != modCount) {
                    throw new ConcurrentModificationException();
                }
                return node != null;
            }


            @Override
            public E next() throws NoSuchElementException {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                E result;
                for (Node<E> node : node.leaves()) {
                    data.offer(node);
                }
                result = node.getValue();
                node = data.poll();
                return result;
            }
        };
    }

}
