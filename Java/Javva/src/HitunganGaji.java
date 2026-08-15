/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
 import java.util.Scanner;

/**
 *
 * @author user
 */
public class HitunganGaji {
  public static void main(String args[]){
    HitunganGajiAksi dg = new HitunganGajiAksi();
    Scanner input = new Scanner(System.in);
       
    System.out.println("##  Program Hitung Honore Karyawan Kontrak##");
    System.out.println("PT. DINGIN DAMAI");
    System.out.println();
     
    String nama, golongan, pendidikan;
    int jam_kerja = 0;
    double honor = 300000, total_upah, gol_jab, gol_pen, honor_lembur;
     
    System.out.print("Nama Karyawan: ");
    nama = input.nextLine();
     
    System.out.print("Golongan: ");
    golongan = input.next();
    
    System.out.print("Pendidikan (SMU/D3/S1): ");
    pendidikan = input.next();
    
    System.out.print("Jumlah jam kerja: ");
    jam_kerja = input.nextInt();    
     
    System.out.println();
     
    switch (golongan){
        case "1" -> {
            gol_jab = 0.05* honor;
            dg.setTotal_jabatan(gol_jab);
          }
        case "2" -> {
            gol_jab = 0.1*honor;
            dg.setTotal_jabatan(gol_jab);
          }
        case "3" -> {
            gol_jab = 0.15*honor;
            dg.setTotal_jabatan(gol_jab);
          }
      default -> System.out.println("perintah salah");
    }    
    
    switch(pendidikan){
        case "SMU" -> {
            gol_pen = 0.025 * honor;
            dg.setTotal_pendidikan(gol_pen);
          }
        case"D3" -> {
            gol_pen = 0.05 * honor;
            dg.setTotal_pendidikan(gol_pen);
          }
        case "S1" -> {
            gol_pen = 0.075 * honor;
            dg.setTotal_pendidikan(gol_pen);
          }
        default -> System.out.println("perintah salah");   
    }
      
   
    if (jam_kerja > 8) {
       honor_lembur = 2500 * (jam_kerja - 8);
       dg.setTotal_lembur(honor_lembur);
    }
    else{
        honor_lembur = 0;
        dg.setTotal_lembur(honor_lembur);
    }
    
    total_upah = honor + dg.getTotal_jabatan() + dg.getTotal_pendidikan()+ dg.getTotal_lembur();
    
      System.out.println("Karyawan Yang bernama: "+nama);
      System.out.println("Honor diterima :");
      System.out.println("Honor Tetap          : "+ honor);
      System.out.println("Tunjangan Jabatan    : "+dg.getTotal_jabatan());
      System.out.println("Tunjangan Pendidikan : "+dg.getTotal_pendidikan());
      System.out.println("Honor Lembur         : "+dg.getTotal_lembur());
      System.out.println("=============================================");
      System.out.println("Honor Yang di terima : "+total_upah);
    
  }
}
