class RandomizedSet {
    
    private Random rand = new Random();
    private HashMap<Integer, Integer> valueToIndexMap;
    private ArrayList<Integer> valueList;

    /** Initialize your data structure here. */
    public RandomizedSet() {
        valueToIndexMap = new HashMap();
        valueList = new ArrayList();
    }
    
    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    public boolean insert(int val) {
        if (valueToIndexMap.containsKey(val)) {
            return false;
        } else {
            valueToIndexMap.put(val, valueList.size());
            valueList.add(val);
            return true;
        }
    }
    
    /** Removes a value from the set. Returns true if the set contained the specified element. */
    public boolean remove(int val) {
        Integer prevIndex = valueToIndexMap.remove(val);
        if (prevIndex != null) {
            if (valueList.size() > 1 && prevIndex < valueList.size() - 1) {
                // move last element to removed index
                Integer lastValue = valueList.get(valueList.size() - 1);
                valueList.set(prevIndex, lastValue);
                valueToIndexMap.put(lastValue, prevIndex);
            }
            valueList.remove(valueList.size() - 1);
            return true;
        } else {
            return false;
        }
    }
    
    /** Get a random element from the set. */
    public int getRandom() {
        return valueList.get(rand.nextInt(valueList.size()));
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */
