class Solution {
    public String minWindow(String s, String t) {
        HashMap<Character, Integer> tMap = new HashMap<>();
        for (int i=0; i<t.length(); i++) {
            tMap.put(t.charAt(i), tMap.getOrDefault(t.charAt(i), 0) + 1);
        }

        HashMap<Character, Integer> sMap = new HashMap<>();
        int min = Integer.MAX_VALUE;
        int formed = 0;
        int left = 0;
        String output = "";

        for (int right=0; right<s.length(); right++) {
            char current = s.charAt(right);
            
            //add current to sMap:
            sMap.put(current, sMap.getOrDefault(current, 0) + 1);

            //update formed if current exists in tMap and count of current from tMap equals count of current in sMap:
            if (tMap.containsKey(current) && sMap.get(current) == tMap.get(current)) {
                formed++;
            }

            while (formed == tMap.size()) {
                //record min length of substring:
                if (min > right - left + 1) {
                    min = right - left + 1;
                    output = s.substring(left, right + 1);
                }

                //remove element on left from hashmap:
                sMap.put(s.charAt(left), sMap.get(s.charAt(left)) - 1);

                //decrement formed if its count is less than the count of element in tMap from left pointer:
                if (tMap.containsKey(s.charAt(left)) && sMap.get(s.charAt(left)) < tMap.get(s.charAt(left))) {
                    formed--;
                }

                //if the value of element at left is 0 then remove it from map:
                if (sMap.get(s.charAt(left)) == 0) sMap.remove(s.charAt(left));

                //increment left:
                left++;
            }
        }

        return output;
    }
}
