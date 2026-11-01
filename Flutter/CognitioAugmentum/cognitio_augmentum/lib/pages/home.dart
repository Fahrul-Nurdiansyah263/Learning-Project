import 'package:cloud_firestore/cloud_firestore.dart';
import 'package:cognitio_augmentum/pages/employe.dart';
import 'package:cognitio_augmentum/service/database.dart';
import 'package:flutter/material.dart';
import 'package:cognitio_augmentum/pages/ai.dart';

class Home extends StatefulWidget {
  const Home({super.key});

  @override
  State<Home> createState() => _HomeState();
}

class _HomeState extends State<Home> {
  TextEditingController name_modulcontroller = new TextEditingController();
  TextEditingController isi_modulcontroller = new TextEditingController();

  Stream? EmployeStream;

  getontheload() async {
    EmployeStream = await DatabaseMetods().getEmployeDetails();
    setState(() {});
  }

  @override
  void initState() {
    getontheload();
    super.initState();
  }

  Widget allEmployeDetails() {
    return StreamBuilder(
        stream: EmployeStream,
        builder: (context, AsyncSnapshot snapshot) {
          return snapshot.hasData
              ? ListView.builder(
                  itemCount: snapshot.data.docs.length,
                  itemBuilder: (context, index) {
                    DocumentSnapshot ds = snapshot.data.docs[index];
                    return Container(
                      margin: EdgeInsets.only(bottom: 20.0),
                      child: Material(
                        elevation: 5.0,
                        borderRadius: BorderRadius.circular(10),
                        child: Container(
                          padding: EdgeInsets.all(20),
                          width: MediaQuery.of(context).size.width,
                          decoration: BoxDecoration(
                              color: Colors.white,
                              borderRadius: BorderRadius.circular(10)),
                          child: Column(
                            crossAxisAlignment: CrossAxisAlignment.start,
                            children: [
                              Row(
                                children: [
                                  Text(
                                    "Nama Modul : " + ds["Nama_Modul"],
                                    style: TextStyle(
                                        color: Colors.blue,
                                        fontSize: 20.0,
                                        fontWeight: FontWeight.bold),
                                  ),
                                  Spacer(),
                                  GestureDetector(
                                      onTap: () {
                                        name_modulcontroller.text = ds["Nama_Modul"];
                                        isi_modulcontroller.text = ds["Isi_Modul"];
                                        EditEmployeDetails("Id");
                                      },
                                      child: Icon(
                                        Icons.edit,
                                        color: Colors.orange,
                                      )),
                                  SizedBox(
                                    width: 5.0,
                                  ),
                                  GestureDetector(
                                      onTap: () async {
                                        await DatabaseMetods()
                                            .deleteEmployeDetails(ds["Id"]);
                                      },
                                      child: Icon(
                                        Icons.delete,
                                        color: Colors.orange,
                                      ))
                                ],
                              ),
                              Text(
                                "Isi Modul : " + ds["Isi_Modul"],
                                style: TextStyle(
                                    color: Colors.orange,
                                    fontSize: 20.0,
                                    fontWeight: FontWeight.bold),
                              ),
                            ],
                          ),
                        ),
                      ),
                    );
                  })
              : Container();
        });
  }

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      floatingActionButton: Stack(
        children: [
          Positioned(
            bottom: 80,
            right: 10,
            child: FloatingActionButton(
              heroTag: "addButton",
              onPressed: () {
                Navigator.push(context,
                    MaterialPageRoute(builder: (context) => Employe()));
              },
              child: Icon(Icons.add),
            ),
          ),
          Positioned(
            bottom: 10,
            right: 10,
            child: FloatingActionButton(
              onPressed: () {
                Navigator.push(context,
                    MaterialPageRoute(builder: (context) => ChatScreen()));
              },
              child: Text("AI"),
            ),
          ),
        ],
      ),
      appBar: AppBar(
        title: Row(
          mainAxisAlignment: MainAxisAlignment.center,
          children: [
            Text(
              "Cognitio",
              style: TextStyle(
                  color: Colors.blue,
                  fontSize: 24.0,
                  fontWeight: FontWeight.bold),
            ),
            Text(
              "Augmentum",
              style: TextStyle(
                  color: Colors.orange,
                  fontSize: 24.0,
                  fontWeight: FontWeight.bold),
            ),
          ],
        ),
      ),
      body: Container(
        margin: EdgeInsets.only(left: 20.0, right: 20.0, top: 30.0),
        child: Column(
          children: [
            Expanded(child: allEmployeDetails()),
          ],
        ),
      ),
    );
  }

  Future EditEmployeDetails(String id) => showDialog(
      context: context,
      builder: (context) => AlertDialog(
            content: Container(
              child: Column(
                crossAxisAlignment: CrossAxisAlignment.start,
                children: [
                  Row(
                    children: [
                      GestureDetector(
                          onTap: () {
                            Navigator.pop(context);
                          },
                          child: Icon(Icons.cancel)),
                      SizedBox(
                        width: 60.0,
                      ),
                      Text(
                        "Edit",
                        style: TextStyle(
                            color: Colors.blue,
                            fontSize: 24.0,
                            fontWeight: FontWeight.bold),
                      ),
                      Text(
                        "Details",
                        style: TextStyle(
                            color: Colors.orange,
                            fontSize: 24.0,
                            fontWeight: FontWeight.bold),
                      ),
                    ],
                  ),
                  SizedBox(
                    height: 20.0,
                  ),
                  Text(
                    "Nama Modul",
                    style: TextStyle(
                        color: Colors.black,
                        fontSize: 20.0,
                        fontWeight: FontWeight.bold),
                  ),
                  SizedBox(height: 10.0),
                  Container(
                    padding: EdgeInsets.only(left: 10.0),
                    decoration: BoxDecoration(
                        border: Border.all(),
                        borderRadius: BorderRadius.circular(10)),
                    child: TextField(
                      controller: name_modulcontroller,
                      decoration: InputDecoration(border: InputBorder.none),
                    ),
                  ),
                  SizedBox(height: 20.0),
                  Text(
                    "Isi Modul",
                    style: TextStyle(
                        color: Colors.black,
                        fontSize: 20.0,
                        fontWeight: FontWeight.bold),
                  ),
                  SizedBox(height: 10.0),
                  Container(
                    height: 290.0,
                    padding: EdgeInsets.only(left: 10.0),
                    decoration: BoxDecoration(
                        border: Border.all(),
                        borderRadius: BorderRadius.circular(10)),
                    child: TextField(
                      controller: isi_modulcontroller,
                      decoration: InputDecoration(border: InputBorder.none),
                    ),
                  ),
                  SizedBox(height: 20.0),
                  SizedBox(
                    height: 30.0,
                  ),
                  Center(
                      child: ElevatedButton(
                          onPressed: () async {
                            Map<String, dynamic> updateInfo = {
                              "Id": id,
                              "Nama_Modul": name_modulcontroller.text,
                              "Isi_Modul": isi_modulcontroller.text,
                              
                            };
                            await DatabaseMetods()
                                .updateEmployeDetail(id, updateInfo)
                                .then((value) {
                              Navigator.pop(context);
                            });
                          },
                          child: Text("Update"))),
                ],
              ),
            ),
          ));
}
