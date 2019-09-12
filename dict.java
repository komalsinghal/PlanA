import java.util.*;

class dict {
    
   public static int MinSpaceUtil(String input, ArrayList<String> dict , int dp[] , int pos , int n, int posi[]){
       if(pos == n ) return 0;
       if(dp[pos] != -1 ) return dp[pos]; 

        int ans  = Integer.MAX_VALUE;
         String tmp = "";
       for(int i=pos; i<n;i++){
             tmp+=input.charAt(i);
             if(dict.contains(tmp)){
               int k = MinSpaceUtil(input, dict , dp , i+1, n, posi);
              if(k!= -1) {
                   if(i+1 != n) 
                       ans = Math.min(ans, k+1);
                    else
                       ans = Math.min(ans, k);
                 if(ans == k || ans == k+1) posi[pos] = i+1;            
 

              }
        }
     }
          

       if(ans != Integer.MAX_VALUE) {
        dp[pos] = ans;
     return ans;
  
    }
  return -1;
       
}


  public static int MinSpace(String input , ArrayList<String> dict, int posi[]) {
       int  n = input.length();
       int dp[] = new int[n];
       
       Arrays.fill(dp, -1);

      return MinSpaceUtil(input, dict, dp, 0, n, posi);

             
  }




  public static void main(String args[]){
       String input = "komal";

       ArrayList<String> dict =  new ArrayList<String>() {{
             add("k"); add("om"); add("omal"); add("al"); }};

      int posi[] = new int[input.length()];

    
        int res = MinSpace(input,dict,posi);

        int i=0;
while(i<input.length()){
  int k = posi[i];
  System.out.println(input.substring(i,k));
 i=k;

}
            System.out.println(res);

   


  }






}
