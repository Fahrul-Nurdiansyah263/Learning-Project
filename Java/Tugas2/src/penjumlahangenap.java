public class penjumlahangenap
{
     public static void main(String [] args){
  System.out.println("Bilangan Genap antara 1-20 = ");
  System.out.println("-----");
        int i=1, genap=2,jumlah=0;

            while(i<=10){

                System.out.println(i+".  "+genap);
                jumlah += genap;
                genap = genap+2;
                i++;
            }
            System.out.println("-----");
            System.out.println("Jumlah => "+jumlah);
     }
 }