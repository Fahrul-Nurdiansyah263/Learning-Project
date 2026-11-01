import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Form extends JFrame implements ActionListener {

    JLabel nameLabel, roomCodeLabel, roomNameLabel, roomPriceLabel, stayLengthLabel, totalPriceLabel;
    JTextField nameField, roomNameField, roomPriceField, stayLengthField, totalPriceField;
    JComboBox<String> roomCodeCombo;
    JButton calculateButton, clearButton, closeButton;
    

    public Form() {

        nameLabel = new JLabel("Nama Tamu");
        roomCodeLabel = new JLabel("Kode Kamar");
        roomNameLabel = new JLabel("Nama Kamar");
        roomPriceLabel = new JLabel("Harga Kamar");
        stayLengthLabel = new JLabel("Lama Inap");
        totalPriceLabel = new JLabel("Total Bayar");

        nameField = new JTextField(10);
        roomNameField = new JTextField(10);
        roomPriceField = new JTextField(10);
        stayLengthField = new JTextField(10);
        totalPriceField = new JTextField(10);

        String[] roomCode = {"A001", "M002", "T003"};
        roomCodeCombo = new JComboBox<>(roomCode);
        roomCodeCombo.addActionListener(this);
        calculateButton = new JButton("Hitung");
        clearButton = new JButton("Hapus");
        closeButton = new JButton("Tutup");

        JPanel panel = new JPanel(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();

        c.gridx = 0;
        c.gridy = 0;
        c.anchor = GridBagConstraints.WEST;
        panel.add(nameLabel, c);

        c.gridx = 1;
        panel.add(nameField, c);

        c.gridx = 0;
        c.gridy = 1;
        panel.add(roomCodeLabel, c);

        c.gridx = 1;
        panel.add(roomCodeCombo, c);

        c.gridx = 0;
        c.gridy = 2;
        panel.add(roomNameLabel, c);

        c.gridx = 1;
        panel.add(roomNameField, c);

        c.gridx = 0;
        c.gridy = 3;
        panel.add(roomPriceLabel, c);

        c.gridx = 1;
        panel.add(roomPriceField, c);

        c.gridx = 0;
        c.gridy = 4;
        panel.add(stayLengthLabel, c);

        c.gridx = 1;
        panel.add(stayLengthField, c);

        c.gridx = 0;
        c.gridy = 5;
        panel.add(totalPriceLabel, c);

        c.gridx = 1;
        panel.add(totalPriceField, c);

        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 10));
        buttonPanel.add(calculateButton);
        buttonPanel.add(clearButton);
        buttonPanel.add(closeButton);

        c.gridx = 0;
        c.gridy = 6;
        c.gridwidth = 2;
        c.anchor = GridBagConstraints.CENTER;
        panel.add(buttonPanel, c);

        this.add(panel);
        this.setTitle("Form Hotel");
        this.setSize(400, 300);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        String roomCode = (String) roomCodeCombo.getSelectedItem();
        String roomName = "";
        int roomPrice = 0;

        switch (roomCode) {
            case "A001":
                roomName = "Anggrek";
                roomPrice = 1000000;
                break;
                case "M002":
                roomName = "Mawar";
                roomPrice = 750000;
                break;
                case "T003":
                roomName = "Tulip";
                roomPrice = 500000;
                break;
        }
        // aksi yang dilakukan ketika tombol "Hitung" ditekan
calculateButton.addActionListener((ActionEvent e1) -> {
    // ambil nilai lama inap dari text field
    int lamaInap = Integer.parseInt(stayLengthField.getText());
    
    // ambil nilai harga kamar dari text field
    int hargaKamar = Integer.parseInt(roomPriceField.getText());
    
    // hitung total bayar
    int totalBayar = lamaInap * hargaKamar;
    
    // tampilkan hasil perhitungan di output konsol
    System.out.println("Total Bayar: " + totalBayar);
    
    // tampilkan hasil perhitungan di text field "Total Bayar"
    totalPriceField.setText(String.valueOf(totalBayar));
        });
                roomNameField.setText(roomName);
    roomPriceField.setText(String.valueOf(roomPrice));
}

public static void main(String[] args) {
    new Form();
}
}