package ptpermata;
import java.time.LocalDate;
import java.util.Scanner;

/**
 *
 * @author Fahrul
 */
public class PTPERMATA {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner input = new Scanner (System.in);
        
        String nampet;
        int i, n, totsemua=0;
        LocalDate tanggal = LocalDate.now();
        String kodebarang[]=new String[10];
        String namabarang[]=new String[10];
        int jumlahbarang[]=new int[10];
        int harga[]=new int[10];
        int totharga[]=new int [10];
        
        System.out.println("              PT.PERMATA'PRATAMA' ");
        System.out.println("==============================================");
        System.out.print("Masukan Nama Petugas : ");
        nampet=input.nextLine();
        System.out.println("Tanggal              : "+tanggal);
      
        System.out.print("Jumlah Data Yang Akan Dimasukan     : ");
        n=input.nextInt();
        System.out.println("==============================================");
        
        for (i=0; i<n; i++){
            int number = i+1;
            System.out.print("Data Ke-"+number+"\n");
            System.out.print("Kode Barang [P001/V001/M001]  : ");
            kodebarang[i]=input.next();
            System.out.print("Jumlah Barang                 : ");
            jumlahbarang[i]=input.nextInt();
            
            if (kodebarang[i].equals("P001")){
                harga[i]=700000;
                namabarang[i]="Printer";
            }
            else if (kodebarang[i].equals("V001")){
                harga[i]=750000;
                namabarang[i]="VGA Card";
            }
            else if (kodebarang[i].equals("M001")){
                harga[i]=950000;
                namabarang[i]="Motherboard";
            }
            else {
                namabarang[i] = "-";
                harga[i] = 0;
            }
            totharga[i]=harga[i]*jumlahbarang[i];
            totsemua=(totsemua+totharga[i]);
            
        }
        System.out.println("====================================================================================================================");
        System.out.println("\t\t\t\tPT.PERMATA 'PRATAMA' ");
        System.out.println("====================================================================================================================");
        System.out.println("Nama Petugas    : "+nampet+"\t\t"+"Tanggal       :  "+tanggal);
        System.out.println("Jumlah Data     : "+n);
        
        System.out.println("====================================================================================================================");
        System.out.println("Data Ke-\tKode Barang\tNama Barang\t\tHarga Barang\tJumlah Barang\tTotal Harga ");
        System.out.println("====================================================================================================================");
        
       for (i=0; i<n; i++){
            int number = i+1;
            System.out.println(+number+"\t\t"+kodebarang[i]+"\t\t"+namabarang[i]+"\t\t\t"+harga[i]+"\t\t"+jumlahbarang[i]+"\t\t"+totharga[i]);
        }
       
        System.out.println("====================================================================================================================");
        System.out.println("Total Pendapatan Pada Tanggal "+tanggal+" adalah sebesar Rp."+totsemua);
        
    }
    
}
