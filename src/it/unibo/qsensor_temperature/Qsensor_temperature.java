/* Generated by AN DISI Unibo */ 
/*
This code is generated only ONCE
*/
package it.unibo.qsensor_temperature;
import it.unibo.is.interfaces.IOutputEnvView;
import it.unibo.qactors.QActorContext;

public class Qsensor_temperature extends AbstractQsensor_temperature { 
	public Qsensor_temperature(String actorId, QActorContext myCtx, IOutputEnvView outEnvView )  throws Exception{
		super(actorId, myCtx, outEnvView);
	}
/*
 * ADDED BY THE APPLICATION DESIGNER	
 */
	public String getId(final String oldID) {
		System.out.println("[OLDID] " + oldID);
		String newID = oldID.substring(0, oldID.length()-5);
		String ID = newID.replaceAll("\\D+", "");
		return ID;
	}
	
	public String getName(final String oldID) {
		System.out.println("[OLDID] " + oldID);
		String name = oldID.substring(4, oldID.length()-5);
		System.out.println("[NAME] " + name);
		return name;
	}
	
}
