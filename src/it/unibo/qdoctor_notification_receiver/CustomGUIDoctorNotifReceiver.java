package it.unibo.qdoctor_notification_receiver;

import it.unibo.system.SituatedPlainObject;
import it.unibo.is.interfaces.IBasicEnvAwt;
import it.unibo.qactors.QActorContext;

public class CustomGUIDoctorNotifReceiver extends SituatedPlainObject {
	
	public CustomGUIDoctorNotifReceiver(IBasicEnvAwt env, QActorContext myCtx) {
		super(env);
	}
	
	public void printOnGUI(String str) {
		println(str);
	}
	
}
