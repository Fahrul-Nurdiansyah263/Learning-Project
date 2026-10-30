/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Fahrul
 */
public class Aksi {
    public static void main(String[] args) {
        
        LatScanner scan=new LatScanner();
        scan.inputScanner();
        System.out.println("PROGRAM NILAI MAHASISWA");
        System.out.println("-------------------------");
        System.out.println("\nNIM : " + scan.getnim());
        System.out.println("Nama Mahasiswa : " + scan.getnama());
        System.out.println("Nilai Absen : " + scan.na);
        System.out.println("Nilai Tugas : " + scan.nt);
        System.out.println("Nilai UTS : " + scan.uts);
        System.out.println("Nilai UAS : " + scan.uas);
        System.out.println("-------------------------");
        System.out.println("Rata - Rata : " + scan.rata());
    }
  
}
