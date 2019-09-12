import java.util.*;


class Node{
char c;
int f;

Node(char c , int f){
this.c = c;
this.f = f;
}

}

class comparableClass implements Comparator<Node>{

public int compare(Node a , Node b){
if(b.f> a.f) return 1;
else if(b.c==a.c) return 0;
else return -1;

}


}


class rearrString{




public static void main(String args[]){
  String s = "aabc";
  int n = s.length();
 

  PriorityQueue<Node> pq = new PriorityQueue<Node>(n , new comparableClass());

  Map<Character, Integer> m = new HashMap<Character, Integer>();

 for(int i=0;i<s.length();i++){
  char c = s.charAt(i);
  if(m.containsKey(c)){
     int v = m.get(c);
     m.put(c,v+1); 

  }else{
   m.put(c,1);
  }
}

for(Map.Entry<Character, Integer> entry: m.entrySet()){
 Node node = new Node(entry.getKey(), entry.getValue());
 pq.add(node);
// System.out.println(node.c + "  " + node.f);
}

 Iterator iterator = pq.iterator();

String res = "";
Node prev =  new Node('#', -1);
int f = 0;
while(!pq.isEmpty()){
  Node current = pq.poll();
  System.out.println(current.c + "  " + current.f);
  if(current.c != prev.c) {
    res+=current.c;
    current.f--;
   if(prev.c != '#' && prev.f > 0) pq.add(prev);
   prev = current;
     
 }
 
}

if(res.length() == s.length()) { 
System.out.println(res);
}
else{
System.out.println("Not Possible");
}

}




}


