import 'package:flutter/material.dart';

class DisplayDataPage extends StatelessWidget {
  final Map<String, dynamic> data;  // Terima data dari halaman sebelumnya

  const DisplayDataPage({super.key, required this.data});

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        title: Text(data['nama_modul'] ?? 'Nama Modul tidak tersedia'),  // Mengganti dengan nama_modul
        centerTitle: true,
        backgroundColor: Colors.blue,
      ),
      body: SingleChildScrollView(  // Wrap the body in SingleChildScrollView
        padding: const EdgeInsets.all(16.0),
        child: Column(
          crossAxisAlignment: CrossAxisAlignment.start,
          children: [
            Text(
              data['isi_modul'] ?? 'Isi Modul tidak tersedia',
              style: const TextStyle(fontSize: 16),
              textAlign: TextAlign.justify,  // Mengatur teks agar rata kiri-kanan
            ),
          ],
        ),
      ),
    );
  }
}
