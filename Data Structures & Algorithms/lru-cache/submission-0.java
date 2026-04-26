class LRUCache {
    class ListNode {
        int val;
        int key;
        ListNode next;
        ListNode prev;

        public ListNode(int val, int key) {
            this.val = val;
            this.key = key;
            next = null;
            prev = null;
        }
    }
    HashMap<Integer, ListNode> map = new HashMap<>();
    ListNode head;
    ListNode tail;
    int capacity;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        head = new ListNode(0, 0);
        tail = new ListNode(0, 0);
        head.next = tail;
        tail.prev = head;
    }

    public int get(int key) {
        if (map.containsKey(key)) {
            ListNode node = map.get(key);
            removeNode(node);
            insertAtTail(node);
            return node.val;
        }
        // else return -1;
        else {
            return -1;
        }
    }

    // head->1->2->3->4->null
    public void put(int key, int value) {
        //if key already exists:
        if (map.containsKey(key)) {
            ListNode node = map.get(key);
            node.val = value;
            map.put(key, node);
            removeNode(node);
            insertAtTail(node);
        }

        if (!map.containsKey(key)) {
            ListNode node = new ListNode(value, key);

            map.put(key, node);
            insertAtTail(node);
            if (map.size() > capacity) {
                ListNode nextToHead = head.next;
                removeNode(nextToHead);
                map.remove(nextToHead.key);
            }
        }
    }

    public void removeFirst (ListNode node) {
        head = head.next;
        if (head != null) {
            head.prev = null;
            return;
        }
        else {
            tail = null;
        }
    }

    //head<-1->2->3->4->tail
    public void removeNode (ListNode node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    public void insertAtTail (ListNode node) {
        //then insert at tail:
       node.prev = tail.prev;
       tail.prev.next = node;
       node.next = tail;
       tail.prev = node;
    }
}
