import java.util.*;

@SuppressWarnings("unchecked")
class permString{

static String swap(String s, int i , int j) {

char arr[] = s.toCharArray();
char temp = arr[i];
arr[i] = arr[j];
arr[j] = temp;
return String.valueOf(arr);
}

static void fun(String s , int index , int l, HashSet set){
  if(index == l) {
  // set.add(s);
   System.out.println(s);
  }
   //System.out.println(s);
 else{
   for(int i = index ;i<l;i++){
      if(index == i || ( index != i  && s.charAt(i) != s.charAt(index))){
 
       s = swap(s, index, i);
//        System.out.println("i " + i +" index " + index + "s " + s);
       fun(s, index+1, l,set);
      s = swap(s,index,i);
       
    }        

   
   }

  }
  
}

public static void main(String args[]){
  String s = "abcc";
  HashSet set = new HashSet<String>();
  fun(s,0, s.length(), set);   

  Iterator value = set.iterator();
  while(value.hasNext()){
    System.out.println(value.next());
  }


}

}
