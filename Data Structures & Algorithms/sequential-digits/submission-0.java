class Solution {
    public List<Integer> sequentialDigits(int low, int high) {
        List<Integer> list = new ArrayList<>();

        //this is brute force:
        // for (int i=low; i<= high; i++) {
        //     String curr = String.valueOf(i);
        //     int prev = curr.charAt(0) - '0';
        //     int index = 1;
        //     boolean isGreater = true;
        //     while (index < curr.length()) {
        //         int currDigit = curr.charAt(index) - '0';
        //         if (currDigit == prev + 1) {
        //             prev = currDigit;
        //             index++;
        //         }
        //         else {
        //             isGreater = false;
        //             break;
        //         }
        //     }

        //     if (isGreater) {
        //         list.add(i);
        //     }
        // }
        String digits = "123456789";

        for (int size = 2; size <= 9; size++) {

            int left = 0;
            int right = size - 1;

            while (right < digits.length()) {

                String curr = digits.substring(left, right + 1);
                int num = Integer.parseInt(curr);

                if (num >= low && num <= high) {
                    list.add(num);
                }

                left++;
                right++;
            }
        }

        return list;
    }
}