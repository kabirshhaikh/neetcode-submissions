class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        //here i am gonna define an output list:
        List<Integer> list = new ArrayList<>();
        
        //edge case check:
        if (p.length() > s.length()) {
            return list;
        }

        //first i will make frequency array of string p and use that as hashkey:
        int[] patternFreq = new int[26];

        for (int i=0; i<p.length(); i++) {
            char ch = p.charAt(i);
            patternFreq[ch - 'a']++;
        }

        String patternHash = Arrays.toString(patternFreq);

        //i am now gonna maintain one freq array and move a sliding window over 
        //string s. the window will be of p.length()
        int[] freq = new int[26];

        for (int i=0; i<p.length(); i++) {
            char ch = s.charAt(i);
            freq[ch - 'a']++;
        }

        String initialHashKey = Arrays.toString(freq);

        if (initialHashKey.equals(patternHash)) {
            list.add(0);
        }

        for (int i=p.length(); i<s.length(); i++) {
            //increment count for incoming character:
            freq[s.charAt(i) - 'a']++;

            //decrement outgoing character from wndow:
            freq[s.charAt(i - p.length()) - 'a']--;

            //now create hashkey:
            String hashKey = Arrays.toString(freq);

            if (hashKey.equals(patternHash)) {
                list.add((i - p.length()) + 1);
            }
        }

        return list;
    }
}
