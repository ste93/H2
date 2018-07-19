package it.unibo.qdoctor_data_retriever;

import it.unibo.is.interfaces.IActivityBase;
import it.unibo.system.SituatedPlainObject;
import it.unibo.is.interfaces.IBasicEnvAwt;
import it.unibo.qactors.QActorContext;
import it.unibo.qactors.QActorMessage;
import it.unibo.qactors.QActorUtils;
import it.unibo.qactors.akka.QActor;

public class CustomGUIDoctorDataRetriever extends SituatedPlainObject {

	private IActivityBase cmdHandler;
	private IBasicEnvAwt envAwt;
	private QActorContext ctx;
	private QActor qactor;
	private String id;
	
	public CustomGUIDoctorDataRetriever(IBasicEnvAwt env, QActorContext myCtx, QActor qactor, String id) {
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
		setInputUI();
	}
	
	protected void setCommandUI(){
		envAwt.addCmdPanel("commandPanel", new String[]{"RETRIEVE DATA"}, cmdHandler);
	}
	
	protected void setInputUI(){
		envAwt.addInputPanel(25);
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
			String input = env.readln();
			if (input.length() > 0) { 
				try {
					QActorMessage mqa = QActorUtils.buildMsg(ctx, qactor.getName(), "doctor_data_request_gui", "qdoctor_data_retriever"+id, "dispatch", "doctor_data_request_gui("+input+")");
					qactor.sendMsg(mqa.msgId(), mqa.msgReceiver(), mqa.msgType(), mqa.msgContent());
				} catch (Exception e2) {
					e2.printStackTrace();
				}
			}
		}
	}
	
}
