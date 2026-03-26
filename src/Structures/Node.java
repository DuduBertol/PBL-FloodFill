package Structures;

public class Node<E> {
    private E element;
    private Node next;
    private Node previous;

    public Node(E e){
        this.element = e;
    }

    public Node getNext(){
        return next;
    }

    public void setNext(Node n){
        this.next = n;
    }

    public Node getPrevious(){
        return previous;
    }

    public void setPrevious(Node n){
        this.previous = n;
    }

    public E getElement(){
        return this.element;
    }

    public void setElement(E e){
        this.element = e;
    }
}
