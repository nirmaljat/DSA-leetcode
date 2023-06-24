class Solution {
public:
    int dp[21][10001];
    int off=5000;
    int tallestBillboard(vector<int>& rods) {
        int n=rods.size();
        memset(dp,-1,sizeof(dp));
        return  jatdp(0,0,n,rods);      
    }
    int jatdp(int i,int diff,int n,vector<int>& rods){
       
        if(i==n){
            if(diff==0) return 0;
            return INT_MIN;
        }
        if(dp[i][diff+off]!=-1) return dp[i][diff+off];

        int op1=jatdp(i+1,diff,n,rods);
        int op2=rods[i]+jatdp(i+1,diff+rods[i],n,rods);
        int op3=jatdp(i+1,diff-rods[i],n,rods);
        return dp[i][diff+off]=max({op1,op2,op3});
    }
};