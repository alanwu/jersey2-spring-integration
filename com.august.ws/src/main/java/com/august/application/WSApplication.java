package com.august.application;

import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.server.spring.scope.RequestContextFilter;

import com.august.resource.HelloWorldResource;

public class WSApplication extends ResourceConfig {
	
	public WSApplication() {
		register(RequestContextFilter.class);
		register(HelloWorldResource.class);
	}

}
