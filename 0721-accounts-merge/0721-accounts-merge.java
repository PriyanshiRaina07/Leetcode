class Solution {

    static int[] parent;
    static int[] size;
    static int component;

    public static int find(int i) {
        if (i == parent[i])
            return i;
        return parent[i] = find(parent[i]);
    }

    public static boolean union(int x, int y) {
        int paren_x = find(x);
        int paren_y = find(y);
        if (paren_x == paren_y) return false;
        if (size[paren_x] < size[paren_y]) {
            int temp = paren_x;
            paren_x = paren_y;
            paren_y = temp;
        }
        parent[paren_y] = paren_x;
        size[paren_x] += size[paren_y];
        component--;
        return true;
    }

    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        //email ko ek unique id deni hai
        HashMap<String, Integer>emailToId = new HashMap<>();
         //email ko uske account name ke sath associate karna hai
        HashMap<String, String>emailToName = new HashMap<>();
        int id = 0;
        for(List<String>acc :  accounts)
        {
            String name = acc.get(0);
            for(int i = 1; i<acc.size();i++)
            {
                String email  = acc.get(i);
                if(!emailToId.containsKey(email))
                {
                    emailToId.put(email,id++);
                }
                emailToName.put(email,name);
            }
        }

        component = id;
        parent = new int[id];
        size  = new int[id];
        for(int i = 0 ; i < id;i++)
        {
            parent[i] = i;
            size[i] = 1;
        }

        // same account ke mail ko merge karna hai
        // step 2
         for(List<String>acc :  accounts)
        {
            if(acc.size() <=2)continue;

            int firstAccountId = emailToId.get(acc.get(1));   // first account ki id
            for(int k = 2; k < acc.size();k++)  // first account mail  ko sabke sath //merge kar rhe   hai
            {
                union(firstAccountId,emailToId.get(acc.get(k)));
            }
        
        }

        HashMap<Integer,List<String>>grouptoId = new HashMap<>();
        
        for(String email : emailToId.keySet())
        {
            int EmailId = emailToId.get(email);
            int root  = find(EmailId);
            if(!grouptoId.containsKey(root))
            {
                grouptoId.put(root,new ArrayList<>());
            }
            grouptoId.get(root).add(email);
        }


        // final step
        List<List<String>>result  = new ArrayList<>();
        for(Integer node : grouptoId.keySet())
        {
            List<String>merge = grouptoId.get(node);
            Collections.sort(merge);
            List<String>answer = new ArrayList<>();
            answer.add(emailToName.get(merge.get(0)));
            answer.addAll(merge);
            result.add(answer);
            
        }
        return result;

    }
}