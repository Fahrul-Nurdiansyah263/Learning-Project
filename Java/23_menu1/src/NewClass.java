/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
import java.time.LocalDate;
import java.util.Scanner;
/**
 *
 * @author Fahrul
 */
public class NewClass {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // Tampilan input
        System.out.println("PT. PERMATA \"PRATAMA\"");
        System.out.println("+ + + + + + + + + + + + + + + + + + + + + + + + + + + + + + + + + + + + + +");
        System.out.print("Masukan Nama Petugas : ");
        String namaPetugas = input.nextLine();
        LocalDate tanggal = LocalDate.now();
        System.out.println("Tanggal : " + tanggal);
        System.out.print("Jumlah Data yang akan di masukan : ");
        int jumlahData = input.nextInt();

        // Array untuk menyimpan data penjualan
        String[] kodeBarang = new String[jumlahData];
        String[] namaBarang = new String[jumlahData];
        int[] hargaBarang = new int[jumlahData];
        int[] jumlahBarang = new int[jumlahData];
        int[] totalHarga = new int[jumlahData];

        // Memasukkan data penjualan
        for (int i = 0; i < jumlahData; i++) {
            System.out.println("- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -");
            System.out.print("Data Ke-" + (i+1) + "\nKode Barang : ");
            kodeBarang[i] = input.next();
            switch (kodeBarang[i]) {
                case "P001":
                    namaBarang[i] = "Printer";
                    hargaBarang[i] = 700000;
                    break;
                case "V001":
                    namaBarang[i] = "VGA Card";
                    hargaBarang[i] = 75000;
                    break;
                case "M001":
                    namaBarang[i] = "Motherboard";
                    hargaBarang[i] = 950000;
                    break;
                default:
                    namaBarang[i] = "-";
                    hargaBarang[i] = 0;
                    break;
            }
            System.out.print("Jumlah : ");
            jumlahBarang[i] = input.nextInt();
            totalHarga[i] = hargaBarang[i] * jumlahBarang[i];
        }

        // Tampilan output
        System.out.println("\nPT. PERMATA \"PRATAMA\"");
        System.out.println("+ + + + + + + + + + + + + + + + + + + + + + + + + + + + + + + + + + + + + +");
        System.out.println("Nama Petugas : " + namaPetugas + " Tanggal : " + tanggal);
        System.out.println("Jumlah Data yang di masukan : " + jumlahData);
        System.out.println("- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -");
        System.out.printf("%-3s %-20s %-12s %-15s %s\n", "No", "Kode Barang", "Nama Barang", "Harga Barang", "Jumlah Barang", "Total Harga");
        }
}           
    
    

