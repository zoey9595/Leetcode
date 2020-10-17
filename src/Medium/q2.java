package Medium;

import java.util.ArrayList;

public class q2 {
    /**
     * Definition for singly-linked list.
     * public class ListNode {
     * int val;
     * ListNode next;
     * ListNode(int x) { val = x; }
     * }
     */
    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int value = nodeToInt(l1, 0, 0) + nodeToInt(l2, 0, 0);
        String temp = Integer.toString(value);
        ArrayList<ListNode> arrayList = new ArrayList<>();
        for (int i = 0; i < temp.length(); i++) {
            arrayList.add(new ListNode(Character.valueOf(temp.charAt(temp.length() - i - 1))));
        }
        for (int i = 0; i < arrayList.size() - 1; i++) {
            arrayList.get(i).next = arrayList.get(i + 1);
        }
        return arrayList.get(0);
    }

    public int nodeToInt(ListNode node, int power, int output) {
        if (node.next == null) {
            return output + (int) (node.val * Math.pow(10, power));
        } else {
            output += (int) (node.val * Math.pow(10, power));
            power++;
            return nodeToInt(node.next, power, output);
        }
    }


    public static void main(String[] args) {
    }
}
