/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package developerperumahan;

/**
 *
 * @author Fahrul
 */
public class Rumah {

    public String lokasi,jog,swim,gym,cara;
    public double hrg=0,hrg_j=0,hrg_s=0,hrg_g=0,biaya=0,total=0;
    private int Biaya;
    
    public void setLokasi(String val){
    lokasi=val;
    }
    public String getLokasi(){
    return lokasi;
    }
    public double getHrg(){
    return hrg;
    }
    public void setSeleksiLok(){
        if(lokasi.equalsIgnoreCase("BLOK A")){
        hrg=2000000; 
        }else if(lokasi.equalsIgnoreCase("BLOK B")){
        hrg=3000000;
        }else if(lokasi.equalsIgnoreCase("BLOK C")){
        hrg=4000000;
        }else{
        hrg=0;
        }
    }
    
    public void setJog(String val){
        jog = val;   
    }
    public double getJog(){
    if(jog.equalsIgnoreCase("Jogging Track")){
    hrg_j=100000;
    }else{
    hrg_j=0;
    }
    return hrg_j;
    }
    
    public void setSwim(String val){
    swim=val;
    }
    public double getSwim(){
    if(swim.equalsIgnoreCase("Swimming Pool")){
    hrg_s=200000;
    }else{
    hrg_s=0;
    }
    return hrg_s;
    }
    public void setGym(String val){
    gym=val;
    }
    public double getGym(){
    if(gym.equalsIgnoreCase("Gymnasium")){
    hrg_g=300000;
    }else{
    hrg_g=0;
    }
    return hrg_g;
    }
    
    public void setCara(String val){
    cara=val;
    }
    public String getCara(){
    return cara;
    }
    public double getBiaya(){
    return biaya;
    }
    public void setSeleksiCara(){
    if(cara.equalsIgnoreCase("BTN")){
    Biaya=10000;
    }else if(cara.equalsIgnoreCase("Other Bank")){
    Biaya=5000;
    }else{
    Biaya=0;
    }
    }
    public double getTotal(){
    return(hrg+hrg_j+hrg_s+hrg_g+biaya);
    } 
}
