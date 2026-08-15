import java.util.Scanner;
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */

/**
 *
 * @author Fahrul
 */
public class Kue {
    
        public String nama,kue,kodekue;
        public int jumlahbeli,total,harga,kode;
              
        Scanner input = new Scanner(System.in);
    
        
        
        public void inputScanner(){
            System.out.println("Masukan Nama Pembeli : ");
            nama = input.nextLine();
            System.out.println("Masukan Kode [1/B001][2/C001][3/T001] : ");
            kode = input.nextInt();
            System.out.println("Masukan Jumlah Beli : ");
            jumlahbeli = input.nextInt();   
        }
        
    /**
     *
     * @return
     */
    public int getkode(){
            
            if (kode==1){
                kue="B001";
                kodekue="Bolu";
                harga=10000;              
            } 
            else if (kode==2){
                kue="C001";
                kodekue="Cake";
                harga=20000;
            }
         
            else if (kode==3){
                kue="T001";
                kodekue="Tart";
                harga=15000;
            }
            else{
                System.out.println("Maaf, Format Tidak diketahui");
            }
            
          return kode;
        }
    public int gettotal(){
        total=harga*jumlahbeli;
        return total;
    }
    }
