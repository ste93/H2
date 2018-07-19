package it.unibo.qpatient_notification_receiver;

import it.unibo.system.SituatedPlainObject;
import it.unibo.is.interfaces.IBasicEnvAwt;
import it.unibo.qactors.QActorContext;

public class CustomGUIPatientNotifReceiver extends SituatedPlainObject {
	
	public CustomGUIPatientNotifReceiver(IBasicEnvAwt env, QActorContext myCtx) {
		super(env);
	}
	
	public void printOnGUI(String str) {
		println(str);
	}
	
}
