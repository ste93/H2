package it.unibo.qdoctor_notification_sender;

import java.awt.Color;
import java.awt.Label;
import java.awt.Panel;

import it.unibo.is.interfaces.IActivityBase;
import it.unibo.system.SituatedPlainObject;
import it.unibo.is.interfaces.IBasicEnvAwt;
import it.unibo.qactors.QActorContext;
import it.unibo.qactors.QActorUtils;

public class CustomGUISupportAdvice extends SituatedPlainObject {

	private IActivityBase cmdHandler;
	private IBasicEnvAwt envAwt;
	private QActorContext ctx;
	
	public CustomGUISupportAdvice(IBasicEnvAwt env, QActorContext myCtx) {
		super(env);
		envAwt = env;
		init();
		this.ctx = myCtx;
	}
	
	protected void init(){
		cmdHandler = new CmdHandler(envAwt);
		setCommandUI();
		setInputUI();
//		addCustomPanel();	
	}
	
	protected void setCommandUI(){
		envAwt.addCmdPanel("commandPanel", new String[]{"SEND ADVICE"}, cmdHandler);
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
//			println("CmdHandler -> " + cmd + " input= " + input);
			try {
				QActorUtils.raiseEvent(ctx, "input", "doctor_notification_sender", "doctor_notification_sender(" + input + ")");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
}
