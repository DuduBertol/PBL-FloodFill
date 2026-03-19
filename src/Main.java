import Structures.MyArrayList;

public class Main {
    public static void main(String[] args) {

        System.out.printf("Hello and welcome! \n");

        MyArrayList<Integer> myArrayList = new MyArrayList<Integer>();

        myArrayList.add(1);
        myArrayList.add(2);
        myArrayList.add(3);
        myArrayList.add(4);
        myArrayList.add(5);
        System.out.println(myArrayList);
        System.out.println(myArrayList.size());

        myArrayList.add(6);
        myArrayList.add(7);
        myArrayList.add(8);
        myArrayList.add(9);
        myArrayList.add(10);
        System.out.println(myArrayList);
        System.out.println(myArrayList.size());

//        myArrayList.add(11);
//        System.out.println(myArrayList);
//        System.out.println(myArrayList.size());
//        System.out.println();


        myArrayList.removeAt(8);
        System.out.println(myArrayList);
        System.out.println(myArrayList.size());
        System.out.println();

        myArrayList.add(1, 12);
        System.out.println(myArrayList);
        System.out.println(myArrayList.size());
        System.out.println();

        myArrayList.add(5, 12);
        System.out.println(myArrayList);
        System.out.println(myArrayList.size());
        System.out.println();

        Integer element = myArrayList.get(0);
        System.out.println(element);
        System.out.println();

        myArrayList.set(0, 16);
        System.out.println(myArrayList);
        System.out.println(myArrayList.size());
        System.out.println();

    }
}