package com.tavant.app.config;

import javax.ws.rs.ApplicationPath;

import org.glassfish.jersey.jackson.JacksonFeature;
import org.glassfish.jersey.message.GZipEncoder;
import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.server.filter.EncodingFilter;
import org.springframework.web.filter.RequestContextFilter;

@ApplicationPath("service")
public class JerseyConfig extends ResourceConfig {

	public JerseyConfig(){
		register(RequestContextFilter.class);
		 packages("com.tavant.app.service")
	       .register(JacksonFeature.class)
	       .register(EncodingFilter.class)
          .register(GZipEncoder.class);
	}
}
