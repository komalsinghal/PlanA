/*package whatever //do not write package name here */

import java.util.*;
import java.lang.*;
import java.io.*;

class MinSpaceForPower_5 {
    
    static boolean isPowerOfFive(long val){
        while(val > 1){
            if(val%5 != 0) return false;
            val = val/5;
        }
        
        return true;
    }
    static int Min_Space(String str , int dp[] , int n){
        
        if(n >= 1){
         dp[n-1] = str.charAt(n-1) == '1' ? 1:0;
            
            for(int i=n-2;i>=0 ;i--){
                if(str.charAt(i) == '0')
                {
                   dp[i] = -1;
                   continue;
               }else{
                   long  val = 0;
                   for(int j=i;j<n;j++){
                       val = 2*val + (str.charAt(j) - '0');
                       System.out.println("val " + val);
                       if(isPowerOfFive(val)) {
                           if(j==n-1){
                               dp[i] = 1;
                           }else{
                               if(dp[j+1] !=  -1){
                                  // System.out.println("i " + i + " j+1"+  j+1 +  " dp[j+1] " + dp[j+1]); 
                                   dp[i] = Math.min(dp[i], 1+dp[j+1]);
                                   //System.out.println(dp[i]);
                               }
                           }
                           
                       }
                   }
                  
                   dp[i] = dp[i] == Integer.MAX_VALUE?-1:dp[i];
               }
               
            }
            return dp[0];
        }
        
         return -1;   
        }
        
        
    
    
    
	public static void main (String[] args) {
	    Scanner s  = new Scanner(System.in);
	    int t = s.nextInt();
	    
	    while(t-- > 0){
	        String str = s.next();
	        
	        int n = str.length();
	        int dp[] = new int[n];
	        Arrays.fill(dp, Integer.MAX_VALUE);
	        
	        int res = Min_Space(str , dp , n);
	        
	        System.out.println(res);
	    }
	}
}
