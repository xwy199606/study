package com.example.study.problems;

import com.example.study.po.ListNode;

import java.util.HashSet;
import java.util.Set;

/**
 * @author eric.xiong
 * @date 2024/5/31 15:52
 */
public class ListNodeLearn {

    /**
     * 反转链表
     *
     * 链表的末尾指针一定是null
     *
     * 假设链表为 1→2→3→∅，我们想要把它改成 ∅←1←2←3
     * @param head
     * @return
     */
    public static ListNode revert(ListNode head) {
       ListNode prev = null;
       ListNode curr = head;
       while (curr != null) {
           ListNode next = curr.next;
           curr.next = prev;
           prev = curr;
           curr = next;
       }

       return prev;
    }

    /**
     * 删除链表中的重复元素
     * 1 -> 2 -> 3 -> 2 -> 4 -> 3 -> 5 变为 1 -> 2 -> 3 -> 4 -> 5
     */
    public static ListNode delDupNode(ListNode head) {
        if (head == null) {
            return head;
        }

        ListNode curr = head;
        Set<Integer> set = new HashSet<>();
        set.add(curr.value);
        while (curr != null) {
            if (set.contains(curr.next.value)) {
                curr = curr.next.next;
            } else {
                set.add(curr.value);
                curr = curr.next;
            }
        }

        return head;
    }

    /**
     * 删除有序链表中的重复元素
     * 1 -> 2 -> 3 -> 3 -> 4 -> 4 -> 5 变为 1 -> 2 -> 3 -> 4 -> 5
     */
    public static ListNode delDupNode1(ListNode head) {
        if (head == null) {
            return head;
        }

        ListNode curr = head;
        while (curr.next != null) {
            if (curr.value == curr.next.value) {
                curr.next = curr.next.next;
            } else {
                curr = curr.next;
            }
        }

        return head;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(2);
        head.next.next.next = new ListNode(3);
        head.next.next.next.next = new ListNode(4);
        head.next.next.next.next.next = new ListNode(4);
        head.next.next.next.next.next.next = new ListNode(5);

//        ListNode res = revert(head);
        ListNode res = delDupNode1(head);
        while (res != null) {
            System.out.print(res.value + " ");
            res = res.next;
        }
    }
}