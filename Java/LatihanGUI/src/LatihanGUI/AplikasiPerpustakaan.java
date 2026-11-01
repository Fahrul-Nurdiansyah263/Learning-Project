package LatihanGUI;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
/**
 *
 * @author Fahrul
 */
public class AplikasiPerpustakaan {
    public static void main(String[] args) {
        //===========BAGIAN CONTAINER===============
        //membuat objek Container dari jframe
        JFrame form = new JFrame("Aplikasi Perpustakaan");
        //ukuran form
        form.setSize(400,550);
        //mengatur fungsi close form -> posisi pojok kanan atas
        form.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //agar form ditengah
        form.setLocationRelativeTo(null);
        //mengatur layout secara manual
        form.setLayout(null);
        //menampilkan form
        form.setVisible(true);
        //==========END BAGIAN CONTAINER==============
        
        //=============BAGIAN COMPONENT===============
        //membuat objek komponen
        JLabel labelJudul = new JLabel("Aplikasi Perpustakaan");
        //mengatur posisi dan ukuran dari komponen
        labelJudul.setBounds(220, 30, 150, 30);
        //memasukan komponen ke form/container
        form.add(labelJudul);
        
        JLabel labelKodeBuku = new JLabel("Kode Buku");
        labelKodeBuku.setBounds(20, 80, 150, 25);
        form.add(labelKodeBuku);
        
        JTextField txtKodeBuku = new JTextField();
        txtKodeBuku.setBounds(150, 80, 150, 25);
        form.add(txtKodeBuku);
        
        JLabel labelNamaBuku = new JLabel("Nama Buku");
        labelNamaBuku.setBounds(20, 110, 150, 25);
        form.add(labelNamaBuku);
        
        JTextField txtNamaBuku = new JTextField();
        txtNamaBuku.setBounds(20, 110, 150, 25);
        form.add(txtNamaBuku);
        
        
    }
    
}
