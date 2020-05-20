/**
 * // This is the interface that allows for creating nested lists.
 * // You should not implement it, or speculate about its implementation
 * public interface NestedInteger {
 *
 *     // @return true if this NestedInteger holds a single integer, rather than a nested list.
 *     public boolean isInteger();
 *
 *     // @return the single integer that this NestedInteger holds, if it holds a single integer
 *     // Return null if this NestedInteger holds a nested list
 *     public Integer getInteger();
 *
 *     // @return the nested list that this NestedInteger holds, if it holds a nested list
 *     // Return null if this NestedInteger holds a single integer
 *     public List<NestedInteger> getList();
 * }
 */
public class NestedIterator implements Iterator<Integer> {

  List<NestedInteger> list;
  Integer next;
  int pointer;
  NestedIterator nestedIterator;
  
  public NestedIterator(List<NestedInteger> nestedList) {
    list = nestedList;
    next = findNext();
  }

  @Override
  public Integer next() {
    try {
      return next;
    } finally {
      next = findNext();
    }
  }

  @Override
  public boolean hasNext() {
    return next != null;
  }
  
  private Integer findNext() {
    if (pointer >= list.size()) {
      return null;
    }
    NestedInteger el = list.get(pointer);
    if (el.isInteger()) {
      pointer++;
      return el.getInteger();
    } else {
      if (nestedIterator == null) {
        nestedIterator = new NestedIterator(el.getList());
      }
      if (nestedIterator.hasNext()) {
        return nestedIterator.next();
      } else {
        nestedIterator = null;
        pointer++;
        return findNext();
      }
    }
  }
}


/**
 * Your NestedIterator object will be instantiated and called as such:
 * NestedIterator i = new NestedIterator(nestedList);
 * while (i.hasNext()) v[f()] = i.next();
 */
