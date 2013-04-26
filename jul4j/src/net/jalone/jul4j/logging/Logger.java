package net.jalone.jul4j.logging;

/**
 * singleton class
 * @author jalone
 *
 */

public class Logger{
	
	private static Logger instance = null;
	
	public static Logger getInstance(){
		if(instance == null){
			instance = new Logger();
		}
		return instance;
	}
	
	private boolean enabled = true;
	
	protected Logger(){
		enabled = true;
	}

	public void log(){
		if(enabled)
			System.out.println();
	}
	public void log(String s){
		if(enabled)
			System.out.println(s);
	}
	
	public void enable(){
		enabled = true;
	}
	public void disable(){
		enabled = false;
	}
	public boolean isEnabled(){
		return enabled;
	}
	
}
