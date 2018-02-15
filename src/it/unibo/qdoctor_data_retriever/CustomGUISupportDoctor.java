package it.unibo.qdoctor_data_retriever;

import java.awt.Color;
import java.awt.Label;
import java.awt.Panel;

import it.unibo.is.interfaces.IActivityBase;
import it.unibo.system.SituatedPlainObject;
import it.unibo.is.interfaces.IBasicEnvAwt;
import it.unibo.qactors.QActorContext;
import it.unibo.qactors.QActorUtils;

public class CustomGUISupportDoctor extends SituatedPlainObject {

	private IActivityBase cmdHandler;
	private IBasicEnvAwt envAwt;
	private QActorContext ctx;
	private String id;
	
	public CustomGUISupportDoctor(IBasicEnvAwt env, QActorContext myCtx, String id) {
		super(env);
		envAwt = env;
		init();
		this.ctx = myCtx;
		this.id = id;
	}
	
	protected void init(){
		cmdHandler = new CmdHandler(envAwt);
		setCommandUI();
//		setInputUI();
//		addCustomPanel();	
	}
	
	protected void setCommandUI(){
		envAwt.addCmdPanel("commandPanel", new String[]{"RETRIEVE DATA"}, cmdHandler);
	}
	
//	protected void setInputUI(){
//		envAwt.addInputPanel( 10 );
//	}
//		
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
				QActorUtils.raiseEvent(ctx, "input", "doctor_data_request", "doctor_data_request("+id+")");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
}
