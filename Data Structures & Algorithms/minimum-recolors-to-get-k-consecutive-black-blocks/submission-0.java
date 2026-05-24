class Solution {
    public int minimumRecolors(String blocks, int k) {
        int blackCount = 0;
        int whiteCount = 0;

        int output = Integer.MAX_VALUE;

        int left = 0;

        //white: 3
        //black: 4
        for (int right=0; right<blocks.length(); right++) {
            char current = blocks.charAt(right);
            if (current == 'B') {
                blackCount++;
            }
            else {
                whiteCount++;
            }

            while (right - left + 1 >= k) {
                output = Math.min(output, whiteCount);
                char leftChar = blocks.charAt(left);
                if (leftChar == 'B') {
                    blackCount--;
                }
                else {
                    whiteCount--;
                }

                left++;
            }
        }

        return output;
    }
}