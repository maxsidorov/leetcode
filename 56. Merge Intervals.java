/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */
class Solution {
    public List<Interval> merge(List<Interval> intervals) {
        if (intervals == null || intervals.size() == 0) return intervals;
        intervals.sort((i1, i2) -> Integer.compare(i1.start, i2.start));
        List<Interval> result = new ArrayList();
        for (Interval interval: intervals) {
            if (result.isEmpty()) {
                result.add(new Interval(interval.start, interval.end));
            } else {
                Interval last = result.get(result.size() - 1);
                if (last.end < interval.start) {
                    result.add(new Interval(interval.start, interval.end));
                } else {
                    last.end = Math.max(last.end, interval.end);
                }
            }
            
        }
        return result;
    }
}
