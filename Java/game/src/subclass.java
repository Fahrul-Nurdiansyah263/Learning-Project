/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author ALFITO
 */
public class subclass {
    public String pembayaran, hargadm;
    public Integer diskon;
    public Integer kembalian,hrg;
    
    
    
    public Integer getKembalian() {
        return kembalian;
    }

    public void setKembalian(Integer val) {
        kembalian = val;
    }
    
    
     public void setSeleksiPembayaran(){
     if (pembayaran.equalsIgnoreCase("Pulsa"))
     {
         diskon = 2000;
     }
     else if (pembayaran.equalsIgnoreCase("BCA"))
     {
         diskon = 3000;
     }
      else if (pembayaran.equalsIgnoreCase("OVO"))
     {
         diskon = 5000;
     }
      else 
     {
         diskon = 0;
     }  
 }
         public String getHargadm() {
         return hargadm;
    }

    public void setHargadm(String val) {
        hargadm = val;
    }

    public String getPembayaran() {
        return pembayaran;
    }

    public void setPembayaran(String val) {
        pembayaran = val;
    }

    public Integer getDiskon() {
        return diskon;
    }

    public void setDiskon(Integer val) {
        diskon = val;
    }
}
    

