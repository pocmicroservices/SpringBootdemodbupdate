package com.demo.apply.util;

import io.vertx.core.AbstractVerticle;
import io.vertx.core.Context;
import io.vertx.core.Future;
import io.vertx.core.Vertx;
import io.vertx.core.json.JsonObject;
import io.vertx.ext.web.Router;
import io.vertx.ext.web.RoutingContext;
import io.vertx.ext.web.handler.BodyHandler;
import org.springframework.stereotype.Component;

@Component
public class HttpHandler extends AbstractVerticle {

	@Override
	public void init(Vertx vertx,Context context){
		super.init(vertx, context);
	}
	
	@Override
	public void start(Future<Void> fut) throws Exception {
		Router router=Router.router(vertx);
		router.route().handler(BodyHandler.create());
		router.post("/log").handler(this::handleLog);
		vertx.createHttpServer().requestHandler(router::accept).listen(8082);
		
	}
	
	public void handleLog(RoutingContext routingContext){
		routingContext.request().response().end("Logging Request Received");
		JsonObject json=routingContext.getBodyAsJson();
		System.out.println("JSON Passed in: "+json);
	}
}
