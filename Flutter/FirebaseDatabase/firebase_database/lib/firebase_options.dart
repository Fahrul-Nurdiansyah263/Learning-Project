import 'package:firebase_core/firebase_core.dart';

class DefaultFirebaseOptions {
  static FirebaseOptions get currentPlatform {
    return const FirebaseOptions(
      apiKey: "YOUR_API_KEY",
      authDomain: "basicapp-6cf30.firebaseapp.com",
      projectId: "basicapp-6cf30",
      storageBucket: "basicapp-6cf30.firebasestorage.app",
      messagingSenderId: "240703720690",
      appId: "1:240703720690:web:b7e165a636d90a776a546b",
      measurementId: "G-R0BWDJ1ED8"
    );
  }
}
