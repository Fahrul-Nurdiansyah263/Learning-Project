public class Bilanganprima {
 public static void main(String[] args){
     char tanda[] = new char[101];{
     for (int i = 2; i <= 21; i++)
         if (tanda[i] != '*') {
         System.out.print(i+"|");
         for (int j = i * 2; j <= 21; j+=i) {
         tanda[j]='*';}}
    }
  }
}
