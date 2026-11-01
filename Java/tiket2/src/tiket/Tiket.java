package tiket;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Axioo Class Program
 */
public class Tiket {
    public String kd,nm,paket1,paket2,paket3,cara;
    public int jml,jb1,jb2,jb3;
    public double hrg,ttl,hrg_1=0,hrg_2=0,hrg_3=0,ttlp1,ttlp2,ttlp3,ttlp,biaya=0,ttlall,ub,uk,bca,bri,bni,obank;
    
    public String getKd() {
        return kd;
    }

    public void setKd(String val) {
        kd = val;
    }
    
    public void setSeleksiKd(){
        if(kd.equalsIgnoreCase("T001")){
            nm="VIP Barat";
            hrg=4250000;
        }else if(kd.equalsIgnoreCase("T002")){
            nm="VIP Timur";
            hrg=4250000;
        }else if(kd.equalsIgnoreCase("T003")){
            nm="Category 1";
            hrg=2500000;
        }else if(kd.equalsIgnoreCase("T004")){
            nm="Category 2";
            hrg=1300000;
        }else if(kd.equalsIgnoreCase("T005")){
            nm="Category 3";
            hrg=600000;
        }else{
            nm="";
            hrg=0;
        }
    }

    public String getNm() {
        return nm;
    }

    public void setNm(String val) {
        nm = val;
    }

    public int getJml() {
        return jml;
    }

    public void setJml(int val) {
        jml = val;
    }

    public double getHrg() {
        return hrg;
    }

    public void setHrg(double val) {
        hrg = val;
    }

    public double getTot() {
        ttl=hrg*jml;
        return(ttl);
    }
    
    public void setPaket1(String val){
        paket1=val;
    }
    
    public double getPaket1(){
        if(paket1.equalsIgnoreCase("Paket 1")){
            hrg_1=60000;
        }else{
            hrg_1=0;
        }
        return hrg_1;
    }

    public int getJb1() {
        return jb1;
    }

    public void setJb1(int val) {
        jb1 = val;
    }

    public double getTtlp1() {
        ttlp1=hrg_1*jb1;
        return(ttlp1);
    }

    public void setPaket2(String val){
        paket2=val;
    }
    
    public double getPaket2(){
       if(paket2.equalsIgnoreCase("Paket 2")){ 
           hrg_2=45000;
       }else{
           hrg_2=0;
       }
       return hrg_2;
    }

    public int getJb2() {
        return jb2;
    }

    public void setJb2(int val) {
        jb2 = val;
    }
    
    public double getTtlp2() {
        ttlp2=hrg_2*jb2;
        return(ttlp2);
    }

    public void setPaket3(String val){
        paket3=val;
    }
    
    public double getPaket3(){
       if(paket3.equalsIgnoreCase("Paket 3")){ 
           hrg_3=20000;
       }else{
           hrg_3=0;
       }
       return hrg_3;
    }

    public int getJb3() {
        return jb3;
    }

    public void setJb3(int val) {
        jb3 = val;
    }
    
    public double getTtlp3() {
        ttlp3=hrg_3*jb3;
        return(ttlp3);
    }

    public double getTtlp() {
        ttlp = (ttlp1+ttlp2+ttlp3);
        return(ttlp);
    }

    public String getCara() {
        return cara;
    }

    public void setCara(String val) {
        cara = val;
    }

    public double getBiaya() {
        return biaya;
    }

    public void setSeleksiCara(){
        if(cara.equalsIgnoreCase("BCA")){
            biaya=5000;
        }else if(cara.equalsIgnoreCase("BRI")){
            biaya=7000;
        }else if(cara.equalsIgnoreCase("BNI")){
            biaya=6000;
        }else if(cara.equalsIgnoreCase("Other Bank")){
            biaya=10000;
        }else{
            biaya=0;
        }
    }

    public double getTtlall() {
        return(ttl+ttlp+biaya);
    }
    
    public double getUb() {
        return ub;
    }

    public void setUb(double val) {
        ub = val;
    }

    public double getUk() {
        uk = (ub-ttlall);
        return uk;
    }    
}
