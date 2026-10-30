import 'package:cloud_firestore/cloud_firestore.dart';
import 'package:flutter/material.dart';
import 'modul.dart';
import 'ai.dart';

class CRUDEoperation extends StatefulWidget {
  const CRUDEoperation({super.key});

  @override
  State<CRUDEoperation> createState() => _MyWidgetState();
}

class _MyWidgetState extends State<CRUDEoperation> {
  final TextEditingController namaController = TextEditingController();
  final TextEditingController modulController = TextEditingController();

  final CollectionReference myItems =
      FirebaseFirestore.instance.collection("CRUDitems");

  Future<void> create() async {
    return showDialog(
        context: context,
        builder: (BuildContext context) {
          return myDialogBox(
            nama_modul: "Tambahkan Modul",
            isi_modul: "Tambah",
            onpressed: () {
              String nama_modul = namaController.text;
              String isi_modul = modulController.text;
              addItems(nama_modul, isi_modul);
              Navigator.pop(context);
            },
          );
        });
  }

  void addItems(String nama_modul, String isi_modul) {
    myItems.add({
      'nama_modul': nama_modul,
      'isi_modul': isi_modul,
    });
  }

  Future<void> update(DocumentSnapshot documentSnapshot) async {
    return showDialog(
        context: context,
        builder: (BuildContext context) {
          return myDialogBox(
            nama_modul: "Update Modul",
            isi_modul: "Update",
            onpressed: () async {
              String nama_modul = namaController.text;
              String isi_modul = modulController.text;
              await myItems.doc(documentSnapshot.id).update({
                'nama_modul': nama_modul,
                'isi_modul': isi_modul,
              });
              namaController.text = '';
              modulController.text = '';
              Navigator.pop(context);
            },
          );
        });
  }

  Future<void> delete(String productId) async {
    await myItems.doc(productId).delete();
    ScaffoldMessenger.of(context).showSnackBar(const SnackBar(
        backgroundColor: Colors.red,
        duration: Duration(milliseconds: 500),
        content: Text("Delete Successfully")));
  }

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      backgroundColor: Colors.blue[100],
      appBar: AppBar(
          backgroundColor: Colors.blue,
          title: const Center(
            child: Text(
              "Cognitio Augmentum",
              style: TextStyle(
                color: Colors.white,
                fontSize: 20,
              ),
            ),
          )),
      body: StreamBuilder(
        stream: myItems.snapshots(),
        builder: (context, AsyncSnapshot<QuerySnapshot> streamSnapshot) {
          if (streamSnapshot.hasData) {
            return ListView.builder(
              itemCount: streamSnapshot.data!.docs.length,
              itemBuilder: (context, index) {
                final DocumentSnapshot documentSnapshot =
                    streamSnapshot.data!.docs[index];
                return Padding(
                  padding: const EdgeInsets.all(8.0),
                  child: Material(
                    elevation: 5,
                    borderRadius: BorderRadius.circular(20),
                    child: Padding(
                      padding: const EdgeInsets.all(8.0),
                      child: ListTile(
                        title: Text(
                          documentSnapshot['nama_modul'],
                          style: const TextStyle(
                            fontWeight: FontWeight.bold,
                            fontSize: 20,
                          ),
                        ),
                        trailing: SizedBox(
                          width: 100,
                          child: Row(
                            mainAxisAlignment: MainAxisAlignment
                                .end, 
                            children: [
                              IconButton(
                                onPressed: () => update(documentSnapshot),
                                icon: const Icon(Icons.edit),
                              ),
                              IconButton(
                                onPressed: () => delete(documentSnapshot.id),
                                icon: const Icon(Icons.delete),
                              ),
                            ],
                          ),
                        ),
                        onTap: () {
                          Navigator.push(
                            context,
                            MaterialPageRoute(
                              builder: (context) => DisplayDataPage(
                                data: documentSnapshot.data()
                                    as Map<String, dynamic>,
                              ),
                            ),
                          );
                        },
                      ),
                    ),
                  ),
                );
              },
            );
          }
          return const Center(
            child: CircularProgressIndicator(),
          );
        },
      ),
      floatingActionButton: Stack(
        clipBehavior: Clip.none,
        children: [
          // Tombol pertama (Add)
          Positioned(
            bottom: 10,
            right: 10,
            child: FloatingActionButton(
              onPressed: create,
              backgroundColor: Colors.blue,
              child: const Icon(
                Icons.add,
                color: Colors.white,
              ),
            ),
          ),
          // Tombol kedua (AI)
          Positioned(
            bottom: 80,
            right: 10,
            child: FloatingActionButton(
              onPressed: () {
                Navigator.push(
                  context,
                  MaterialPageRoute(builder: (context) => ChatScreen()),
                );
              },
              child: Text("AI"),
            ),
          ),
        ],
      ),
    );
  }

  Dialog myDialogBox({
    required String nama_modul,
    required String isi_modul,
    required VoidCallback onpressed,
  }) =>
      Dialog(
        shape: RoundedRectangleBorder(
          borderRadius: BorderRadius.circular(10),
        ),
        child: Container(
          decoration: BoxDecoration(
              color: Colors.white, borderRadius: BorderRadius.circular(10)),
          padding: const EdgeInsets.symmetric(horizontal: 20, vertical: 20),
          child: Column(
            mainAxisSize: MainAxisSize.min,
            children: [
              Row(
                mainAxisAlignment: MainAxisAlignment.spaceBetween,
                children: [
                  Container(),
                  Text(
                    nama_modul,
                    style: const TextStyle(
                        fontWeight: FontWeight.bold, fontSize: 18),
                  ),
                  IconButton(
                      onPressed: () {
                        Navigator.pop(context);
                      },
                      icon: const Icon(Icons.close))
                ],
              ),
              TextField(
                maxLines: null, // Membuat agar input bisa lebih banyak baris
                textAlign: TextAlign.start, // Agar teks dimulai dari kiri
                textAlignVertical: TextAlignVertical.top,
                controller: namaController,
                decoration: const InputDecoration(
                    labelText: "Masukan Nama Modul",
                    border: OutlineInputBorder()),
              ),
              const SizedBox(height: 10),
              Container(
                height: 180.0,
                padding: EdgeInsets.only(left: 10.0),
                decoration: BoxDecoration(
                    border: Border.all(),
                    borderRadius: BorderRadius.circular(10)),
                child: TextField(
                  controller: modulController,
                  decoration: InputDecoration(
                    border: InputBorder.none,
                    hintText: 'Masukan Isi Modul',
                    hintStyle: TextStyle(
                      color: Colors.grey[500], // Warna teks bayangan
                      fontSize: 16.0,
                      fontWeight: FontWeight.bold,
                    ),
                  ),
                  maxLines: null, // Membuat agar input bisa lebih banyak baris
                  textAlign: TextAlign.start, // Agar teks dimulai dari kiri
                  textAlignVertical: TextAlignVertical.top,
                ),
              ),
              const SizedBox(height: 20),
              ElevatedButton(
                onPressed: onpressed,
                child: Text(isi_modul),
                style: ElevatedButton.styleFrom(
                  minimumSize: const Size(double.infinity, 40),
                ),
              ),
              const SizedBox(height: 10),
            ],
          ),
        ),
      );
}
