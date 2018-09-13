package com.app.service;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.app.data.repository.UserRepository;
import com.app.model.User;


@Path("/user")
@Component
public class UserService {

	@Autowired
	private UserRepository userRepository;
	
	@GET
	public Response getUser(){
		User user = new User();
		user.setName("dev");
		user.setContactNo("092374");
		return Response.ok(user,MediaType.APPLICATION_JSON).build();
	}
	
	@GET
	@Path("/{name}")
	@Produces(MediaType.APPLICATION_JSON)
	public User getUserByName(@PathParam("name") String name){
		User user = userRepository.findUserByName(name);
		return user;
	}
	
	@Path("/save")
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public Response save(User user){
		System.out.println(user.getName());
		return Response.ok(user,MediaType.APPLICATION_JSON).build();
	}
}
