import Structures.*;

public class Main {
    public static void main(String[] args) {

        System.out.printf("Hello and welcome! \n");

        MyArrayList<Integer> myArrayList = new MyArrayList<Integer>();

        Stack<String> myStack = new Stack<String>();

        myStack.push("Dudu");
//        myStack.push("Carla");
        myStack.pop();

//        System.out.println(myStack.top().getElement());
        System.out.println(myStack.size());
    }
}