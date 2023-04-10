package module_one;

    /*
        You are given the heads of two sorted linked lists list1 and list2.
        Merge the two lists in a one sorted list. The list should be made by splicing together the nodes of the first two lists.
        Return the head of the merged linked list.
    */
public class Solution21 {

    /*
        Для решения задачи используем рукурсию. Сравниваем значения в   текущих узлав.
        Если значение в первом списке меньше, вызываем mergeTwoLists для следующего узла в первом списке
        и оставшейся части второго списка, и присваиваем результат next узлу первого списка.
        Если значение в первом списке больше или равно, мы вызываем mergeTwoLists для первого списка
        и следующего узла второго списка, и присваиваем результат next узлу второго списка.
        Продолжаем рекурсивно вызывать mergeTwoLists, пока один из списков не закончится,
        а затем просто присваиваем оставшиеся узлы второго списка.
    */

    static ListNode mergeTwoLists(ListNode list1, ListNode list2) {

        // проверим крайние случаи
        if (list1 == null) return list2;
        if (list2 == null) return list1;

        //Если значение в первом списке меньше, вызываем mergeTwoLists для следующего узла в первом списке
        //и оставшейся части второго списка, и присваиваем результат next узлу первого списка.
        if (list1.val < list2.val) {
            list1.next = mergeTwoLists(list1.next, list2);
            return list1;
            //Если значение в первом списке больше или равно, мы вызываем mergeTwoLists для первого списка
            //и следующего узла второго списка, и присваиваем результат next узлу второго списка.
        } else {
            list2.next = mergeTwoLists(list1, list2.next);
            return list2;
        }

    }

    public static void main(String[] args) {
        ListNode head1 = new ListNode(1);
        head1.next = new ListNode(2);
        head1.next.next = new ListNode(4);
        head1.next.next.next = new ListNode(7);
        head1.next.next.next.next = new ListNode(7);
        ListNode head2 = new ListNode(1);
        head2.next = new ListNode(3);
        head2.next.next = new ListNode(4);
        printList(mergeTwoLists(head1, head2));

        printList(mergeTwoLists(null, null));

        head2 = new ListNode(0);
        printList(mergeTwoLists(null, head2));
    }

    private static void printList(ListNode mergedList) {
        while (mergedList != null) {
            System.out.print(mergedList.val + " ");
            mergedList = mergedList.next;
        }
        System.out.println();
    }

    static class ListNode {
        int val;
        ListNode next;

        ListNode(int val) {
            this.val = val;
        }
    }
}
