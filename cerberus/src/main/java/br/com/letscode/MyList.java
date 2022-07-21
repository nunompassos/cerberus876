package br.com.letscode;

import java.util.*;
import java.util.function.IntFunction;
import java.util.function.Predicate;
import java.util.stream.Stream;

public class MyList<E extends Comparable> implements Collection<E> {

    ArrayList<E> array = new ArrayList();

    @Override
    public int size() {
        return array.size();
    }

    @Override
    public boolean isEmpty() {
        return array.isEmpty();
    }

    @Override
    public boolean contains(Object o) {
        return array.contains(o);
    }

    @Override
    public Iterator<E> iterator() {
        return array.iterator();
    }

    @Override
    public Object[] toArray() {
        return array.toArray();
    }

    @Override
    public <T> T[] toArray(T[] a) {
        return null;
    }

    @Override
    public <T> T[] toArray(IntFunction<T[]> generator) {
        return Collection.super.toArray(generator);
    }

    @Override
    public boolean add(E e) {
        array.add(e);
        Collections.sort(array);
        return false;
    }

    @Override
    public boolean remove(Object o) {
        // Not Implemented
        return false;
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean addAll(Collection<? extends E> c) {
        return false;
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean removeIf(Predicate<? super E> filter) {
        return Collection.super.removeIf(filter);
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        return false;
    }

    @Override
    public void clear() {

    }

    @Override
    public Spliterator<E> spliterator() {
        return Collection.super.spliterator();
    }

    @Override
    public Stream<E> stream() {
        return Collection.super.stream();
    }

    @Override
    public Stream<E> parallelStream() {
        return Collection.super.parallelStream();
    }

    public E get() {
        return array.get(0);
    }
}
