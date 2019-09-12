import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {
    
    static int r[] = {-1,-1,0,1,1,1,0,-1};
    static int c[] = {0,1,1,1,0,-1,-1,-1};

static Set<String> measure = new HashSet<String>();
    
    static class TrieNode {
        TrieNode childNode[] = new TrieNode[26];
        boolean leaf;
        TrieNode(){
            for(int i=0;i<26;i++){
                childNode[i] = null;
            }
            leaf = false;
        }
    }
    
    static void insert(String str, TrieNode root) {
        TrieNode ptr = root;
        for(int i=0;i<str.length();i++){
            if(ptr.childNode[str.charAt(i)-'A'] == null){
                ptr.childNode[str.charAt(i)-'A'] = new TrieNode();
            }
            ptr = ptr.childNode[str.charAt(i)-'A'];      
        }
        
        ptr.leaf = true;      
    }
    static boolean isSafe(boolean[][] visited, int i , int j , String[] input){
        
        if(i >= 0 && i < input.length && j>= 0 && j < input[i].length() && !visited[i][j]) return true;
        return false;
    }
    
    
    
    static void searchWord(String str, String input[], boolean[][] visited, int i , int j, TrieNode root){
        if(root.leaf == true) {
           // System.out.println("true " + str);
measure.add(str);

        }
        
        if(isSafe(visited, i, j, input)){
            visited[i][j] = true;
            for(int p=0;p<26;p++){
                if(root.childNode[p] != null){
                    char ch = (char) (p + 'A') ; 
                     for(int k=0;k<8;k++){
                if(isSafe(visited, i+r[k], j+c[k], input) && input[i+r[k]].charAt(j+c[k]) == ch) {
                    searchWord(str+ch , input , visited, i + r[k], j+c[k], root.childNode[p]);
                }
            }
                }
                
            
        }
            }
        visited[i][j] = false;
           
    }

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
      Scanner s = new Scanner(System.in);
      int row = s.nextInt();
      int col = s.nextInt();
    
      String input[] = new String[row];
        String str;
        int flag = 0;
        for(int i=0;i<row;i++){
             str = s.next();
            if(str.length() != col) flag = 1;
            input[i] = str;
        }
       List<String> dict = new ArrayList<String>();
        str = s.next();
        while(!str.equals("*")){
            dict.add(str);
            str = s.next();
        } 
        
      /* for(int i=0;i<row;i++){
            System.out.println(input[i]);
        }
        
        for(int i=0;i<dict.size();i++){
            System.out.println(dict.get(i));
        } */
        
        
        if(flag == 1){
             System.out.println("Mauvais format");
        } else{
            TrieNode root  = new TrieNode();
            for(int i=0;i<dict.size();i++){
                insert(dict.get(i), root);
             }
           
            boolean visited[][] = new boolean[row][col];
             str = "";
            for(int i=0;i<row;i++){
                for(int j=0;j<col;j++){
                    char c = input[i].charAt(j);

                    
                    if(root.childNode[c-'A'] != null) {
str += c;



                        searchWord(str, input, visited, i, j, root.childNode[c-'A']);
                    }
                }
                
                str = "";
            }

      for(int i=0;i<dict.size();i++){
        if(measure.contains(dict.get(i)))
            System.out.println("true");
        
          else
         System.out.println("false");
         }   
}
}
}
