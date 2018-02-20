package it.unibo.qdoctor_advice_sender;

import it.unibo.is.interfaces.IActivityBase;
import it.unibo.system.SituatedPlainObject;
import it.unibo.is.interfaces.IBasicEnvAwt;
import it.unibo.qactors.QActorContext;
import it.unibo.qactors.QActorMessage;
import it.unibo.qactors.QActorUtils;
import it.unibo.qactors.akka.QActor;

public class CustomGUIAdviceSender extends SituatedPlainObject {

	private IActivityBase cmdHandler;
	private IBasicEnvAwt envAwt;
	private QActorContext ctx;
	private QActor qactor;
	private String id;
	
	public CustomGUIAdviceSender(IBasicEnvAwt env, QActorContext myCtx, QActor qactor, String id) {
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
//		addCustomPanel();	
	}
	
	protected void setCommandUI(){
		envAwt.addCmdPanel("commandPanel", new String[]{"SEND"}, cmdHandler);
	}
	
	protected void setInputUI(){
		envAwt.addInputPanel(50);
	}
		
//	protected void addCustomPanel(){
//		Panel p = new Panel();
//		p.setBackground(Color.blue);
//		Label l = new Label("a label");
//		l.setBackground(Color.cyan);
//		p.add(l);
//		envAwt.addPanel(p);
//	}
	
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
					//QActorUtils.buildMsg(ctx, senderId, msgID, destActorId, msgType, msg)
					QActorMessage mqa = QActorUtils.buildMsg(ctx, qactor.getName(), "advice_to_send_gui", "qdoctor_advice_sender"+id, "dispatch", "advice_to_send_gui("+input+")");
					qactor.sendMsg(mqa.msgId(), mqa.msgReceiver(), mqa.msgType(), mqa.msgContent());
				} catch (Exception e2) {
					e2.printStackTrace();
				}
			}
		}
	}
	
}
