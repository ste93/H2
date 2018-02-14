/* Generated by AN DISI Unibo */ 
/*
This code is generated only ONCE
*/
package it.unibo.qdoctor_login;
import java.awt.Color;

import it.unibo.baseEnv.basicFrame.EnvFrame;
import it.unibo.is.interfaces.IBasicEnvAwt;
import it.unibo.is.interfaces.IOutputEnvView;
import it.unibo.qactors.QActorContext;
import it.unibo.qdc_user_manager.CustomGUIRegistration;

public class Qdoctor_login extends AbstractQdoctor_login { 

	private CustomGUIDoctorLogin gui;

	public Qdoctor_login(String actorId, QActorContext myCtx, IOutputEnvView outEnvView )  throws Exception{
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
			env = new EnvFrame("H2-Doctor Login", Color.white, Color.black);
			env.init();
			((EnvFrame)env).setSize(800,430);
		}
		env.writeOnStatusBar("H2-Doctor Login" + " | working ... ",14);
		gui = new CustomGUIDoctorLogin(env,actorId,myCtx);
	}
}
