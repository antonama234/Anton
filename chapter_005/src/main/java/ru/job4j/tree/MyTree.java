package ru.job4j.tree;

import java.util.*;

public class MyTree<E extends Comparable<E>> implements SimpleTree<E> {
    private Node<E> root;
    private int modCount;

    public MyTree(E root) {
        this.root = new Node(root);
    }

    public boolean isBinary() {
        boolean rst = true;
        Iterator<Node<E>> it = iterator();
        while(it.hasNext()) {
            if (it.next().leaves().size() > 2) {
                rst = false;
            }
        }
        return rst;
    }

    @Override
    public boolean add(E parent, E child) {
        boolean rst = false;
        Optional<Node<E>> par = findBy(parent);
        if (par.isPresent()) {
            Optional<Node<E>> childNode = findBy(child);
            if (!childNode.isPresent()) {
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
    public Iterator<Node<E>> iterator() {
        return new Iterator<>() {
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
            public Node<E> next() throws NoSuchElementException {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                Node<E> result;
                for (Node<E> node : node.leaves()) {
                    data.offer(node);
                }
                result = node;
                node = data.poll();
                return result;
            }
        };
    }

}
