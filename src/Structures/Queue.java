package Structures;

public class Queue<E> {

    private Node<E> first;
    private Node<E> top;
    private int size;

    public Queue(Node<E> top, int size) {
        this.first = top;
        this.top = top;
        this.size = size;
    }

    public Queue() {
        top = first = null;
        size = 0;
    }

    public void enqueue(E element) {
        Node<E> node = new Node<>(element);

        if (isEmpty()) {
            first = node;
            top = node;
            size++;

        } else {
            first.setNext(node);
            first = node;
            size++;
        }
    }

    public E dequeue(){
        if (isEmpty()){
            System.out.println("Queue is empty");
            throw new RuntimeException();
        }

        E element = top.getElement();
        top = top.getNext();

        if (top == null){
            first = null;
        }
        size--;
        return element;
    }

    public Node front(){
        return top;
    }

    public boolean isEmpty(){
        if (first == null){
            return true;
        } else {
            return false;
        }
    }

    public int size(){ return size;}

    public void clear(E e){
        first = null;
    }

    //Carla - faz o toString() e o toArray() pls

}