class Solution {
    public int shortestWay(String source, String target) {
        //first i will add all the characters of source in hashset:
        HashSet<Character> set = new HashSet<>();
        for (int i=0; i<source.length(); i++) {
            set.add(source.charAt(i));
        }

        int left = 0;
        int right = 0;
        int counter = 1;

        while (right < target.length()) {
            char targetChar = target.charAt(right);

            if (!set.contains(targetChar)) {
                return -1;
            }

            if (left == source.length()) {
                left = 0;
                counter++;
            }

            char sourceChar = source.charAt(left);

            if (sourceChar == targetChar) {
                left++;
                right++;
            }
            else {
                left++;
            }
        }

        return counter;
    }
}
