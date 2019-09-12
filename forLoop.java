import java.util.*;
class forLoop {


static int n = 4;
public static void main(String[] args){
 for (int gap = 1; gap < n; ++gap) 
        { 
            for (int i = 0, j = gap; j < n; ++i, ++j)  
            { 
                for (int g = 0; g < gap; g++)  
                { 
                    int k = i+g;

                   System.out.println(gap + "  " + i +  "  " + k + "  " + j  + "  " +  g);
                   System.out.println(i+ " " + j);
                 }
             }
          }


}
}
