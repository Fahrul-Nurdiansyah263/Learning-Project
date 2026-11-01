public class Fibonacci {
public static void main(String[] args) {
    int fibonacciDeret =10;
    int a=0;
    int b=1;
    for ( int i=1; i<= fibonacciDeret; i++)
    {
        System.out.println("Fibonacci :" +a);
        a=a+b;
        b=a-b;
    }
  }
}