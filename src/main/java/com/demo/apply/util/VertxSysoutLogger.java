package com.demo.apply.util;

import io.vertx.core.AbstractVerticle;

public class VertxSysoutLogger extends AbstractVerticle {

	public final void entry(String msg){
		vertx.eventBus().send(SysOutHandler.class.getName(), "{"+msg+"}");
	}
	
	public static final void exit(String message){
		
	}
	public static final void debug(String message){
		
	}
	public static final void info(String message){
		
	}
	public static final void warn(Throwable excp){
		
	}
	public static final void error(String message,Throwable excp){
		
	}
}
