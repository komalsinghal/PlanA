import java.util.*;
class List{
 LinkedList<Integer> adj;

 List() {
   adj = new LinkedList<Integer>();

 }

} 

class Graph{ 

 boolean exist[] = new boolean[26];
  List list[];
Graph() {
  
    list = new List[26];
   for(int i=0; i<26; i++) {
     list[i] = new List();
      exist[i] = false;
   }
}

public void addEdge(int start, int end) {
  list[start].adj.add(end);
  exist[start] = true;
  exist[end] = true;
}

}


public class order{
 

/*   public class Graph{


LinkedList<Integer> list[] = new LinkedList<Integer>[26];
boolean exist[] = new boolean[26];
Graph(){
  for(int i=0; i<26; i++){
   list[i] = new LinkedList<Integer>();
   exist[i] = false;

 }
}

public void addEdge(int start, int end) {
  arr[start].add(end);
  exist[start] = true;
  exist[end] = true;
}

}*/




   static Stack<Integer> st = new Stack<>();

  public static boolean topoSortUtil(Graph g, int v, boolean visited[] , boolean progress[]){
   
   if(progress[v] ) return false;
   if(visited[v]) return true;

   progress[v] = true;
   visited[v] = true;
   
       for(int j=0; j<g.list[v].adj.size(); j++){
           if(!topoSortUtil(g, g.list[v].adj.get(j) , visited , progress)){
             return false; 
           }
             
        }
       
      st.push(v);
      progress[v] = false;
      return true;

  }

    


   public static boolean topoSort(Graph g, int nv){
      
        boolean res = true;
         boolean visited[] = new boolean[26];
         boolean inProcess[] = new boolean[26];

         for(int i=0;i<26;i++) {
          if(g.exist[i] && !visited[i]) {
            res = topoSortUtil(g,i,visited, inProcess);          
            if(!res) return res;
          }
       }

         return res;
              

   
}
 
   public static void printOrder(String[] words , int length){
     Graph g = new Graph();

     for(int i=0;i<words.length-1;i++){
          String first = words[i];
          String second = words[i+1];
          
           int f= first.length();
           int s  = second.length();
         int f1=0, s1=0;
           while(f1<f && s1<s){
             char c1= first.charAt(f1);
             char c2 = second.charAt(s1);
             if(c1 != c2 ) {
               g.addEdge(c1-'a' , c2-'a');
                break;
               }  
             f1++;
             s1++;
              
            }
      }
   boolean res = true;
  
   res =   topoSort(g,length);
 
    if(!res) {
     System.out.println("Not Valid");
    }else{
      while(!st.isEmpty()){
        int k = st.pop()+'a';
        System.out.print((char)k  + " " );
     }

   }

 }


 public static void main(String args[]){
    String[] words = {"aba", "baa", "aab"}; 
     printOrder(words, 3); 


  }  



}
