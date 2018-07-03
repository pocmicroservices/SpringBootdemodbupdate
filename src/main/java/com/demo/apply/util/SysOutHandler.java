package com.demo.apply.util;

import io.vertx.core.AbstractVerticle;
import io.vertx.core.eventbus.Message;
import io.vertx.core.eventbus.MessageConsumer;
import io.vertx.core.json.JsonObject;

import org.springframework.stereotype.Component;
@Component
public class SysOutHandler extends AbstractVerticle {

	private static final String CLASS_NAME=SysOutHandler.class.getName();
	
	@Override
	public void start() throws Exception{
		MessageConsumer<JsonObject> consumer=vertx.eventBus().consumer(CLASS_NAME);
		consumer.handler(this::handleMessage);
	}
	
	@Override
	public void stop() throws Exception{
		super.stop();
	}
	
	private void handleMessage(Message<JsonObject> message){
		System.out.println(message.body());
	}
}
