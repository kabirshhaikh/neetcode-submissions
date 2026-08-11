class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        //so here i first define a hashset of string to store visited words from wordlist:
        HashSet<String> visited = new HashSet<>();

        //for faster lookup i am converting wordList to wordListSet:
        HashSet<String> wordSet = new HashSet<>(wordList);

        //here i define the count variable:
        //setting count as 1 because beginWord itself is the the firstWord to start with:
        int count = 1;

        //here i define a queue for BFS:
        Queue<String> q = new ArrayDeque<>();

        //i add the beginWord in the q to start:
        q.offer(beginWord);
        
        //i mark the beginWord as visited:
        visited.add(beginWord);

        //now i run the while loop until queue is not empty:
        while (!q.isEmpty()) {
            int size = q.size(); //here i capture current size on which i will run a for loop
            for (int i=0; i<size; i++) {
                //here i pop the current word:
                String poppedWord = q.poll();

                //now i check for all variations from a-z for each letter.
                //then check if a word exists in the wordList and is not already visited.
                //if yes and if it matches endWord then increment count and return early.
                //else add the found word into queue, mark it visited and continue looking for other matching neighbours for the new transformed word:
                for (int j=0; j<poppedWord.length(); j++) {
                    //now i convert poppedWord to chars array:
                    char[] chars = poppedWord.toCharArray();
                    //now i run another nested loop and check a-z on the jth element:
                    for (char c = 'a'; c<= 'z' ; c++) {
                        if (poppedWord.charAt(j) == c) {
                            continue; //same character as jth element so no change
                        }

                        //otherwise i form a new word but setting the jth element as character c and perform validation check:
                        chars[j] = c;

                        //new string word:
                        String newWord = new String(chars);

                        if (wordSet.contains(newWord) && !visited.contains(newWord)) {
                            //at this point if new word matches endWord then increment count and return:
                            if (newWord.equals(endWord)) {
                                count = count + 1;
                                return count;
                            }

                            //other wise mark it visited and add the new word to queue:
                            visited.add(newWord);
                            q.offer(newWord);
                        }
                    }
                }
            }

            //lets say inside matching neighbours were found then after for loop end i increment the count:
            count = count + 1;
        }

        //if the while loop end and inside while loop if we didnt find endWord then i return 0:
        return 0;
    }
}


//so this is how the algo will work.
//the problem is asking us to find minimum number of words so this points towards BFS approach.
//In the beginning i define a queue.
//then i define a visited hashset of string to track already visited words from wordlist.
//then i define a count variable to count steps.
//i add the beginWord into it.
//then i write while loop until queue is not empty
//inside i capture the current size.
//then i loop over the size.
//i pop the current word
//then i run a for loop on it and try all variations from a-z for each letter.
//each step i check if the current transformed word is presenet in the wordList and is not visited.
//lets say i find a match, then i add the matching word into the queue and mark it visited. and then i continue find other neighbours until all 26 variations for each letter is found.
//also lets say if a match is found then i check if the found word is it endWord if yes then increment count and return count immediately.
//else after for loop increment the count.
//in the end i return the count variable

//time complexity is: O(N*L) where N is number of words in wordList and L is length of each word.
//space complexity is: O(N*L) for visited, wordset and queue combined.
