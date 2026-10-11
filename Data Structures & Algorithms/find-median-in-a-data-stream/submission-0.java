class MedianFinder {
    private final List<Integer> list;

    public MedianFinder() {
        this.list = new ArrayList<>();    
    }
    
    public void addNum(int num) {
        int low = 0; int high = list.size(); //not doing size() - 1 because the insertion position can be after that last element in list:

        //using low < high and not low <= high because, when low == high thats going to
        //be the inserstion position:
        while (low < high) {
            int mid = low + (high - low) / 2;
            int midElement = list.get(mid);

            if (midElement < num) {
                low = mid + 1;
            }
            else {
                high = mid; //not doing mid - 1 because mid can be the correct candidate
            }
        }

        list.add(low, num);
    }

    public double findMedian() {
        if (list.size() % 2 == 0) {
            //if even:
            int middle = list.size() / 2; //this will give middle index
            int prev = middle - 1;
            //wrapping + operation because we need addition first
            //otherwise java will give first precedence to division 
            double output = ((double) list.get(middle) + list.get(prev)) / 2;
            return output;
        }
        else {
            //if odd:
            int middle = list.size() / 2;
            int middleElement = list.get(middle);
            return (double) middleElement;
        }
    }
}
