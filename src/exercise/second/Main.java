package exercise.second;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Collections;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        System.out.println("Problem 21. Merge Two Sorted Lists\n");

        //Input
        ListNode list1_1 = new ListNode(1, new  ListNode(2,  new  ListNode(4)));
        ListNode list1_2 = new ListNode(1,  new  ListNode(3,  new  ListNode(4)));
        ListNode list2_1 = new ListNode();
        ListNode list2_2 = new ListNode();
        ListNode list3_1 = new ListNode();
        ListNode list3_2 = new ListNode(0);

        //Case 1
        System.out.println("Case 1:");
        System.out.print("List 1: ");
        printList(list1_1);
        System.out.print("List 2: ");
        printList(list1_2);
        System.out.print("Solution: ");
        printList(Solution.sortedAndUnitedLinkedList(list1_1, list1_2));

        //Case 2
        System.out.println("Case 1:");
        System.out.print("List 1: ");
        printList(list2_1);
        System.out.print("List 2: ");
        printList(list2_2);
        System.out.print("Solution: ");
        printList(Solution.sortedAndUnitedLinkedList(list2_1, list2_2));

        //Case 3
        System.out.println("Case 1:");
        System.out.print("List 1: ");
        printList(list3_1);
        System.out.print("List 2: ");
        printList(list3_2);
        System.out.print("Solution: ");
        printList(Solution.sortedAndUnitedLinkedList(list3_1, list3_2));

        //Same tests via built classes LinkedList & Collections
        System.out.println("\nSame tests via built classes LinkedList & Collections\n");
        //Inputs
        LinkedList<Integer> linkedList1_1 = new LinkedList<>(Arrays.asList(1, 2, 4)); //Arrays.asList() creates an array of fixed length of varargs
        LinkedList<Integer> linkedList1_2 = new LinkedList<>(Arrays.asList(1, 3, 4));
        LinkedList<Integer> linkedList2_1 = new LinkedList<>();
        LinkedList<Integer> linkedList2_2 = new LinkedList<>();
        LinkedList<Integer> linkedList3_1 = new LinkedList<>();
        LinkedList<Integer> linkedList3_2 = new LinkedList<>(Arrays.asList(0));

        //Case 1
        System.out.println("Case 1:");
        System.out.println("List 1: " + linkedList1_1);
        System.out.println("List 2: " + linkedList1_2);
        // Unite linkedList1 with linkedList2
        LinkedList<Integer> merged1 = new LinkedList<>(linkedList1_1);
        merged1.addAll(linkedList1_2);
        // Sorting united list
        Collections.sort(merged1);
        System.out.println("Solution: " + merged1);

        //Case 2
        System.out.println("Case 2:");
        System.out.println("List 1: " + linkedList2_1);
        System.out.println("List 2: " + linkedList2_2);
        // Unite linkedList1 with linkedList2
        LinkedList<Integer> merged2 = new LinkedList<>(linkedList2_1);
        merged2.addAll(linkedList2_2);
        // Sorting united list
        Collections.sort(merged2);
        System.out.println("Solution: " + merged2);

        //Case 3
        System.out.println("Case 3:");
        System.out.println("List 1: " + linkedList3_1);
        System.out.println("List 2: " + linkedList3_2);
        // Unite linkedList1 with linkedList2
        LinkedList<Integer> merged3 = new LinkedList<>(linkedList3_1);
        merged3.addAll(linkedList3_2);
        // Sorting united list
        Collections.sort(merged3);
        System.out.println("Solution: " + merged3);
    }

    //Prints out linked list as normal array
    public static void printList(ListNode head) {
        ArrayList<Integer> arr = new ArrayList<>();

        while (head != null) {
            arr.add(head.val);
            head = head.next;
        }

        System.out.print(arr);
        System.out.print("\n");
    }
}
