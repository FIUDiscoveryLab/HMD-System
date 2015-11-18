package comm;

import java.util.StringTokenizer;
import processing.core.*;
import processing.serial.*;

public class DeviceComm extends PApplet{

	int lf = 10;    // Linefeed in ASCII
	String IMUData = null;
	Serial IMU;  // The serial port
	
	public float v1 = 0;
    public float v2 = 0;
    public float v3 = 0;
    public float v4 = 0;
    
    public int j1 = 0;
    public int j2 = 0;
    public int j3 = 0;
    public int j4 = 0;

	public void setup() {

	  System.out.println(Serial.list());
	  try
	  {
		  IMU = new Serial(this, Serial.list()[0], 57600); //57600
	  }
	  catch(Exception e)
	  {
		  System.out.println("\nCan't open port " + Serial.list()[0]);
		  IMU.dispose();
		  System.exit(0);
	  }
	  System.out.println("\nChosen port: " + Serial.list()[0]);
	  IMU.clear();
	  IMU.bufferUntil(lf);

   }

	private void processIMUData(String input)
    {
    	StringTokenizer st;
    	st = new StringTokenizer(input);
        //System.out.println(st.countTokens());
        if(input!= null && st.countTokens() == 4){
            try{        	
	        	v1 = Float.parseFloat(st.nextToken());
	        	v2 = Float.parseFloat(st.nextToken());
	        	v3 = Float.parseFloat(st.nextToken());
	        	v4 = Float.parseFloat(st.nextToken());
            }
            catch(Exception e){
            	System.out.println("Number format error");
            }
        }
    }
	
	public void serialEvent(Serial p)
	{
		IMUData = p.readStringUntil(lf);
		//System.out.println(IMUData);
		processIMUData(IMUData);
	}
}

