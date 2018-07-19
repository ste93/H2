package it.unibo.qpatient_gui_manager;

import it.unibo.is.interfaces.IActivityBase;
import it.unibo.system.SituatedPlainObject;
import it.unibo.is.interfaces.IBasicEnvAwt;
import it.unibo.qactors.QActorContext;
import it.unibo.qactors.QActorMessage;
import it.unibo.qactors.QActorUtils;
import it.unibo.qactors.akka.QActor;

public class CustomGUIPatient extends SituatedPlainObject {

	private IActivityBase cmdHandler;
	private IBasicEnvAwt envAwt;
	private QActorContext ctx;
	private QActor qactor;
	private String id;
	
	public CustomGUIPatient(IBasicEnvAwt env, QActorContext myCtx, QActor qactor, String id) {
		super(env);
		envAwt = env;
		init();
		this.ctx = myCtx;
		this.qactor = qactor;
		this.id = id;
	}
	
	protected void init(){
		cmdHandler = new CmdHandler(envAwt);
		setCommandUI();
	}
	
	protected void setCommandUI(){
		envAwt.addCmdPanel("commandPanel", new String[]{"RETRIEVE DATA","ADD TEMPERATURE SENS","ADD GLYCEMIA SENS", "REMOVE TEMPERATURE SENS", "REMOVE GLYCEMIA SENS"}, cmdHandler);
	}
	
	public void printOnGUI(String str) {
		println(str);
	}

	private class CmdHandler extends SituatedPlainObject implements IActivityBase {
	
		public CmdHandler(IBasicEnvAwt env) {
			super(env);
		}
		
		@Override
		public void execAction(String cmd) { 
			
			switch (cmd) {
				case "RETRIEVE DATA" : 
					try {
						QActorMessage mqa = QActorUtils.buildMsg(ctx, qactor.getName(), "patient_data_request_gui", "qpatient_data_retriever"+id, "dispatch", "patient_data_request_gui");
						qactor.sendMsg(mqa.msgId(), mqa.msgReceiver(), mqa.msgType(), mqa.msgContent());
					} catch (Exception e2) {
						e2.printStackTrace();
					}
				break;
				
				case "ADD TEMPERATURE SENS" : 
					try {
						QActorMessage mqa = QActorUtils.buildMsg(ctx, qactor.getName(), "add_temperature_gui", "qpatient_sensor_manager"+id, "dispatch", "add_temperature_gui");
						qactor.sendMsg(mqa.msgId(), mqa.msgReceiver(), mqa.msgType(), mqa.msgContent());
					} catch (Exception e2) {
						e2.printStackTrace();
					}
				break;
				
				case "ADD GLYCEMIA SENS" : 
					try {
						QActorMessage mqa = QActorUtils.buildMsg(ctx, qactor.getName(), "add_glycemia_gui", "qpatient_sensor_manager"+id, "dispatch", "add_glycemia_gui");
						qactor.sendMsg(mqa.msgId(), mqa.msgReceiver(), mqa.msgType(), mqa.msgContent());
					} catch (Exception e2) {
						e2.printStackTrace();
					}
				break;
				
				case "REMOVE TEMPERATURE SENS" : 
					try {
						QActorMessage mqa = QActorUtils.buildMsg(ctx, qactor.getName(), "remove_temperature_gui", "qpatient_sensor_manager"+id, "dispatch", "remove_temperature_gui");
						qactor.sendMsg(mqa.msgId(), mqa.msgReceiver(), mqa.msgType(), mqa.msgContent());
					} catch (Exception e2) {
						e2.printStackTrace();
					}
				break;
				
				case "REMOVE GLYCEMIA SENS" : 
					try {
						QActorMessage mqa = QActorUtils.buildMsg(ctx, qactor.getName(), "remove_glycemia_gui", "qpatient_sensor_manager"+id, "dispatch", "remove_glycemia_gui");
						qactor.sendMsg(mqa.msgId(), mqa.msgReceiver(), mqa.msgType(), mqa.msgContent());
					} catch (Exception e2) {
						e2.printStackTrace();
					}
				break;
			}
		}
	}
}
