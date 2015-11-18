import java.util.ArrayList;
import java.util.Random;

import com.jme3.app.SimpleApplication;
import com.jme3.bullet.collision.shapes.CapsuleCollisionShape;
import com.jme3.bullet.control.RigidBodyControl;
import com.jme3.input.KeyInput;
import com.jme3.input.controls.KeyTrigger;
import com.jme3.light.DirectionalLight;
import com.jme3.material.Material;
import com.jme3.math.ColorRGBA;
import com.jme3.math.Quaternion;
import com.jme3.math.Vector3f;
import com.jme3.renderer.RenderManager ;
import com.jme3.scene.Geometry;
import com.jme3.scene.Node;
import com.jme3.scene.Spatial;
import com.jme3.scene.shape.Box;
import com.jme3.scene.shape.Sphere;
import com.jme3.texture.Texture;
import com.jme3.util.SkyFactory;

import comm.DeviceComm;
import oculusvr.app.OVRApplication;
import vr.input.DummyDisplay;
import vr.state.VRAppState;
import processing.core.PApplet;

/**
 * test
 * @author normenhansen
 */
public class Asteroids extends SimpleApplication {

    //public static Asteroids app;
    //private InputManager mn;
    //private Spatial observer;
    //private BulletAppState bas;
    //CameraNode cameraNode;
    Geometry sun,mer,ven,ear,mar,jup,sat,ura,nep;
    ArrayList<Geometry> asteroids = new ArrayList(0);
    private double arcl = 90.0;
    
    VRAppState vr;
    Quaternion q;
    DeviceComm dc;
    
    public static void main(String[] args) {
        Asteroids app = new Asteroids();
        //app.configureOVRApp(false, false, true);
        app.initRXTX();
        app.start();
    }

    //@Override
    public void simpleInitApp() {
    	//super.simpleInitApp();
    	
    	/*bas = new BulletAppState();
        stateManager.attach(bas);
        
        observer = new Node("Observer");
        observer.addControl(app.getOVRAppState().getCameraControl());
        observer.setLocalTranslation(0, 0,-30);
        rootNode.attachChild(observer);*/
        initSetting();
        
        DirectionalLight sun = new DirectionalLight();
        sun.setDirection(new Vector3f(0, 0, 0));
        rootNode.addLight(sun);
        
    	DummyDisplay display = new DummyDisplay();
        vr = new VRAppState(display);
        stateManager.attach(vr);
        
        
    }

    //@Override
    public void simpleUpdate(float tpf) {
        /*if(mn.getVerVal() < 10)
        {
        	observer.move(ovrAppState.getCameraControl().getLookDirection().getRotationColumn(2).mult(4f*tpf));
        }
        if(mn.getVerVal() > 1000){
        	observer.move(ovrAppState.getCameraControl().getLookDirection().getRotationColumn(2).mult(-tpf*4f));
        	//System.out.println("Down");
        }
        if(mn.getHorVal() < 10)
        {
        	observer.rotate(0, -0.5f*tpf, 0);
        	//System.out.println("Right " + mn.getHorVal());
        }
        if(mn.getHorVal() > 1000)
        {
        	observer.rotate(0, 0.5f*tpf, 0);
        	//System.out.println("Left");
        }*/ 
        
        q = new Quaternion(dc.v2, dc.v3, dc.v1, dc.v4);
    	vr.getCameraControl().getCamera2().setRotation(q);
    	vr.getCameraControl().getCamera2().update();
    	cam.setRotation(q);
    	cam.update();
    }

