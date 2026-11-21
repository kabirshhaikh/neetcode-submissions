class Solution {
    public boolean isOneEditDistance(String s, String t) {
        int m = s.length();
        int n = t.length();

        // More than one edit required
        if (Math.abs(m - n) > 1) {
            return false;
        }

        int left = 0;
        int right = 0;
        int distanceCount = 0;

        while (left < m && right < n) {
            char leftCh = s.charAt(left);
            char rightCh = t.charAt(right);

            if (leftCh == rightCh) {
                left++;
                right++;
            } else {
                distanceCount++;

                if (distanceCount > 1) {
                    return false;
                }

                if (m == n) {
                    // Replacement
                    left++;
                    right++;
                } else if (m < n) {
                    // Insertion into s
                    right++;
                } else {
                    // Deletion from s
                    left++;
                }
            }
        }

        // Any remaining character counts as one edit
        if (left < m || right < n) {
            distanceCount++;
        }

        return distanceCount == 1;
    }
}
