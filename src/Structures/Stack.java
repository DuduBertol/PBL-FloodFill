package Structures;

import java.util.Arrays;

public class Stack<E> {

    private Node<E> top;
    private int size;

    public Stack(){
        this.top = null;
        this.size = 0;
    }

    public void push(E newElement){
        Node<E> newNode = new Node<>(newElement);
        if (isEmpty()){
            top = newNode;
        } else {
            top.setNext(newNode);
            newNode.setPrevious(top);
            top = newNode;
        }
        this.size++;
    }

    public E pop(){
        if (isEmpty()) {
            System.out.println("tem nada aqui");
            throw new RuntimeException();
        } else {
            E elementRemoved = top.getElement();
            if (top.getPrevious() == null) {
                top = null;
            } else {
                top = top.getPrevious();
                top.setNext(null);
            }
            this.size--;
            return elementRemoved;
        }
    }

    public E top(){
        if (isEmpty()) {
            System.out.println("ta vazio :(");
            throw new RuntimeException();
        }
        return (E) top.getElement();
    }

    public boolean isEmpty(){
        if (top == null){
            return true;
        } else {
            return false;
        }
    }

    public int size(){
        return this.size;
    }

    public void clear(E e){
        while (top != null){
            pop();
        }
    }

    public E[] toArray(){
        E[] array = (E[]) new Object[size];
        Node<E> n = top;
        int index = 0;

        while (n != null) {
            array[index] =  n.getElement();
            index += 1;
            n = n.getPrevious();
        }

        E[] invertedArray = (E[]) new Object[size];

        for (int i =0; i < size; i++){
            invertedArray[i] = array[size - 1 -i];
        }

        return invertedArray;
    }

    public String toString(){
        E[] e = this.toArray();
        String toString = Arrays.toString(e);
        return toString;
    }
}
