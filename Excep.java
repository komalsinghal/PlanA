import java.util.*;
import java.io.*;
public class Excep {

static int fun() {

try {
int k = 1/0;
} catch(Exception e){
}

return 1;

}

public static void main(String args[]) {

int k = fun();
System.out.println(k);

}
}
