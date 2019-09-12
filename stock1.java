/*package whatever //do not write package name here */

import java.util.*;
import java.lang.*;
import java.io.*;

class stock1 {
    
    public static int findMax(int prices[] , int k ){
         int n = prices.length;
		
		int dp[][] = new int[k+1][n];
		
		for(int i=0;i<=k;i++){
			dp[i][0] = 0;
		}
		for(int i=0;i<n;i++){
			dp[0][i] = 0;
		}
		
		for(int i=1;i<=k;i++){
      int prevDiff = Integer.MIN_VALUE;
			for(int j=1;j<n;j++){
				prevDiff = Math.max(prevDiff, dp[i-1][j-1] - prices[j-1]);
				dp[i][j] = Math.max(dp[i][j-1] , prices[j] + prevDiff);
			}
		}
		
		return dp[k][n-1];
		
    }
    
    
	public static void main (String[] args) {
	    
	    Scanner s = new Scanner(System.in);
	    int t = s.nextInt();
	    while(t-- > 0){
	        int k = s.nextInt();
	        int n = s.nextInt();
	        int arr[] = new int[n];
	        for(int i=0; i<n; i++){
	            arr[i] = s.nextInt();
	        }
	        
	        int res = findMax(arr , k );
	        
	        System.out.println(res);
	        
	    }
		//code
	}
}
