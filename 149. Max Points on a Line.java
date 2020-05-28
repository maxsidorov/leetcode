import java.math.BigDecimal;
import java.math.RoundingMode;

class Solution {
  public int maxPoints(int[][] points) {
    int result = 0;
    for (int[] point1: points) {
      HashMap<BigDecimal, Integer> map = new HashMap();
      int x1 = point1[0], y1 = point1[1];
      int sameNum = 0;
      for (int[] point2: points) {
        int x2 = point2[0], y2 = point2[1];
        if (x1 == x2 && y1 == y2) {
          sameNum++;
        } else {
          // Two points are on the same line if x1 = a * y1 + b and x2 = a * y2 + b
          // => x1 - a * y1 = x2 - a * y2 => a = (x1 - x2) / (y1 - y2)
          // Finding all points on the same line with slope a
          BigDecimal a = (y1 - y2 != 0)
            ? new BigDecimal(x1 - x2).divide(new BigDecimal(y1 - y2), 20, RoundingMode.HALF_UP)
            : null; // infinity
          map.put(a, map.getOrDefault(a, 0) + 1);
        }
      }
      result = Math.max(result, sameNum);
      for (Integer num: map.values()) {
        result = Math.max(result, num + sameNum);
      }
    }
    return result;
  }
}
