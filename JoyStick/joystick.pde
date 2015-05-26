import processing.serial.*;
import processing.net.*;

int lf = 10;    // Linefeed in ASCII
String myString = null;
Serial myPort;  // The serial port
Client myClient;

void setup() {

  myClient = new Client(this, "127.0.0.1", 9001);
  myPort = new Serial(this, Serial.list()[2], 9600);
  myPort.clear();
  myString = myPort.readStringUntil(lf);
  myString = null;
}

void draw() {

  while (myPort.available() > 0) {;
    myString = myPort.readStringUntil(lf);
    if (myString != null) {
      println(myString);
      myClient.write(myString);
    }
  }
}
