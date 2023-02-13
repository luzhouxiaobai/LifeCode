package org.asmoc.algorithm;

import java.util.HashMap;

class ListNode {
    int key;
    int val;
    ListNode next;
    ListNode prev;

    ListNode(int key, int val) {
        this.key = key;
        this.val = val;
    }
}

public class LRUCache {

    int size;
    HashMap<Integer, ListNode> cache;
    ListNode head;
    ListNode tail;

    public LRUCache(int capacity) {
        size = capacity;
        cache = new HashMap<>();

        head = new ListNode(-1, -1);
        tail = new ListNode(-1, -1);

        head.next = tail;
        head.prev = null;

        tail.next = null;
        tail.prev = head;
    }

    public int get(int key) {

        if (!cache.containsKey(key)) {
            return -1;
        }

        ListNode node = cache.get(key);
        moveNodeToHead(node, node.val);
        return node.val;

    }

    public void put(int key, int value) {

        if (cache.containsKey(key)) {
            moveNodeToHead(cache.get(key), value);
        } else {

            ListNode node = new ListNode(key, value);
            if (cache.size() >= size) {
                ListNode toDel = tail.prev;
                deleteNode(toDel);
                cache.remove(toDel.key, toDel);
            }
            insertHead(node);
            cache.put(key, node);
        }
    }

    public void moveNodeToHead(ListNode node, int val) {
        deleteNode(node);
        node.val = val;
        insertHead(node);
    }

    public void deleteNode(ListNode node) {
        ListNode prevNode = node.prev;
        ListNode nextNode = node.next;

        prevNode.next = nextNode;
        nextNode.prev = prevNode;
    }

    public void insertHead(ListNode node) {
        node.next = head.next;
        head.next = node;
        node.prev = head;
        node.next.prev = node;
    }

}
