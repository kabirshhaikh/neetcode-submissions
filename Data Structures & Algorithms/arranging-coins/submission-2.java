class Solution {
    public int arrangeCoins(int n) {
        if (n == 1) {
            return 1;
        }
        int output = 0;

        for (int i = 1; i <= n; i++) {
            if (n - i > 0) {
                output++;
                n = n - i;
            }
            else {
                break;
            }
        }

        return output;
    }
}
