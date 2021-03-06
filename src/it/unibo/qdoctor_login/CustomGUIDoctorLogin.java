package it.unibo.qdoctor_login;

import it.unibo.is.interfaces.IActivityBase;
import it.unibo.system.SituatedPlainObject;
import it.unibo.is.interfaces.IBasicEnvAwt;
import it.unibo.qactors.QActorContext;
import it.unibo.qactors.QActorMessage;
import it.unibo.qactors.QActorUtils;
import it.unibo.qactors.akka.QActor;

public class CustomGUIDoctorLogin extends SituatedPlainObject {

	private IActivityBase cmdHandler;
	private IBasicEnvAwt envAwt;
	private QActorContext ctx;
	private QActor qactor;
	
	public CustomGUIDoctorLogin(IBasicEnvAwt env, QActorContext myCtx, QActor qactor) {
		super(env);
		envAwt = env;
		init();
		this.ctx = myCtx;
		this.qactor = qactor;
	}
	
	protected void init(){
		cmdHandler = new CmdHandler(envAwt);
		setCommandUI();
		setInputUI();
	}
	
	protected void setCommandUI(){
		envAwt.addCmdPanel("commandPanel", new String[]{"LOGIN"}, cmdHandler);
	}
	
	protected void setInputUI(){
		envAwt.addInputPanel(50);
	}
	
	public void printOnGUI(String str) {
		println(str);
	}
	
	public String getNickname() {
		return env.readln();
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
					QActorMessage mqa = QActorUtils.buildMsg(ctx, "doctor login gui", "login_doctor_gui", "qdoctor_login", "dispatch", "login_doctor_gui("+input+")");
					qactor.sendMsg(mqa.msgId(), mqa.msgReceiver(), mqa.msgType(), mqa.msgContent());
				} catch (Exception e2) {
					e2.printStackTrace();
				}
			}
		}
	}
	
}
