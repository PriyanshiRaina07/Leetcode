class Solution {
    static class pair{
        String str;
        int step;
        public pair(String str, int step){
            this.str = str;
            this.step = step;
        }
    }
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        //hashset because time and space is o(1)

        HashSet<String> set = new HashSet<>();

        for(String word : wordList){
            set.add(word);
        }
        set.remove(beginWord);

        //n word list me nhi ho
        if(set.contains(endWord)== false){
            return 0;
        }

        Queue<pair>q = new LinkedList<>();

        //q me pair add
        q.offer(new pair(beginWord,1));//initialize with 1 to tell ye level 1 hai

        while(!q.isEmpty()){
            pair curr = q.poll();
            String word = curr.str;
            int level = curr.step;//kitna step liya hai 

            //last word compare to word then give level

            if(word.equals(endWord))
               return level;

            //word ki length
            int len = word.length();
            for(int i = 0; i < len; i++){
                char []arr = word.toCharArray();
                for(char ch = 'a'; ch<= 'z'; ch++){
                    if(arr[i] == ch) continue; //letter and character both same then skip
                    arr[i] = ch;
                    String replaceWord = new String(arr);
                    //check in set
                    if(set.contains(replaceWord)){
                        q.offer(new pair(replaceWord,level+1));
                        set.remove(replaceWord);
                    }     
                }
            }   
        }
        return 0;

    }
}