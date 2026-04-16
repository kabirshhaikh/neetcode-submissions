class Solution {
    public int characterReplacement(String s, int k) {
        HashMap<Character, Integer> map = new HashMap<>();
        int left = 0;
        int longest = 0;
        int maxFreq = 0;


        for (int right=0; right<s.length(); right++) {
            char current = s.charAt(right);

            //add current to map:
            map.put(current, map.getOrDefault(current, 0) + 1);

            //get count of current key and update maxFreq with it.
            maxFreq = Math.max(maxFreq, map.get(current));

            //shrink the window:
            while ((right - left + 1) - maxFreq > k) {
                map.put(s.charAt(left), map.get(s.charAt(left)) - 1);
                left++;
            }

            //update longest:
            longest = Math.max(longest, right - left + 1);
        }


        return longest;
    }
}
