class LRUCache {
  
  int capacity;
  HashMap<Integer, Node> map;
  Node head, tail;

  public LRUCache(int capacity) {
    this.capacity = capacity;
    map = new HashMap(capacity + 1);
  }

  public int get(int key) {
    Node node = map.get(key);
    if (node == null) {
      return -1;
    } else {
      appendNode(removeNode(node));
      return node.value;
    }
  }

  public void put(int key, int value) {
    Node node = new Node(key, value);
    removeNode(map.put(key, node));
    if (map.size() > capacity) {
      removeNode(map.remove(head.key));
    }
    appendNode(node);
  }
  
  private void appendNode(Node node) {
    if (head == null) {
      head = node;
    } else {
      tail.next = node;
      node.prev = tail;
    }
    tail = node;
  }
  
  private Node removeNode(Node node) {
    if (node != null) {
      if (head == node && tail == node) {
        head = null;
        tail = null;
      } else if (head == node) {
        head = node.next;
        head.prev = null;
      } else if (tail == node) {
        tail = node.prev;
        tail.next = null;
      } else {
        node.prev.next = node.next;
        node.next.prev = node.prev;
      }
    }
    return node;
  }
  
  private static class Node {
    int key;
    int value;
    Node next;
    Node prev;
    
    Node(int key, int value) {
      this.key = key;
      this.value = value;
    }
  }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
