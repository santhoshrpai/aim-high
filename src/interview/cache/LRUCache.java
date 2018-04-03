package interview.cache;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author rajasan
 */
public class LRUCache {

    class Node {

        private int key;
        private int value;
        Node pre;
        Node next;

        Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    private int capacity;
    Map<Integer, Node> map;
    Node tail;
    Node head;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        map = new HashMap<>(capacity);
        head = null;
        tail = null;
    }

    private void setHead(Node n) {
        head = n;
        tail = n;
        map.put(n.key, n);
    }

    private void remove(Node n) {
        Node pre = n.pre;
        Node next = n.next;

        if (pre != null) {
            pre.next = next;
        } else {
            head = n.next;
        }

        if (next != null) {
            next.pre = pre;
        } else {
            tail = pre;
        }
    }

    public int get(int key) {
        if (map.containsKey(key)) {
            Node n = map.get(key);

            remove(n);

            if (tail != null) {
                tail.next = n;
                tail = tail.next;
            } else {
                setHead(n);
            }

            map.put(key, tail);
            return n.value;
        } else {
            return -1;
        }
    }

    public void put(int key, int value) {
        if (map.size() == 0) {
            Node n = new Node(key, value);
            setHead(n);
            return;
        }

        // if the map already contains the key, remove from its location and append it to the end
        if (map.containsKey(key)) {
            Node n = map.get(key);
            remove(n);
            n.value = value;
            if (tail != null) {
                tail.next = n;
                tail = tail.next;
            } else {
                setHead(n);
            }
            map.put(key, tail);
        }

        //if the map is full, remove the first element, head and append the new node at the end
        if (map.size() == capacity) {
            Node n = new Node(key, value);

            int keyToBeRemoved = head.key;

            Node old = head.next;

            if (old == null) {
                setHead(n);
            } else {

                head = head.next;
                head.pre = null;
            }

            map.remove(keyToBeRemoved);

            tail.next = n;
            n.pre = tail;
            tail = tail.next;
            map.put(key, n);

        } else {
            Node n = new Node(key, value);
            tail.next = n;
            n.pre = tail;
            tail = tail.next;
            map.put(key, n);
        }
    }

    public static void main(String[] args) {

        List<Integer> l = new ArrayList<>();
        //        LRUCache interview.cache = new LRUCache(2 /* capacity */);
        //
        //        interview.cache.put(1, 1);
        //        interview.cache.put(2, 2);
        //        l.add(interview.cache.get(1));       // returns 1
        //        interview.cache.put(3, 3);    // evicts key 2
        //        l.add(interview.cache.get(2));       // returns -1 (not found)
        //        interview.cache.put(4, 4);    // evicts key 1
        //        l.add(interview.cache.get(1));       // returns -1 (not found)
        //        l.add(interview.cache.get(3));       // returns 3
        //        l.add(interview.cache.get(4));       // returns 4

        //        LRUCache c = new LRUCache(1);
        //        c.put(2, 1);
        //        l.add(c.get(2));
        //        c.put(3, 2);
        //        l.add(c.get(2));
        //        l.add(c.get(3));

        LRUCache c = new LRUCache(2);
        l.add(c.get(2));
        c.put(2, 6);
        l.add(c.get(1));
        c.put(1, 5);
        c.put(1, 2);
        l.add(c.get(1));
        l.add(c.get(2));

        //[2],[2],[2,6],[1],[1,5],[1,2],[1],[2]
        //        System.out.println(c.get(2));

        System.out.println(l);
    }
}