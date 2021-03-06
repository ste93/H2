/* Generated by AN DISI Unibo */ 
/*
This code is generated only ONCE
*/
package it.unibo.qpatient_login;
import java.awt.Color;

import it.unibo.baseEnv.basicFrame.EnvFrame;
import it.unibo.is.interfaces.IBasicEnvAwt;
import it.unibo.is.interfaces.IOutputEnvView;
import it.unibo.qactors.QActorContext;
import it.unibo.qpatient_login.CustomGUIPatientLogin;

public class Qpatient_login extends AbstractQpatient_login { 
	
	private CustomGUIPatientLogin gui;
	
	public Qpatient_login(String actorId, QActorContext myCtx, IOutputEnvView outEnvView)  throws Exception{
		super(actorId, myCtx, outEnvView);
	}
/*
 * ADDED BY THE APPLICATION DESIGNER	
 */
	
	protected void addInputPanel(int size) {}
	
	protected void addCmdPanel() {}
	
	public void print(String str) {
		gui.printOnGUI(str);
	}
	
	public void createGUI() {
		IBasicEnvAwt env = outEnvView.getEnv();
		if(env == null) {
			env = new EnvFrame("H2 - Patient Login", Color.green, Color.black);
			env.init();
			((EnvFrame)env).setSize(800,430);
		}
		env.writeOnStatusBar("H2 - Patient Login" + " | working ... ",14);
		gui = new CustomGUIPatientLogin(env,myCtx,this);
	}
}
