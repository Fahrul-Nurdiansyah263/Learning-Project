import java.util.Scanner;
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Fahrul
 */
public class LatScanner {
    
        
        public String nim, nama;
        public double na;
        public int nt, uts, uas;
        Scanner input = new Scanner(System.in);

        public String getnim(){
            return nim;
         }
        public String getnama(){
            return nama;
        }

        public void inputScanner(){
            System.out.println("Masukan NIM : ");
            nim = input.nextLine();
            System.out.println("Masukan Nama : ");
            nama = input.nextLine();
            System.out.println("Masukan Nilai Absen : ");
            na = input.nextDouble();
            System.out.println("Masukan Nilai Tugas : ");
            nt = input.nextInt();
            nama = input.nextLine();
            System.out.println("Masukan Nilai UTS : ");
            uts = input.nextInt();
            System.out.println("Masukan Nilai UAS : ");
            uas = input.nextInt();
        }

       public double rata(){
           return (0.1*na)+(0.2*nt)+(0.3+uts)+(0.4*uas);
       }
    }

