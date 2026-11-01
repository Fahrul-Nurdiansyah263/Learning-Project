package latihan5;

import java.util.*;


class ArrayPlg
{
public static void main(String[] args)
{
Scanner input=new Scanner(System.in);
int i,jd;
String [] nm=new String[10];
String [] kp=new String[10];
String [] almt=new String[10];
String tanya="";
do{
System.out.print("masukan jumlah data :");
jd=input.nextInt();
for(i=1;i<=jd;i++)
{
System.out.println(" Data Ke- " +i);
System.out.print(" kode pelanggan :");
kp[i]=input.next();
System.out.print(" nama pelanggan :");
nm[i]=input.next();
System.out.print(" alamat pelanggan :");
almt[i]=input.next();
}
System.out.println("\n\n DATA PELANGGAN PT. SENTOSA JAYA ");
System.out.println(" JL. Sagu No.27A Kebagusan Jakarta selatan ");
System.out.println("==============================================================");
//System.out.println("No \t Kode Pelanggan \t Nama Pelanggan\t\t Alamat");
//System.out.println("==============================================================");
for (i=1;i<=jd;i++)
{
System.out.println(" Data Ke- " +i);
System.out.println("Kode pelanggan :" +kp[i]);
System.out.println("nama pelanggan :" +nm[i]);
System.out.println("Alamat pelanggan :" +almt[i]);
System.out.println("==============================================================");
//System.out.println(i+"\t\t"+kp[i]+"\t\t\t\t\t"+nm[i]+"\t\t\t\t\t"+almt[i]);
}
//System.out.println("==============================================================");
System.out.print("Mau input data lagi :");tanya=input.next();
}while(tanya.equals("Y") ||tanya.equals("y"));
 }
}

