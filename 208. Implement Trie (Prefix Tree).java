class Trie {

  Node root;
  
  /** Initialize your data structure here. */
  public Trie() {
    root = new Node((char)0);
  }

  /** Inserts a word into the trie. */
  public void insert(String word) {
    Node current = root;
    for (int i = 0; i < word.length(); i++) {
      char ch = word.charAt(i);
      if (current.children == null) {
        current.children = new HashMap();
      }
      Node node = current.children.get(ch);
      if (node == null) {
        node = new Node(ch);
        current.children.put(ch, node);
      }
      current = node;
    }
    current.isFinal = true;
  }

  /** Returns if the word is in the trie. */
  public boolean search(String word) {
    Node node = find(word);
    return node != null && node.isFinal;
  }

  /** Returns if there is any word in the trie that starts with the given prefix. */
  public boolean startsWith(String prefix) {
    return find(prefix) != null;
  }
  
  private Node find(String word) {
    Node current = root;
    for (int i = 0; i < word.length(); i++) {
      if (current.children == null) return null;
      Node node = current.children.get(word.charAt(i));
      if (node == null) return null;
      current = node;
    }
    return current;
  }

  final class Node {
    char ch;
    boolean isFinal;
    HashMap<Character, Node> children;
    
    public Node(char ch) {
      this.ch = ch;
    }
  }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */
