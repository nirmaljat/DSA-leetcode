//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;
class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while (T-- > 0) {
            String[] s = br.readLine().trim().split(" ");
            int V = Integer.parseInt(s[0]);
            int E = Integer.parseInt(s[1]);
            ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
            for (int i = 0; i < V; i++) adj.add(i, new ArrayList<Integer>());
            for (int i = 0; i < E; i++) {
                String[] S = br.readLine().trim().split(" ");
                int u = Integer.parseInt(S[0]);
                int v = Integer.parseInt(S[1]);
                adj.get(u).add(v);
                adj.get(v).add(u);
            }
            Solution obj = new Solution();
            boolean ans = obj.isCycle(V, adj);
            if (ans)
                System.out.println("1");
            else
                System.out.println("0");
        }
    }
}
// } Driver Code Ends


class Solution {
    // Function to detect cycle in an undirected graph.
    public boolean isCycle(int V, ArrayList<ArrayList<Integer>> adj) 
    {
         Queue<Integer> q= new LinkedList<>();
         
         boolean[] visit =new boolean[V];
         int[] par = new int[V];
         
         ArrayList<Integer> ans = new ArrayList<Integer>();
         
         for(int i=0;i<V;i++)
         {
            if(!visit[i])
            {
                q.add(i);
                visit[i]=true;
                par[i]=-1;
                while(!q.isEmpty())
                {
                    int cur=q.remove();
                    
                    for(int j=0;j<adj.get(cur).size();j++)
                    {
                        int neb=adj.get(cur).get(j);
                        if(visit[neb] &&par[cur]!=neb)
                        {
                         return true;
                        }
                        if(!visit[neb])
                        {
                          q.add(neb);
                          par[neb]=cur;
                          visit[neb]=true;
                        }
                        
                    }
                }
             }
            
         }
         
         
         return false;
 
    }
}