import java.util.*;

/*class comparableclass implements Comparator<Integer> {

public int compare(Integer a , Integer b){
if(a<b)  return -1;
else if(a>b) return 1;
else return 0;
}

}*/


class pq{

public static void main(String args[]){
  PriorityQueue<Integer> pq = new PriorityQueue<Integer>(4);
 pq.add(3);
 pq.add(6);
pq.add(1);
pq.add(4);

Iterator value = pq.iterator();
while(value.hasNext()){
System.out.println(value.next());

}


while(!pq.isEmpty()){
System.out.println(pq.poll());

} 



}

}
