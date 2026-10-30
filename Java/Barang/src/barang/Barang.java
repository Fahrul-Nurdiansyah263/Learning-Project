/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package barang;

/**
 *
 * @author Fahrul
 */
public class Barang {

    /**
     * @param args the command line arguments
     */
    
    public String kd,nm;

    public String getKd() {
        return kd;
    }

    public void setKd(String val) {
        kd = val;
    }
    public int jml;
    public double hrg,ttl,ub,uk;

    public double getHrg() {
        return hrg;
    }

    public void setHrg(double val) {
        hrg = val;
    }

    public void setNm(String val){
    nm=val;
    }
    public String getNm(){
    return nm;
    }
    public void setHrg(Double val){
    hrg=val;
    }
    public void setJml(int val){
    jml=val;
    }
    public int getJml(){
    return jml; 
    }
    public double getTot(){
    ttl=hrg*jml;
    return(ttl);
    }
    public void setUb(double val){
    ub=val;
    }
    public double getUb(){
    return ub;
    }
    public double getUk(){
    return(ub-ttl);
    }
    
    public void setSeleksiKd(){
        if(kd.equalsIgnoreCase("B001")){
        nm="Pensil";
        hrg=3000;
        }else if (kd.equalsIgnoreCase("B002")){
        nm="Buku";
        hrg=5000;
        }else if (kd.equalsIgnoreCase("B003")){
        nm="Penggaris";
        hrg=1000;
        }else if (kd.equalsIgnoreCase("B004")){
        nm="Penghapus";
        hrg=500;
        }else{
        nm="";
        hrg=0;
        }  
    }
}
