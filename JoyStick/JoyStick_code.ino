int sensorValue0 = 0;
int sensorValue1 = 0;
int sensorValue2 = 0;
int sensorValue3 = 0;

int sensorPin0 = A0;
int sensorPin1 = A1;
int sensorPin2 = A2;
int sensorPin3 = A3;
//char* data;

void setup()
{
 pinMode(A0,INPUT);
 pinMode(A1,INPUT);
 pinMode(A2,INPUT);
 pinMode(A3,INPUT);
 
 Serial.begin(9600);
}

void loop()
{
 sensorValue0 = analogRead(sensorPin0);
 sensorValue1 = analogRead(sensorPin1);
 sensorValue2 = analogRead(sensorPin2);
 sensorValue3 = analogRead(sensorPin3);
 
 Serial.print(sensorValue0);
 Serial.print(" ");
 Serial.print(sensorValue1);
 Serial.print(" ");
 Serial.print(sensorValue2);
 Serial.print(" ");
 Serial.println(sensorValue3);
 delay(100);
}
