import java.util.*;
import java.math.*;
class Max{
int max;
void Max(int max){
 max = Integer.MIN_VALUE;
}
}
class test{
//static int max = Integer.MIN_VALUE;
static void fun(Max max) {
  max.max = 5;

}

public static void main(String args[]) {
Max t = new Max();
 fun(t);
 System.out.println(t.max);
}
}
