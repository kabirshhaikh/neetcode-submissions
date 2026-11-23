class RandomizedSet {
    private final HashMap<Integer, Integer> map;
    private final List<Integer> list;
    private final Random random;
    private int index = 0;

    public RandomizedSet() {
        this.map = new HashMap<>();
        this.list = new ArrayList<>();
        this.random = new Random();
    }
    
    public boolean insert(int val) {
        //if val is present in map then return false:
        if (map.containsKey(val)) {
            return false;
        }

        //if not present then add it into hashmap:
        map.put(val, index);

        //after adding increment index:
        index++;

        //also add the val into list:
        list.add(val);

        //then i return true:
        return true;
    }
    
    public boolean remove(int val) {
        //if the val is not present in map, return false:
        if (!map.containsKey(val)) {
            return false;
        }

        //if the element is present then get the index of val:
        int valIndex = map.get(val);

        //get the last element so that after swapping i can update its index:
        int lastElement = list.get(list.size() - 1);

        //now swap valIndex with last index from list in O(1) time:
        Collections.swap(list, valIndex, list.size() - 1);

        //update the position of lastElement with valIndex:
        map.put(lastElement, valIndex);

        //now i will update the map:
        map.remove(val);

        //after swapping, i will remove the last element from list that we just swapped:
        list.remove(list.size() - 1);

        //after removing i will decrement index counter:
        index--;

        //then after doing all this i will return true:
        return true;
    }
    
    public int getRandom() {
        int randomIndex = random.nextInt(list.size());
        return list.get(randomIndex);
    }

    //so for insert and remove we need hashset.
    //also we need a list which will hold insertion
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */