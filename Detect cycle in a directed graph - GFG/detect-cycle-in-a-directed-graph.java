//{ Driver Code Starts
import java.util.*;
import java.io.*;
import java.lang.*;

class DriverClass {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            ArrayList<ArrayList<Integer>> list = new ArrayList<>();
            int V = sc.nextInt();
            int E = sc.nextInt();
            for (int i = 0; i < V; i++)
                list.add(i, new ArrayList<Integer>());
            for (int i = 0; i < E; i++) {
                int u = sc.nextInt();
                int v = sc.nextInt();
                list.get(u).add(v);
            }
            if (new Solution().isCyclic(V, list) == true)
                System.out.println("1");
            else
                System.out.println("0");
        }
    }
}
// } Driver Code Ends


/*Complete the function below*/

class Solution {
   
   boolean dfsCycle(int cur, ArrayList<ArrayList<Integer>> adj,boolean[] dfsvisit,boolean[] visit)
   {
        visit[cur]=true;
       
        for(int j=0;j<adj.get(cur).size();j++)
        {
            int k=adj.get(cur).get(j);
            
            if(!visit[k])
            {
                dfsvisit[k]=true;
                boolean ans= dfsCycle(k,adj,dfsvisit,visit);
                dfsvisit[k]=false;
                if(ans)
                {
                    return true;
                }
            }
            if(visit[k] && dfsvisit[k])
            {
                return true;
            }
            
        }
        return false;
   }
   
    public boolean isCyclic(int V, ArrayList<ArrayList<Integer>> adj) {
     
         
         boolean[] visit = new  boolean[V];
         boolean[] dfsvisit=new boolean[V];
         
         for(int i=0;i<V;i++)
         {
             if(!visit[i])
             {
                dfsvisit[i]=true;
                boolean ans= dfsCycle(i,adj,dfsvisit,visit);
                dfsvisit[i]=false;
                if(ans)
                {
                    return true;
                }
             }
         }
         
       
         
         
         return false;
 
    }
}