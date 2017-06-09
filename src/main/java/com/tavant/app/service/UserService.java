package com.tavant.app.service;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.springframework.stereotype.Component;

import com.tavant.app.model.User;


@Path("/first")
@Component
public class UserService {

	@GET
	public Response getUser(){
		User user = new User();
		user.setName("dev");
		user.setContactNo("092374");
		return Response.ok(user,MediaType.APPLICATION_JSON).build();
	}
	
	@Path("/save")
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public Response save(User user){
		System.out.println(user.getName());
		return Response.ok(user,MediaType.APPLICATION_JSON).build();
	}
}
