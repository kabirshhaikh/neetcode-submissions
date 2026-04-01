class Solution {

    public String encode(List<String> strs) {
        StringBuilder sb = new StringBuilder();

        for (int i=0; i<strs.size(); i++) {
            String currentWord = strs.get(i);
            int length = currentWord.length();
            sb.append(length).append("#").append(currentWord);
        }

        return sb.toString();
    }

    //5#Hello5#World
    public List<String> decode(String str) {
        List<String> output = new ArrayList<>();
        int i = 0;

        while (i < str.length()) {
            StringBuilder num = new StringBuilder();

            //this will form the digit number:
            int j = i;
            while (str.charAt(j) != '#') {
                num.append(str.charAt(j));
                j++;
            }

            int length = Integer.parseInt(num.toString());
            String extractedWord = str.substring(j+1, j+1+length);
            output.add(extractedWord);

            //and then i have to reset the pointer
            i = j + 1 + length;
        }

        return output;
    }
}


