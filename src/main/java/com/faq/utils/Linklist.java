package com.faq.utils;

 class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
    public ListNode(){
        this.val = 0;
    }
}

public class Linklist {
    int size;
    ListNode head;  // sentinel node as pseudo-head
    public Linklist() {
        size = 0;
        head = new ListNode(0);
    }

    /** Get the value of the index-th node in the linked list. If the index is invalid, return -1. */
    public int get(int index) {
        // if index is invalid
        if (index < 0 || index >= size) return -1;

        ListNode curr = head;
        // index steps needed
        // to move from sentinel node to wanted index
        for(int i = 0; i < index + 1; ++i) curr = curr.next;
        return curr.val;
    }
    public ListNode rever(){
       return this.reverseList(this.head);
    }

    public ListNode reverseList(ListNode head) {
        //终止条件
        if (head == null || head.next == null)
            return head;
        //保存当前节点的下一个结点
        ListNode next = head.next;
        //从当前节点的下一个结点开始递归调用
        ListNode reverse = reverseList(next);
        //reverse是反转之后的链表，因为函数reverseList
        // 表示的是对链表的反转，所以反转完之后next肯定
        // 是链表reverse的尾结点，然后我们再把当前节点
        //head挂到next节点的后面就完成了链表的反转。
        next.next = head;
        //这里head相当于变成了尾结点，尾结点都是为空的，
        //否则会构成环
        head.next = null;
        return reverse;
    }
    /** Add a node of value val before the first element of the linked list. After the insertion, the new node will be the first node of the linked list. */
    public void addAtHead(int val) {
        addAtIndex(0, val);
    }

    /** Append a node of value val to the last element of the linked list. */
    public void addAtTail(int val) {
        addAtIndex(size, val);
    }

    /** Add a node of value val before the index-th node in the linked list. If index equals to the length of linked list, the node will be appended to the end of linked list. If index is greater than the length, the node will not be inserted. */
    public void addAtIndex(int index, int val) {
        // If index is greater than the length,
        // the node will not be inserted.
        if (index > size) return;

        // [so weird] If index is negative,
        // the node will be inserted at the head of the list.
        if (index < 0) index = 0;

        ++size;
        // find predecessor of the node to be added
        ListNode pred = head;
        for(int i = 0; i < index; ++i) pred = pred.next;

        // node to be added
        ListNode toAdd = new ListNode(val);
        // insertion itself
        toAdd.next = pred.next;
        pred.next = toAdd;
    }

    /** Delete the index-th node in the linked list, if the index is valid. */
    public void deleteAtIndex(int index) {
        // if the index is invalid, do nothing
        if (index < 0 || index >= size) return;

        size--;
        // find predecessor of the node to be deleted
        ListNode pred = head;
        for(int i = 0; i < index; ++i) pred = pred.next;

        // delete pred.next
        pred.next = pred.next.next;
    }
}
