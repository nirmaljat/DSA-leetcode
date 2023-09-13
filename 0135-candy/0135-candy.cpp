class Solution {
public:
    int candy(vector<int>& rat) {
        int n=rat.size();
        int ans=n;
        int i=1;
        while(i<n){
           if(rat[i]==rat[i-1]){
               i++;
               continue;
           }
           int up=0;
           while(rat[i]>rat[i-1]){
               up++;
               ans+=up;
               i++;
               if(i==n)return ans;
           }
           int dow=0;
           while(i<n && rat[i]<rat[i-1]){
               dow++;
               ans+=dow;
               i++;
           }
           ans-=min(up,dow);
        }
        return ans;
    }
};