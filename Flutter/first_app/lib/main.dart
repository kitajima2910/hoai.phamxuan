import 'package:flutter/foundation.dart';
import 'package:flutter/material.dart';

void main() {
  runApp(MaterialApp(
    theme: ThemeData(
      fontFamily: 'DancingScript-Regular'
    ),
    home: const SafeArea(
      child: Scaffold(
        body: MyWidget()
      ),
    ),
    debugShowCheckedModeBanner: false,
  ));
}

class MyWidget extends StatelessWidget {

  const MyWidget({super.key});

  @override
  Widget build(BuildContext context) {
    return Container(
      margin: const EdgeInsets.all(10),
      child: TextButton.icon(
          onPressed: () {
            if (kDebugMode) {
              print('Click text button');
            }
          },
          style: TextButton.styleFrom(
            foregroundColor: Colors.pink,
            backgroundColor: Colors.green,
            // minimumSize: const Size(120, 60)
            padding: const EdgeInsets.all(10),
            shape: RoundedRectangleBorder(
              borderRadius: BorderRadius.circular(35)
            ),
            elevation: 8,
            shadowColor: Colors.blue.withOpacity(.5),
            side: const BorderSide(width: 2, color: Colors.brown)
          ),
          icon: const Icon(Icons.add, size: 20),
          label: const Text('Text Button', style: TextStyle(fontSize: 28))
      ),
    );
  }

}
