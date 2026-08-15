public class penjumlahanganjil
{
     public static void main(String [] args){
  System.out.println("Bilangan Ganjil antara 1-20 = ");
  System.out.println("-----");
        int i=1, ganjil=1,jumlah=0;

            while(i<=10){

                System.out.println(i+".  "+ganjil);
                jumlah += ganjil;
                ganjil = ganjil+2;
                i++;
            }
            System.out.println("-----");
            System.out.println("Jumlah => "+jumlah);
     }
 }
