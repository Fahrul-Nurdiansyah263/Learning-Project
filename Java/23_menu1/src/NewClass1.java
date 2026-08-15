import java.awt.Font;
import javax.swing.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import javax.swing.text.JTextComponent;

public class NewClass1 extends JFrame {
   private JLabel label1, label2, label3, label4, label5, label6, label7, label8, label9, label10, label11, label12, label13;
   private JTextField NamaTamuField, NamaKamarField, HargaKamarField, LamaInapField, NTField, KK, NM, HK, LM, Tanggal, TotalBayar;
   private JComboBox<String> comboBox;
   private JButton calculateButton, clearButton, closeButton;
   
   private String[] kamarList         = {"A001", "M002", "T003"};
   private String[] namaKamarList     = {"Anggrek", "Mawar", "Tulip"};
   private int[]    hargaKamarList    = {1000000, 750000, 500000};
   private String NamaTamuV, KodeKamarV, NamaKamarV, HargaKamarV, LamaInapV, TanggalV, Combo;
   
   LocalDate tanggal = LocalDate.now();
   
   
   public NewClass1() {
      setTitle("Hotel Form");
      setSize(400, 250);
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      
      label13 = new JLabel("HOTEL FAHRUL");
      label1 = new JLabel("Nama Tamu :");
      label2 = new JLabel("Kode Kamar :");
      label3 = new JLabel("Nama Kamar :");
      label4 = new JLabel("Harga Kamar :");
      label5 = new JLabel("Lama Inap :");
      
      label6 = new JLabel("Nama Tamu :");
      label7 = new JLabel("Kode Kamar :");
      label8 = new JLabel("Nama Kamar :");
      label9 = new JLabel("Harga Kamar :");
      label10 = new JLabel("Lama Inap :");
      label11 = new JLabel("Tanggal :");
      label12 = new JLabel("Total Bayar :");
      
      NTField = new JTextField();
      KK = new JTextField();
      NM = new JTextField();
      HK = new JTextField();
      LM = new JTextField();
      Tanggal = new JTextField();
      TotalBayar = new JTextField(20);

      NamaTamuField = new JTextField(20);
      NamaKamarField = new JTextField(5);
      HargaKamarField = new JTextField(10);
      LamaInapField = new JTextField(10);

      comboBox = new JComboBox<String>(kamarList);
      comboBox.addActionListener(e -> {
         int idx = comboBox.getSelectedIndex();
         NamaKamarField.setText(namaKamarList[idx]);
         HargaKamarField.setText(Integer.toString(hargaKamarList[idx]));
      });

       calculateButton = new JButton("Hitung");
       clearButton = new JButton("Hapus");
       closeButton = new JButton("Tutup");
      
      JPanel panel = new JPanel();
        add(label13);  
        add(label1);
        add(NamaTamuField);
        add(label2);
        add(comboBox);
        add(label3);
        add(NamaKamarField);
        add(label4);
        add(HargaKamarField);
        add(label5);
        add(LamaInapField);
        add(label6);
        
        add(label7);
        add(label8);
        add(label9);
        add(label10);
        add(label11);
        add(label12);
        
        add(NTField);
        add(KK);
        add(NM);
        add(Tanggal);
        add(HK);
        add(LM);
        add(TotalBayar);
        
        
        add(calculateButton);
        add(clearButton);
        add(closeButton);
        add(panel);
        setVisible(true);
      
        setTitle("SoalQuiz");
        setBounds(200,200,700,500);
        
        label13.setBounds(215, 15, 500, 25);
        label13.setFont(new Font("Serif", Font.BOLD, 30));
                
        label1.setBounds(15, 55, 125, 25);
        label2.setBounds(15, 90, 125, 25);
        label3.setBounds(15, 125, 125, 25);
        label4.setBounds(15, 160, 125, 25);
        label5.setBounds(15, 195, 125, 25);
        
        NamaTamuField.setBounds(140, 55, 125, 25);
        comboBox.setBounds(140, 90, 125, 25);
        NamaKamarField.setBounds(140, 125, 125, 25);
        HargaKamarField.setBounds(140, 160, 125, 25);
        LamaInapField.setBounds(140, 195, 125, 25);
        
        
        label6.setBounds(325, 50, 125, 25);
        label7.setBounds(325, 85, 125, 25);
        label8.setBounds(325, 120, 125, 25);
        label9.setBounds(325, 155, 125, 25);
        label10.setBounds(325, 190, 125, 25);
        label11.setBounds(325, 225, 125, 25);
        label12.setBounds(325, 260, 125, 25);
        
        NTField.setBounds(450, 50,125 , 25);
        KK.setBounds(450, 85,125 , 25);
        NM.setBounds(450, 120,125 , 25);
        HK.setBounds(450, 155,125 , 25);
        LM.setBounds(450, 190,125 , 25);
        Tanggal.setBounds(450, 225,125 , 25);
        
        TotalBayar.setBounds(450, 260, 125, 25);

        calculateButton.setBounds(15, 300, 80, 25);
        clearButton.setBounds(110, 300, 80, 25);
        closeButton.setBounds(200, 300, 80, 25);
        
         
      calculateButton.addActionListener(e ->{
        int LamaInap = Integer.parseInt(LamaInapField.getText());
        int HargaKamar = Integer.parseInt(HargaKamarField.getText()); 
        int TotalBayar1 = LamaInap*HargaKamar;
        int idx = comboBox.getSelectedIndex();
 
        NamaTamuV = NamaTamuField.getText();
        KodeKamarV = (String) comboBox.getSelectedItem();
        NamaKamarV = NamaKamarField.getText();
        HargaKamarV = HargaKamarField.getText();
        LamaInapV = LamaInapField.getText();
        TanggalV = tanggal.format((DateTimeFormatter.ISO_DATE));

        NTField.setText(NamaTamuV);
        KK.setText(KodeKamarV);
        NM.setText(NamaKamarV);
        HK.setText(HargaKamarV);
        LM.setText(LamaInapV);
        Tanggal.setText(TanggalV);
        TotalBayar.setText(String.valueOf(TotalBayar1));
      });
      
      clearButton.addActionListener(e ->{
          
      });
   }     
   
   public static void main(String[] args) {
      new NewClass1();
   }  
}