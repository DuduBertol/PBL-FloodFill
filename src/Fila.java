package Structures;

public class Fila {

    private MyArrayList<Point> elementos;

    public Fila() {
        elementos = new MyArrayList<>();
    }

    public void enqueue(Point valor) {
        elementos.add(valor);
    }

    public Point dequeue() {
        if (isEmpty()) {
            throw new RuntimeException("Fila vazia");
        }

        Point valor = elementos.get(0);
        elementos.removeAt(0);
        return valor;
    }

    public boolean isEmpty() {
        return elementos.size() == 0;
    }
}