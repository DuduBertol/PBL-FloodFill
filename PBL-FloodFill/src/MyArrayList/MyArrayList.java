package MyArrayList;

import java.util.Arrays;

public class MyArrayList<T>{
    private Object[] elements;
    private int size = 0;

    ///INITIALIZERS
    public MyArrayList() {
        this.elements = new Object[10];
    }

    public MyArrayList(int capacity) {
        this.elements = new Object[capacity];
    }

    ///PUBLIC FUNCTIONS
    public void add(T element) {
        checkIfNeedResize();

        elements[size] = element; //armazena no último lugar
        size++; //aumenta o length (que é o index do último elemento)
    }

    public void add(int index, T element) {
        checkIfIndexOutOfBounds(index);
        checkIfNeedResize();

        if (elements[index] != null) {
            for (int i = size - 1; i >= index; i--) { //i do size de trás pra frente
                elements[i + 1] = elements[i];//vamos jogar todos os elementos pra direita 1
            }
        }
        elements[index] = element;
        size++;
    }

    public int size() {
        return size;
    }

    public void set(int index, T element) {
        checkIfIndexOutOfBounds(index);

        elements[index] = element;
    }

    public T get(int index) {
        checkIfIndexOutOfBounds(index);
        return (T) elements[index];
    }

    public void removeAt(int index) {
        checkIfIndexOutOfBounds(index);

        elements[index] = null;
        for (int i = index; i < size - 1; i++) { //i recebe index pq é onde removeu
            elements[i] = elements[i + 1];//vamos jogar todos os elementos pra esquerda
        }
        elements[size - 1] = null;
        size--;
    }

    public boolean remove(T element) {
        if(contains(element)) {
            removeAt(indexOf(element));
            return true;
        }
        return false;
    }

    public boolean contains(T element) {
        return indexOf(element) >= 0;
    }

    public int indexOf(T element) {
        for (int i = 0; i < size; i++) {
            if(elements[i] == element) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public String toString() {
        return Arrays.toString(elements);
    }

    ///PRIVATE FUNCTIONS

    private void checkIfNeedResize() {
        if (size == elements.length) {
            resize((int)(elements.length * 1.5));
        }
    }

    private void resize(int newSize) {
        Object[] newElements;
        newElements = Arrays.copyOf(elements, newSize);

        elements = newElements;
    }

    private void checkIfIndexOutOfBounds(int index) {
        if(index < 0 || index > size) {
            throw new IndexOutOfBoundsException();
        }
    }
}
