package com.company;

public class Node3 {
    public static void main(String[] args) {
        int k = 10;
        Node head = createHead(k);
        toString(head);

        head = createTail(k);
        toString(head);

        Node node = new Node(5, null);
        head = addFirst(node, head);
        toString(head);

        node = new Node(5, null);
        head = addLast(node, head);
        toString(head);

        node = new Node(9, null);
        head = Insert(node, head, 4);
        toString(head);

        head = RemoveFirst(head);
        toString(head);

        head = RemoveLast(head);
        toString(head);

        head = Remove(head, 4);
        toString(head);

        head = createHeadRec(10);
        toString(head);

        head = createTailRec(10, null);
        toString(head);

        System.out.println(toStringRec(head));
    }
    private static Node createHead(int k) {
        Node head = new Node(0, null);
        Node tail = head;

        for (int i = 0; i<(k-1); i++) {
            tail.next = new Node(i+1, null);
            tail = tail.next;

        }
        return head;
    }
    private static Node createTail(int k){
        Node head=null;
        for(int i=(k-1); i>=0; i--){
            head=new Node(i,head);
        }
        return head;
    }
    private static void toString(Node head){
        Node ref=head;
        while (ref!=null){
            System.out.print(" "+ ref.value);
            ref=ref.next;
        }
        System.out.print("\n");
    }
    private static Node addFirst(Node node, Node head){
        node.next=head;
        return node;
    }
    private static Node addLast(Node node, Node head){
        Node ref=head;
        while (ref.next!=null){
            ref=ref.next;
        }
        ref.next=node;
        return head;
    }
    private static Node Insert(Node node, Node head, int n){
        Node ref=head;
        int k=1;
        while(ref.next!=null && (k<n)){
            ref=ref.next;
            k++;
        }
        node.next=ref.next;
        ref.next=node;
        return head;
    }
    private static Node RemoveFirst(Node head) {
        head = head.next;
        return head;
    }
    private static Node RemoveLast(Node head) {
        Node ref = head;
        while (ref.next.next !=null) {
            ref = ref.next;
        }
        ref.next = null;
        return head;
    }
    private static Node Remove(Node head, int n) {
        Node ref = head;
        int k = 1;
        while (ref.next != null && k < (n-1)) {
            ref = ref.next;
            k++;
        }
        ref.next = ref.next.next;
        return head;
    }
    private static Node createHeadRec(int k) {
        if (k>0) {
            return new Node(k, createHeadRec(k-1));
        }
        return new Node(k, null);
    }
    private static Node createTailRec(int k, Node node) {
        if (k>0) {
            k--;
            Node head;
            if (node == null) {
                head = new Node(k, null);

            } else {
                head = new Node(k, node);
            }
            return createTailRec(k, head);
        }
        return node;
    }
    private static String toStringRec(Node head) {
        if (head.next != null) {
            return Integer.toString(head.value) + " " + toStringRec(head.next);
        }
        return Integer.toString(head.value);
    }
}