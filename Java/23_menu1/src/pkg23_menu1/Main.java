package pkg23_menu1;
import java.util.Scanner;
/**
 *
 * @author Fahrul
 */
public class Main {

   
    public static void main(String[] args) {
        Scanner input = new Scanner (System.in);
        int pilihan, harga=0, porsi;
        String menu = null;
        System.out.println("---- Menu Makanan ----");
        System.out.println("1. bakso\n2. Mie Ayam\n3. Rujak");
        System.out.println("Pilihan \t: ");
        pilihan = input.nextInt();
        if (pilihan == 1){
            menu = "Bakso";
            harga = 8000;
        } else if(pilihan == 2){
            menu = "Mie Ayam";
            harga = 9000;
        }else if (pilihan == 3){
            menu = "Rujak";
            harga = 6000;
        }
        if(menu == null){
            System.out.println("Pilihan Salah");
        }else
            System.out.println("Jml Porsi \t: ");
            porsi = input.nextInt();
            System.out.println("==============");
            System.out.println("Menu Dipesan :");
            System.out.println(menu+" - Rp. "+harga+"/porsi");
            harga = harga * porsi;
            System.out.println("Total Bayar \t: Rp. "+harga);
    }
    
}
