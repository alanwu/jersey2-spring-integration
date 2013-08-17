package com.august.resource;

import static org.junit.Assert.assertEquals;

import java.net.URI;

import javax.ws.rs.core.Application;
import javax.ws.rs.core.UriBuilder;

import org.glassfish.jersey.test.JerseyTest;
import org.junit.Ignore;
import org.junit.Test;

import com.august.application.WSApplication;

@Ignore
public class HelloWorldResourceTest extends JerseyTest {

	@Override
	protected Application configure() {
		return new WSApplication();
	}

	@Override
	protected URI getBaseUri() {
		return UriBuilder.fromUri(super.getBaseUri()).path("/").build();
	}

	@Test
	public void testClientStringResponse() {
		String s = target("hello-world").request().get(String.class);
		assertEquals("Hello World!", s);
	}

}
