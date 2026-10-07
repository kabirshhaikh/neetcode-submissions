class Solution {
    public int numKLenSubstrNoRepeats(String s, int k) {
        int output = 0;
        HashMap<Character, Integer> map = new HashMap<>();
        int left = 0;

        for (int right=0; right<s.length(); right++) {
            char curr = s.charAt(right);
            map.put(curr, map.getOrDefault(curr, 0) + 1);

            while (map.get(curr) > 1 || right - left + 1 > k) {
                char charAtLeft = s.charAt(left);
                int val = map.get(charAtLeft);
                //reduce count of left char:
                map.put(charAtLeft, val - 1);

                //increment left:
                left++;
            }

            if (right - left + 1 == k) {
                output++;
            }
        }

        return output;
    }
}
