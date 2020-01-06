public class Solution {
  public List<String> removeInvalidParentheses(String s) {
    int leftToRemove = 0, rightToRemove = 0;
    for (int i = 0; i < s.length(); i++) {
      char ch = s.charAt(i);
      if (ch == '(') {
        leftToRemove++;
      } else if (ch == ')') {
        if (leftToRemove == 0) {
          rightToRemove++;
        } else {
          leftToRemove--;
        }
      }
    }
    if (leftToRemove == 0 && rightToRemove == 0) {
      List<String> result = new ArrayList();
      result.add(s);
      return result;
    }
    if (leftToRemove + rightToRemove == s.length()) {
      List<String> result = new ArrayList();
      result.add("");
      return result;
    }
    List<Set<Integer>> resultIndexes = new ArrayList();
    removeImpl(s, 0, 0, leftToRemove, rightToRemove, new HashSet(), new HashSet(), resultIndexes);

    Set<String> result = new HashSet();
    for(Set<Integer> indexes: resultIndexes) {
      int len = s.length() - indexes.size();
      char str[] = new char[len];
      for (int i = 0, j = 0; i < s.length(); i++) {
        if (!indexes.contains(i)) {
          str[j++] = s.charAt(i);
        }
      }
      result.add(String.valueOf(str));
    }

    return new ArrayList(result);

  }

  private void removeImpl(String s, int i, int leftOpen, int leftToRemove, int rightToRemove, Set<Integer> leftRemovedIndexes, Set<Integer> rightRemovedIndexes, List<Set<Integer>> result) {
    while (i < s.length() && s.charAt(i) != '(' && s.charAt(i) != ')') {
      i++;
    }
    if (i < s.length()) {
      System.out.println("IF");
      char ch = s.charAt(i);
      if (ch == '(') {
        if (leftToRemove > 0) {
          leftRemovedIndexes.add(i);
          removeImpl(s, i + 1, leftOpen, leftToRemove - 1, rightToRemove, leftRemovedIndexes, rightRemovedIndexes, result);
          leftRemovedIndexes.remove(i);
        }

        removeImpl(s, i + 1, leftOpen + 1, leftToRemove, rightToRemove, leftRemovedIndexes, rightRemovedIndexes, result);
      } else {
        if (rightToRemove > 0) {
          rightRemovedIndexes.add(i);
          removeImpl(s, i + 1, leftOpen, leftToRemove, rightToRemove - 1, leftRemovedIndexes, rightRemovedIndexes, result);
          rightRemovedIndexes.remove(i);
        }
        if (leftOpen == 0) return;
        removeImpl(s, i + 1, leftOpen - 1, leftToRemove, rightToRemove, leftRemovedIndexes, rightRemovedIndexes, result);
      }

    } else {
      if (leftOpen == 0 && leftToRemove == 0 && rightToRemove == 0) {
        Set<Integer> indexes = new HashSet();
        indexes.addAll(leftRemovedIndexes);
        indexes.addAll(rightRemovedIndexes);
        result.add(indexes);
      }
    }
  }
}
