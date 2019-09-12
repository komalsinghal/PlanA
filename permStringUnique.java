import java.util.*;

class permStringUnique{

public  static void printArray(char res[]){
 for(int i=0;i<res.length;i++)
  System.out.print(res[i]);

System.out.println();

}


public static void permute(char[] res , int count[] ,  char s[] , int level){
  if(level == res.length) {
    printArray(res);
    return;
  }

  for(int i=0; i< count.length ; i++){
    if(count[i] == 0) {
    continue;

   }
    res[level] = s[i];
    count[i]--;
    permute(res, count, s, level+1);
    count[i]++;
  
  }

}


public static void main(String args[]){

String s = "aabc";

Map<Character, Integer> m = new HashMap<Character, Integer>();
for(int i=0;i<s.length();i++){
   if(m.containsKey(s.charAt(i))){
      int v = m.get(s.charAt(i));
      m.put(s.charAt(i), v+1);

   }else
     m.put(s.charAt(i), 1);

 }  
   
 int[] count = new int[m.size()];
 char[] str = new char[m.size()];
 int index = 0;
 for(Map.Entry<Character, Integer> entry: m.entrySet())
 {
   str[index] = entry.getKey();
   count[index] = entry.getValue();
   index++;
 }
char[] res = new char[s.length()];

 permute(res, count, str, 0);

 }
}
