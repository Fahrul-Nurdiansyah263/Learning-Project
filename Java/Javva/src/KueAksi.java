/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Fahrul
 */
public class KueAksi {
    public static void main(String[] args) {
        Kue scan = new Kue();
            
             scan.inputScanner();
            System.out.println("Pembeli        : " +scan.nama);
            System.out.println("Kode Kue       : " +scan.getkode());
            System.out.println("Harga          : " +scan.harga);
            System.out.println("Jumlah Beli    : " +scan.jumlahbeli);
            System.out.println("Total          :Rp." +scan.total);
            
    }
}
