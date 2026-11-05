class Solution {
    public int numDecodings(String s) {
        //here i will add memoization:
        int[] dp = new int[s.length()];
        Arrays.fill(dp, -1);

        int result = dfs(0, s, dp);
        return result;
    }

    public int dfs (int index, String s, int[] dp) {
        //first base case: if out of bounds:
        if (index == s.length()) {
            return 1;
        }

        //second base case: if dp holds cache then reutrn that ans:
        if (dp[index] != -1) {
            return dp[index];
        }

        //third base case: if current number is 0 return 0 because no alphabet corrosponds to 0:
        if (s.charAt(index) == '0') {
            return 0;
        }

        int oneStep = dfs(index + 1, s, dp);

        int twoStep = 0;

        //before calling index + 2 check if there are enough characters and those characters have letter at or above 10 count and less or equal to 26 meaning between J and Z:
        if (index + 1 < s.length()) {
            int number = Integer.parseInt(s.substring(index, index + 2));
            if (number >= 10 && number <= 26) {
                twoStep = dfs(index + 2, s, dp);
            }
        }

        //add both and return:
        int ways = oneStep + twoStep;

        //before returning store the cache in dp:
        dp[index] = ways;

        //return ways:
        return ways;
    }
}
