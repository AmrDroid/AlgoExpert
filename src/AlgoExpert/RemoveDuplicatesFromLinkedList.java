package AlgoExpert;

import java.util.HashMap;

public class RemoveDuplicatesFromLinkedList {
    public static class LinkedList {
        public int value;
        public LinkedList next;

        public LinkedList(int value) {
            this.value = value;
            this.next = null;
        }
    }

    //O(n) time | O(1) space, where n is the number of nodes in the Linked List.
    public static LinkedList removeDub(LinkedList list) {

        if (list == null || list.next == null) return list;

        LinkedList temp;
        LinkedList head = list;
        temp = head;

        while (head.next != null) {
            if (head.value == head.next.value)
                head.next = head.next.next;
            else
                head = head.next;
        }
        return temp;
    }


    public static LinkedList removeDub2(LinkedList list) {
        if (list == null || list.next == null) return list;

        //1  2  2  3  4
        LinkedList temp;
        LinkedList head = list;
        temp=head;
        while (head != null) {
            LinkedList nextDistinctNode = head.next;
            while (nextDistinctNode != null && nextDistinctNode.value == head.value)
            {
                nextDistinctNode = nextDistinctNode.next;
            }

            head.next = nextDistinctNode;
            head = nextDistinctNode;
        }

        return temp;
    }

    public static void main(String[] args) {
        LinkedList list1 = new LinkedList(1);
        LinkedList list2 = new LinkedList(2);
        LinkedList list3 = new LinkedList(2);
        LinkedList list4 = new LinkedList(4);
        LinkedList list5 = new LinkedList(5);
        list1.next = list2;
        list2.next = list3;
        list3.next = list4;
        list4.next = list5;

        LinkedList newList = removeDub(list1);

        while (newList != null) {
            System.out.print(newList.value + "  ");
            newList = newList.next;
        }

        System.out.println();


        LinkedList newList2 = removeDub2(list1);

        while (newList2 != null) {
            System.out.print(newList2.value + "  ");
            newList2 = newList2.next;
        }
        System.out.println();
    }



}
