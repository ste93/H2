/* Generated by AN DISI Unibo */ 
/*
This code is generated only ONCE
*/
package it.unibo.qdoctor_notification_sender;
import java.awt.Color;

import it.unibo.baseEnv.basicFrame.EnvFrame;
import it.unibo.is.interfaces.IBasicEnvAwt;
import it.unibo.is.interfaces.IOutputEnvView;
import it.unibo.qactors.QActorContext;
import it.unibo.qdoctor_data_retriever.CustomGUISupportDoctor;

public class Qdoctor_notification_sender extends AbstractQdoctor_notification_sender {
	
	private CustomGUISupportAdvice gui;
	
	public Qdoctor_notification_sender(String actorId, QActorContext myCtx, IOutputEnvView outEnvView )  throws Exception{
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
//		System.out.println("STO CREANDO LA GUIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIII");
		IBasicEnvAwt env = outEnvView.getEnv();
		if(env == null) {
			env = new EnvFrame("H2-advice", Color.white, Color.black);
			env.init();
			((EnvFrame)env).setSize(800,430);
		}
		env.writeOnStatusBar("H2-advice" + " | working ... ",14);
		gui = new CustomGUISupportAdvice(env,myCtx);
	}
	
}
