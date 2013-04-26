package net.jalone.jul4j.logging;

import java.io.IOException;

public class FileLogger extends Logger{
	
	//SINGLETON
	private static FileLogger instance = null;
	public static Logger getInstance(){
		if(instance == null){
			instance = new FileLogger();
		}
		return instance;
	}
	
	private boolean enabled = true;
	
	java.util.logging.Logger 		logger; 
	java.util.logging.FileHandler 	fh;  
	
	protected FileLogger(){
		super();
	    try {
	    	
	    	
	    	StackTraceElement[] stack = Thread.currentThread ().getStackTrace ();
	        StackTraceElement main = stack[stack.length - 1];
	        String mainClass = main.getClassName ();

	        System.out.println(System.getProperty("user.home") + "/" + mainClass +".log");
	        
	        logger = java.util.logging.Logger.getLogger(mainClass);  
	         
	        fh = new java.util.logging.FileHandler(System.getProperty("user.home") + "/" + mainClass +".log");
	        logger.addHandler(fh);  
	        //logger.setLevel(Level.ALL);  
	        SingleLineFormatter formatter = new SingleLineFormatter();  
	        fh.setFormatter(formatter);
	          
	    } catch (SecurityException e) {  
	        e.printStackTrace();  
	    } catch (IOException e) {  
	        e.printStackTrace();  
	    }   
	}
	

	public void log(){
		if(enabled)
	        logger.info("");  
	}
	public void log(String s){
		if(enabled)
	        logger.info(s);  
	}
	
}
