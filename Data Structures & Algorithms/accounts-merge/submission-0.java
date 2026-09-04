class Solution {
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        //so first i create the adjacency list where key is email and value is list of neighbours meaning emails: for that I will use a hashmap:
        HashMap<String, List<String>> al = new HashMap<>();

        //i will now loop over accounts:
        for (int i=0; i<accounts.size(); i++) {
            List<String> curr = accounts.get(i);
            String email = curr.get(1);
            al.putIfAbsent(email, new ArrayList<>()); 

            for (int j=2; j<curr.size(); j++) {
                String nextEmail = curr.get(j);
                List<String> emailList = al.getOrDefault(email, new ArrayList<>());
                List<String> nextEmailList = al.getOrDefault(nextEmail, new ArrayList<>());

                emailList.add(nextEmail);
                nextEmailList.add(email);

                al.put(email, emailList);
                al.put(nextEmail, nextEmailList);
            }
        }

        //now i create another hashmap to map email to a name:
        HashMap<String, String> emailToName = new HashMap<>();

        for (int i=0; i<accounts.size(); i++) {
            List<String> curr = accounts.get(i);
            String name = curr.get(0);

            for (int j=1; j<curr.size(); j++) {
                String email = curr.get(j);

                emailToName.put(email, name);
            }
        }

        //now i create a hashset to string to track the globally visited emails:
        HashSet<String> visited = new HashSet<>();

        //now i create the output list:
        List<List<String>> output = new ArrayList<>();

        //now i loop al's keys to perform dfs and create a list:
        for (String email : al.keySet()) {
            if (!visited.contains(email)) {
                //now i define a fresh list called dfsResult which will hold connected emails:
                List<String> dfsResult = new ArrayList<>();

                //now i perform the dfs:
                dfs(email, visited, al, dfsResult);

                //now i sort the dfsResult list:
                Collections.sort(dfsResult);
                
                //now i get the name for this email from emailToName map:
                String name = emailToName.get(email);

                //after getting name i add it at the 0th position:
                dfsResult.add(0, name);

                //now i add dfsResult list into the output list:
                output.add(dfsResult);
            }
        }

        //now i return output:
        return output;
    }

    //now i write the recursion function of typ void to add all emails into a list:
    public void dfs (String email, HashSet<String> visited, HashMap<String, List<String>> al, List<String> dfsResult) {
        //now first base case: if the email is already visited then return no need to traverse it again:
        if (visited.contains(email)) {
            return;
        }

        //otherwise i add the email to visited set:
        visited.add(email);

        //now i add email to the dfsResult:
        dfsResult.add(email);

        //now i get the neighbours for this email:
        List<String> neighbours = al.getOrDefault(email, new ArrayList<>());

        //now i loop over neighbours:
        for (int i=0; i<neighbours.size(); i++) {
            String currentNeighbour = neighbours.get(i);

            dfs(currentNeighbour, visited, al, dfsResult);
        }
    }
}


                                   
//                                    - neet_dsa@gmail.com
//                                  /
//    bob@gmail.com - neet@gmail.com

//                                  alice@gmail.com

//                                  neetcode@gmail.com

// so the problem demands dfs approach.
// i will have to create AL where key is email and value is list of emails connected to the key. so this is hashmap of unidirected graph.

// AL = [
//     neet@gmail.com -> {neet_dsa@gmail.com, bob@gmail.com},
//     neet_dsa@gmail.com -> {neet@gmail.com}
//     bob@gmail.com -> {neet@gmail.com},
//     neetcode@gmail.com -> {},
//     alice@gmail.com -> {},
// ]

// then i need to create a map where to track which email maps to which name. lets call it emailToName

// after that i will define a hashset of string to track visited emails.

// then i will loop over Al's map.keySet()
// for each key in the map i will start a dfs.
// that dfs will get a fresh list of string to add all the emails into it, then the visited hashset as well
// so dfs (email, visited, al, fresh list);
// after this we get list of emails from dfs for this email.
// then i pull the name for this email from emailToname.
// i sort the list of fresh emails
// then i will do freshlist.add(0, name)
// and then i will add fresh list into output list



// dfs structure of type void:
// if email visited then return.
// else add email to fresh list.
// mark email visited.
// get neighbours.
// loop on each neighbour: