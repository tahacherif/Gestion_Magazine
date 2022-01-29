package com.Project.com.Si.WS1;


import java.sql.Date;
import java.time.LocalDate;
import java.util.Collection;

import Model.Client;
import Model.Facture;
import Model.LigneFacture;
import accesBD.FactureDAO;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;

@Path("facture")
public class FactureWS {

/*	@GET
	@Path("/{login}")
	public Facture getFactureByNum(@PathParam("num") String num)
	{
		return FactureDAO.findByNum(num);
	}
	*/
	@POST
	@Path("/addFacture")
	public void addFacture(@PathParam("numero") String numero, @PathParam("codeClient") String codeClient,@PathParam("dateFacture") Date dateFacture)
	{
		FactureDAO.CREATE(new Facture(numero ,codeClient,dateFacture));
	}
	@PUT
	@Path("/updateFacture")
	public void updateFacture(@PathParam("numero") String numero,@PathParam("codeClient") String codeClient)
	{
		FactureDAO.UPDATE(numero,codeClient);
	
	}
	@DELETE
	@Path("/deleteFacture")
	public void deleteFacture(@PathParam("numero") String numero)
	{
		FactureDAO.DELETE(numero);
	}
}
