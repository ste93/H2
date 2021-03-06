/* Generated by AN DISI Unibo */ 
/*
This code is generated only ONCE
*/
package it.unibo.qdoctor_advice_sender;
import java.awt.Color;

import it.unibo.baseEnv.basicFrame.EnvFrame;
import it.unibo.is.interfaces.IBasicEnvAwt;
import it.unibo.is.interfaces.IOutputEnvView;
import it.unibo.qactors.QActorContext;
import it.unibo.qactors.QActorMessage;
import it.unibo.qactors.QActorUtils;
import it.unibo.qdoctor_advice_sender.CustomGUIAdviceSender;

public class Qdoctor_advice_sender extends AbstractQdoctor_advice_sender { 
	
	private CustomGUIAdviceSender gui;
	
	public Qdoctor_advice_sender(String actorId, QActorContext myCtx, IOutputEnvView outEnvView)  throws Exception{
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
		String idActor = this.getId(this.getName());
		QActorMessage mqa;
		try {
			mqa = QActorUtils.buildMsg(myCtx, this.getName(), "print_doctor_gui", "qdoctor_gui_manager"+ idActor, "dispatch", "print_doctor_gui('"+str+"')");
			this.sendMsg(mqa.msgId(), mqa.msgReceiver(), mqa.msgType(), mqa.msgContent());
		} catch (Exception e) {
			e.printStackTrace();
		}
//		gui.printOnGUI(str);
	}
	
	public void createGUI() {
		IBasicEnvAwt env = outEnvView.getEnv();
		if(env == null) {
			env = new EnvFrame("H2 - Doctor Advice Sender", Color.white, Color.black);
			env.init();
			((EnvFrame)env).setSize(800,430);
		}
		env.writeOnStatusBar("H2 - Doctor Advice Sender" + " | working ... ",14);
		gui = new CustomGUIAdviceSender(env,myCtx,this,this.getId(this.getName()));
	}
}
