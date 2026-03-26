package Structures;

public class Queue<E> {

    private MyArrayList<E> elementos;

    public Queue() {
        elementos = new MyArrayList<>();
    }

    public void enqueue(E valor) {
        elementos.add(valor);
    }

    public E dequeue() {
        if (isEmpty()) {
            throw new RuntimeException("Empty queue");
        }

        E valor = elementos.get(0);
        elementos.removeAt(0);
        return valor;
    }

    public boolean isEmpty() {
        return elementos.size() == 0;
    }
}