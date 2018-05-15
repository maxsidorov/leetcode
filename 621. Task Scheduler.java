class Solution {
    public int leastInterval(char[] tasks, int n) {
        int max = 0, maxCount = 0;
        HashMap<Character, Integer> map = new HashMap();
        for(char task: tasks) {
            Integer count = map.get(task);
            if (count == null) count = 0;
            map.put(task, ++count);
            if (count > max) {
                max = count;
                maxCount = 1;
            } else if (count == max) {
                maxCount++;
            }
        }
        return Math.max(tasks.length, (n + 1) * (max - 1) + maxCount);
    }
}