    //@Override
    public void simpleRender(RenderManager rm) {
        mer.setLocalTranslation((float)(15*Math.cos(arcl/15)), 0, (float)(15*Math.sin(arcl/15)));
        ven.setLocalTranslation((float)(20*Math.cos(arcl/20)), 0, (float)(20*Math.sin(arcl/20)));
        ear.setLocalTranslation((float)(25*Math.cos(arcl/25)), 0, (float)(25*Math.sin(arcl/25)));
        mar.setLocalTranslation((float)(30*Math.cos(arcl/30)), 0, (float)(30*Math.sin(arcl/30)));
        jup.setLocalTranslation((float)(50*Math.cos(arcl/50)), 0, (float)(50*Math.sin(arcl/50)));
        sat.setLocalTranslation((float)(70*Math.cos(arcl/70)), 0, (float)(70*Math.sin(arcl/70)));
        ura.setLocalTranslation((float)(100*Math.cos(arcl/100)), 0, (float)(100*Math.sin(arcl/100)));
        nep.setLocalTranslation((float)(130*Math.cos(arcl/130)), 0, (float)(130*Math.sin(arcl/130)));
        arcl += .01;
    }
    public void initSetting()
    {
    	Material mat = new Material(assetManager,"Common/MatDefs/Misc/Unshaded.j3md");
    	Material mat1 = new Material(assetManager,"Common/MatDefs/Misc/Unshaded.j3md");
    	Material mat2 = new Material(assetManager,"Common/MatDefs/Misc/Unshaded.j3md");
    	Material mat3 = new Material(assetManager,"Common/MatDefs/Misc/Unshaded.j3md");
    	Material mat4 = new Material(assetManager,"Common/MatDefs/Misc/Unshaded.j3md");
    	Material mat5 = new Material(assetManager,"Common/MatDefs/Misc/Unshaded.j3md");
    	Material mat6 = new Material(assetManager,"Common/MatDefs/Misc/Unshaded.j3md");
    	Material mat7 = new Material(assetManager,"Common/MatDefs/Misc/Unshaded.j3md");
    	Material mat8 = new Material(assetManager,"Common/MatDefs/Misc/Unshaded.j3md");
    	
    	sun = new Geometry("Sphere", new Sphere(20,100, 10f));
    	mat.setTexture("ColorMap", assetManager.loadTexture("Textures/sun.jpg"));
    	sun.setMaterial(mat);
    	rootNode.attachChild(sun);
    	sun.setLocalTranslation(0, 0, 0);
    	
    	mer = new Geometry("Sphere", new Sphere(20,100,.25f));
    	mat1.setTexture("ColorMap", assetManager.loadTexture("Textures/mercury.jpg"));
    	mer.setMaterial(mat1);
    	rootNode.attachChild(mer);
    	//mer.setLocalTranslation(0, 0, 15);
    	
    	ven = new Geometry("Sphere", new Sphere(20,100,.25f));
    	mat2.setTexture("ColorMap", assetManager.loadTexture("Textures/Venus.jpg"));
    	ven.setMaterial(mat2);
    	rootNode.attachChild(ven);
    	//ven.setLocalTranslation(0, 0, 9);
    	
    	ear = new Geometry("Sphere", new Sphere(20,100,.4f));
    	mat3.setTexture("ColorMap", assetManager.loadTexture("Textures/Earth.jpg"));
    	ear.setMaterial(mat3);
    	rootNode.attachChild(ear);
    	//ear.setLocalTranslation(0, 0, 12);
    	
    	mar = new Geometry("Sphere", new Sphere(20,100,.3f));
    	mat4.setTexture("ColorMap", assetManager.loadTexture("Textures/mars.jpg"));
    	mar.setMaterial(mat4);
    	rootNode.attachChild(mar);
    	//mar.setLocalTranslation(0, 0, 15);
    	
    	jup = new Geometry("Sphere", new Sphere(20,100,1.5f));
    	mat5.setTexture("ColorMap", assetManager.loadTexture("Textures/jupiter.jpg"));
    	jup.setMaterial(mat5);
    	rootNode.attachChild(jup);
    	//jup.setLocalTranslation(0, 0, 18);
    	
    	sat = new Geometry("Sphere", new Sphere(20,100,1.5f));
    	mat6.setTexture("ColorMap", assetManager.loadTexture("Textures/saturn.jpg"));
    	sat.setMaterial(mat6);
    	rootNode.attachChild(sat);
    	//sat.setLocalTranslation(0, 0, 21);
    	
    	ura = new Geometry("Sphere", new Sphere(20,100,1f));
    	mat7.setTexture("ColorMap", assetManager.loadTexture("Textures/uranus.jpg"));
    	ura.setMaterial(mat7);
    	rootNode.attachChild(ura);
    	//ura.setLocalTranslation(0, 0, 24);
    	
    	nep = new Geometry("Sphere", new Sphere(20,100,1f));
    	mat8.setTexture("ColorMap", assetManager.loadTexture("Textures/neptune.jpg"));
    	nep.setMaterial(mat8);
    	rootNode.attachChild(nep);
    	//nep.setLocalTranslation(0, 0, 27);
    	
    	rootNode.attachChild(SkyFactory.createSky(
                assetManager, "Textures/night.jpg", true));
    	
    }
    public void initRXTX()
    {
    	 dc = new DeviceComm();
    	 dc.setup();
    }
}
