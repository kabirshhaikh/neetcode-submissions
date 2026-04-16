class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        int left = 0;
        int longest = 0;

        for (int right=0; right<s.length(); right++) {
            //first add the character:
            map.put(s.charAt(right), map.getOrDefault(s.charAt(right), 0) + 1);

            //then move left until window is invalid:
            while (map.get(s.charAt(right)) > 1) {
                map.put(s.charAt(left), map.get(s.charAt(left)) - 1);
                if (map.get(s.charAt(left)) == 0) map.remove(s.charAt(left));
                left++;
            }

            //then update the answer: right - left + 1 gives orignal window size:
            longest = Math.max(longest, right - left + 1);

        }

        return longest;
    }
}
