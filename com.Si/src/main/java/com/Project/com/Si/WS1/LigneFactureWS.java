package com.Project.com.Si.WS1;


import Model.LigneFacture;
import accesBD.ligneFactureDAO;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;

@Path("LigneFacture")
public class LigneFactureWS {
	@GET
	@Path("/{login}")
	@Produces("application/xml")
	public LigneFacture getLigneFactureByNum(@PathParam("num") int num)
	{
		return ligneFactureDAO.findByNumero(num);
	}

	@POST
	@Path("/addLigneFacture")
	public void addLigneFacture(@QueryParam("prix") float prix,@QueryParam("prod") String prod,@QueryParam("quantite") int quantite,@QueryParam("numero") int numero)
	{
		ligneFactureDAO.CREATE(prix, prod,quantite,numero);
	}
	@PUT
	@Path("/updateLigneFacture")
	public void updateLigneFacture(@QueryParam("prix") float prix,@QueryParam("prod") String prod,@QueryParam("quantite") int quantite,@QueryParam("numero") int numero)
	{
		ligneFactureDAO.UPDATE(prix,prod,quantite,numero);

	}
	@DELETE
	@Path("/deleteLigneFacture")
	public void deleteLigneFacture(@QueryParam("numero") String numero)
	{
		ligneFactureDAO.DELETE(numero);
	}
}


