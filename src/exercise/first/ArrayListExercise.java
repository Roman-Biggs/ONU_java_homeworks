package org.example;

import java.util.ArrayList;   //Import the ArrayList class
import java.util.Collections; // Import the Collections class

public class ArrayListExercise {

    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<String>(); //Created new collection
        //Adding some colors in the collection
        list.add("red");
        list.add("green");
        list.add("blue");
        list.add("orange");
        list.add("yellow");
        list.add("purple");
        list.add("white");

        //Printing out the collection
        System.out.println("Given list:");
        System.out.println(listIteration(list));
        //Added new item on the first place in collection
        list.add(0,"pink");
        System.out.println("Added new item on the first place in collection:");
        System.out.println(list);

        //Printing put the item in collection by index
        System.out.println("\nElement by index 0: " + list.get(0) + "\n");

        //retrieve an element (at a specified index) from a given array list
        list.set(2, "black");
        System.out.println("Replacing 3-d element as 'black':");
        System.out.println(list);

        //Remove 3-d element from collection
        list.remove(2);
        System.out.println("Removed 3-d element from list:");
        System.out.println(list);

        //Find the index of element in collection
        System.out.println("\n" + "Orange has index " + list.indexOf("orange") + "\n");

        //Sorting our list as collection
        Collections.sort(list);
        System.out.println("Sorted list:");
        System.out.println(list);

        //Cloning list into listClone
        ArrayList<String> listClone = (ArrayList<String>)list.clone(); //cloning list
        Collections.reverse(listClone);
        System.out.println("\n" + "Reversed list:");
        System.out.println(listClone);

        //compare two array lists (equals)
        System.out.println("\n" + "Comparison of both lists");
        System.out.println(list);
        System.out.println(listClone);
        System.out.println("Both lists are equal: " + list.equals(listClone) + "\n");

        //empty an array list (clear) and check if it is empty (isEmpty)
        list.clear();
        System.out.println("List cleared: " + list.isEmpty() + "\n");

        //increase the size of an array list
        list.add("red");
        System.out.println("Added one colour -> now capacity is: " + list.size() + "\n");

        //trim the capacity of an array list the current list size (trimToSize)
        list.trimToSize();

    }

    //Iterate through all elements in a array list
    public static String listIteration(ArrayList<String> list){
        String str = "";
        for (String s : list){
            str = str + s + " ";
        }
        return str;
    }

}