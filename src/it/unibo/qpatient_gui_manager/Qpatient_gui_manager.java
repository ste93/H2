/* Generated by AN DISI Unibo */ 
/*
This code is generated only ONCE
*/
package it.unibo.qpatient_gui_manager;
import java.awt.Color;

import it.unibo.baseEnv.basicFrame.EnvFrame;
import it.unibo.is.interfaces.IBasicEnvAwt;
import it.unibo.is.interfaces.IOutputEnvView;
import it.unibo.qactors.QActorContext;
import it.unibo.qpatient_data_retriever.CustomGUISupportPatient;

public class Qpatient_gui_manager extends AbstractQpatient_gui_manager { 
	
	private CustomGUIPatient gui;

	public Qpatient_gui_manager(String actorId, QActorContext myCtx, IOutputEnvView outEnvView )  throws Exception{
		super(actorId, myCtx, outEnvView);
	}
/*
 * ADDED BY THE APPLICATION DESIGNER	
 */
	
	
	public String getId(final String oldID) {
		String newID = oldID.substring(0, oldID.length()-5);
		String ID = newID.replaceAll("\\D+", "");
		return ID;
	}
	
	protected void addInputPanel(int size) {}
	
	protected void addCmdPanel() {}
	
	public void print(String str) {
		gui.printOnGUI(str);
	}
	
	public void createGUI() {
		IBasicEnvAwt env = outEnvView.getEnv();
		if(env == null) {
			env = new EnvFrame("H2 - Patient Data Retriever", Color.green, Color.black);
			env.init();
			((EnvFrame)env).setSize(800,430);
		}
		env.writeOnStatusBar("H2 - Patient Data Retriever" + " | working ... ",14);
		gui = new CustomGUIPatient(env,myCtx,this,this.getId(this.getName()));
	}
}
