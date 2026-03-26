package Structures;

public class Stack<E> {

    private Node<E> top;
    private int size;

    public Stack(){
        this.top = null;
        this.size = 0;
    }

    public Stack(E element){
        top = new Node<>(element);
        size = 1;
    }

    //adiciona ao fim da pilha
    //referenciar o previous
    //colocar o next
    public void push(E newElement){
        Node newNode = new Node(newElement);
        if (isEmpty()){
            top = newNode;
        } else {
            top.setNext(newNode);
            newNode.setPrevious(top);
            top = newNode;
        }

        size++;
    }

    public E pop(){
        if (isEmpty()) {
            throw new RuntimeException();
        }

        E elementRemoved = top.getElement();
        top = top.getPrevious();
        size--;
        return elementRemoved;
    }


    public Node top(){
        return top;
    }

    public boolean isEmpty(){
        if (top == null){
            return true;
        } else {
            return false;
        }
    }

    public int size(){
        Node n = top;
        int contador = 0;
        while (n != null){
            contador += 1;
            n = n.getPrevious();
        }
        size = contador;

        return contador;
    }

    public void clear(E e){
        top = null;
    }

//    public Node[] toArray(){
//        return toArray;
//    }
//
//    public String toString(){
//        return toString;
    //    Arrays.toString(elements);
//    }


    //last in first out
    //push

    //pop

}
