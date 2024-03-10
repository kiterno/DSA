package google.com.array;

public class GuessNumber {
    public int getMoneyAmount(int n) {
        if(n==1){
            return 0;
        }
        Integer[][] dp = new Integer[n+1][n+1];
        return answer(1,n,dp);
    }
    private int answer(int start,int end,Integer[][] dp){
        if(start > end){
            return Integer.MIN_VALUE;
        }
        if(start == end){
            return 0;
        }
        if(dp[start][end] != null){
            return dp[start][end];
        }
        int min = Integer.MAX_VALUE;
        for(int i=start;i<=end-1;i++){
            int max = i + Math.max(answer(start,i-1,dp),answer(i+1,end,dp));
            min = Math.min(min,max);
        }
        return dp[start][end] = min;
    }
}

/*
Firstly this is very similar to standard problem -- > egg dropping problem.
Let's understand with example -
take n = 3
   now ,
   3 -- end
   2
   1 -- start
   i have option from where to begin either from 1 or from 3. Suppose I begin with 3 now i have 2 options whether to go up or go down - if i go up --> it would be  end  + (end+1) . Means i am taking this money and going upwards.

   If i go down end + (end-1).
   Core logic is i take money and check both up and down .
   Now for max and min thing.
   We are taking max of (down , up) -- > we taking worst case , how much we can spend
   then min beacuse from all worst cases we will take minimum from them.

   Take like this , person -- > A  Go for shopping in  10 shopes , now take maximum amount spend from 10 shopes.
   Then he goes 10 times in a day , max of every time he go and then minimum from 10 maximum values;

   Now go through solution then -- i will explain again.
   */
/*
Looping for checking every particular worst case and (money we can take) + Max(down,up)
then min from all worst cases.
By loop we are making cut between up and down + money(possibly we take).
For better understanding go through EGG DROPING PROBLEM  + use pen paper for this problem , use small case (n==4)  then you will understand.
*/