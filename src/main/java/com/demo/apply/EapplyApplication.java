package com.demo.apply;

import io.vertx.core.Vertx;

import javax.annotation.PostConstruct;

import com.demo.apply.util.HttpHandler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class EapplyApplication {

	@Autowired
	private HttpHandler handler;
	public static void main(String[] args) {
		SpringApplication.run(EapplyApplication.class, args);

	}

	@PostConstruct
	public void deployServerVerticle()
	{
		Vertx.vertx().deployVerticle(handler);
	}
}
