package com.example.study.po;

import lombok.Data;

/**
 * @author eric.xiong
 * @date 2024/5/31 15:38
 */
public class ListNode {
    public int value;
    public ListNode next;

    public ListNode(int value) {
     this.value = value;
     this.next = null;
    }

}
