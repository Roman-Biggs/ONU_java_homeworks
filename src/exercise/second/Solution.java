package exercise.second;

public class Solution {

    public static ListNode sortedAndUnitedLinkedList(ListNode list1, ListNode list2) {
        if (list1 == null) {
            return list2;
        }
        if (list2 == null) {
            return list1;
        }

        //At this moment list1 and list2 pointers are not nullptr

        ListNode dummyptr = new ListNode(); //New united and sorted list
        ListNode currptr = dummyptr;

        //Merging and uniting
        while (list1 != null && list2 != null) {
            if (list1.val <= list2.val) {
                currptr.next = new ListNode(list1.val);
                list1 = list1.next;
            }
            else {
                currptr.next = new ListNode(list2.val);
                list2 = list2.next;
            }
            currptr = currptr.next;
        }

        //Adding remain node
        if (list1 != null) {
            currptr.next = list1;
        } else {
            currptr.next = list2;
        }

        return dummyptr.next;
    }

}
