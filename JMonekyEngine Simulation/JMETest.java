import processing.core.PApplet;
import vr.input.DummyDisplay;
import vr.state.VRAppState;

import com.jme3.app.SimpleApplication;
import com.jme3.asset.plugins.ZipLocator;
import com.jme3.light.DirectionalLight;
import com.jme3.material.Material;
import com.jme3.math.ColorRGBA;
import com.jme3.math.Quaternion;
import com.jme3.math.Vector3f;
import com.jme3.scene.Geometry;
import com.jme3.scene.Node;
import com.jme3.scene.Spatial;
import com.jme3.scene.shape.Box;

import comm.DeviceComm;
import comm.SerialComm;
 
public class JMETest extends SimpleApplication {
 
	DeviceComm dc;
	Quaternion q;
	VRAppState vrAppState;
	
    public static void main(String[] args){
    	JMETest app = new JMETest();
    	app.initRXTX();
        app.start();
    }
 
    @Override
    public void simpleInitApp() {
 
    	assetManager.registerLocator("town.zip", ZipLocator.class);
        Spatial gameLevel = assetManager.loadModel("main.scene");
        gameLevel.setLocalTranslation(0, -5.2f, 0);
        gameLevel.setLocalScale(2);
        rootNode.attachChild(gameLevel);
        
        DirectionalLight sun = new DirectionalLight();
        sun.setDirection(new Vector3f(-0.1f, -0.7f, -1.0f));
        rootNode.addLight(sun);
        
        DummyDisplay display = new DummyDisplay();
        vrAppState = new VRAppState(display);
        stateManager.attach(vrAppState);
    }
    public void initRXTX()
    {

    	 dc = new DeviceComm();
    	 dc.setup();  	
    }
    public void simpleUpdate(float tpf)
    {    	
    	//VR Input System
    	q = new Quaternion(dc.v2, dc.v3, dc.v1, dc.v4);
    	vrAppState.getCameraControl().getCamera2().setRotation(q);
    	vrAppState.getCameraControl().getCamera2().update();
    	cam.setRotation(q);
    	cam.update();
    }
}
