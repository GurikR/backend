package com.app.service;

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
@Produces({MediaType.APPLICATION_XML,MediaType.APPLICATION_JSON})
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
	public User getUserByName(@PathParam("name") String name){
		User user = userRepository.findUserByName(name);
		return user;
	}
	
	@Path("/save")
	@POST
	public Response save(User user){
		userRepository.save(user);
		return Response.ok().build();
	}
}
