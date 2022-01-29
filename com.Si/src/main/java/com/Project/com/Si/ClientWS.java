package com.Project.com.Si;

import java.sql.SQLException;
import java.util.List;

import Model.Client;
import accesBD.ClientDAO;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.MediaType;


@Path("client")
public class ClientWS {		
   @GET
	@Path("findBy/{id}")
	@Produces("application/json")
	public Client getClientById(@PathParam("id") String id)
	{
	return ClientDAO.findById(id);
	}
   

   @GET
 	@Path("/FindAll")
	@Produces("application/json")
 	public List<Client> findAll() throws SQLException
 	{
	   List<Client> c =  ClientDAO.findAll();
	   System.out.println(c);
 	return c;
 	}
//http://localhost:8080/com.Si/addClient?code=&nom=
	@POST
	@Path("/addClient")
	public void addClient(@QueryParam("code") String code,@QueryParam("nom") String nom)
	{
		ClientDAO.CREATE(new Client(code,nom));
		System.out.println("sxdrcftvgbhnj,k");
	}
	
	@PUT
	@Path("/updateClient")
	public void updateClient(@PathParam("code") String code,@PathParam("nom") String nom)
	{
		ClientDAO.UPDATE(code,nom);
	}
	@DELETE
	@Path("/deleteClient/{code}")
	public void deleteClient(@PathParam("code") String code)
	{
		ClientDAO.DELETE(code);
	}

}
