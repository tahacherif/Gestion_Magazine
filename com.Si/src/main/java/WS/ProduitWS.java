package WS;


import Model.Produit;
import accesBD.ProduitDAO;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;


@Path("produit")
public class ProduitWS {
	@GET
	@Path("/{login}")
	@Produces("application/xml")
	public Produit findbyId(@PathParam("num") String num)
	{
		return ProduitDAO.findbyId(num);
	}
	
	@POST
	@Path("/addProduit")
	public void addProduit(@QueryParam("libelle") String libelle,@QueryParam("prix") float prix,@QueryParam("referance") String referance,@QueryParam("etat") boolean etat)
	{
		ProduitDAO.CREATE(new Produit(libelle,prix,referance,etat));
	}
	@PUT
	@Path("/updateProduit")
	public void updateProduit(@QueryParam("Produit")Produit produit,@QueryParam("etat") boolean etat)
	{
		ProduitDAO.UPDATE(produit,etat);
	
	}
	@DELETE
	@Path("/deleteProduit")
	public void deleteProduit(@QueryParam("numero") String referance)
	{
		ProduitDAO.DELETE(referance);
	}
}
