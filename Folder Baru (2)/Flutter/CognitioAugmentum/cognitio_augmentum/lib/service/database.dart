import 'package:cloud_firestore/cloud_firestore.dart';


class DatabaseMetods {
  Future addEmployeDetails(
      Map<String, dynamic> employeInfoMap, String id) async {
    return await FirebaseFirestore.instance
        .collection("Employe")
        .doc(id)
        .set(employeInfoMap);
  }

  Future<Stream<QuerySnapshot>> getEmployeDetails() async {
    return await FirebaseFirestore.instance.collection("Employe").snapshots();
  }

  Future updateEmployeDetail(
      String Id, Map<String, dynamic> updateInfo) async {
    return await FirebaseFirestore.instance
        .collection("Employe")
        .doc(Id)
        .update(updateInfo);
  }
  Future deleteEmployeDetails(
      String id) async {
    return await FirebaseFirestore.instance
        .collection("Employe")
        .doc(id);
  }
}
