package accesBD;

import java.sql.*;

import Model.*;

public class ProduitDAO {	

	public ProduitDAO() {
		super();
	}



	public static Produit findbyId(String referance) {

		String rq="select * from Produit where referance=?";
		Produit p= null;
		Connection cnx= SConnection.getInstance();
		PreparedStatement st;
		try {
			st=cnx.prepareStatement(rq);
			st.setString(1,referance);
			ResultSet res= st.executeQuery();
			if(res.next())
				p=new Produit(res.getString(1),res.getFloat(2), res.getString(3),res.getBoolean(4));
			st.close();
		} catch (SQLException e) {
			System.out.println("La requete1 n'a pas pu etre executee ");
		}
		return p;
	}


	public static void CREATE(Produit p) {
		try{
			//	String rset = "SELECT referance  FROM Produit WHERE referance ="+p.getReferance();

			String query = "INSERT INTO Produit (libelle,prix,referance,etat) VALUES (?, ?,?, ?)";
			PreparedStatement Stmt = SConnection.getInstance().prepareStatement(query);
			Stmt.setString (1, p.getLibelle());
			Stmt.setFloat (2,p.getPrix());
			Stmt.setString(3, p.getReferance());
			Stmt.setBoolean(4, p.isEtat());

			Stmt.execute();

			SConnection.close();

			System.out.println("Prduit "+ p.getLibelle() + " est ajoute avec succees!" );




		}
		catch(SQLException e) {System.out.println(e.getMessage());}
	}

	public static void UPDATE(Produit p, boolean etat) {
		int n=0;
		String rq1="update Produit set etat= ? where referance=?";
		Connection cnx= SConnection.getInstance();
		PreparedStatement st;
		try {

			st=cnx.prepareStatement(rq1);
			st.setBoolean(1,p.isEtat());
			st.setString(2,p.getReferance());
			n= st.executeUpdate();
			st.close();
			if(n==1) {
				System.out.println("Mise a jour du Produit avec succes ");
			}
		} catch (SQLException e) {
			System.out.println("Mise � jour du Produit a echoue ");
		}
		if(n==0)
		{try {

			String query = "INSERT INTO Produit (libelle,prix,referance,etat) VALUES (?, ?,?, ?)";
			PreparedStatement Stmt = SConnection.getInstance().prepareStatement(query);
			Stmt.setString (1, p.getLibelle());
			Stmt.setFloat (2,p.getPrix());
			Stmt.setString(3, p.getReferance());
			Stmt.setBoolean(4, p.isEtat());

			Stmt.execute();

			SConnection.close();

			System.out.println("Prduit "+ p.getLibelle() + " est ajoute avec succees!" );




		}
		catch(SQLException e) {System.out.println(e.getMessage());}
		}
	}




	public static void DELETE (String referance) {
		int n=0;
		String rq="Delete from Prduit where referance=?";
		Connection cnx= SConnection.getInstance();
		PreparedStatement st;
		try {
			st=cnx.prepareStatement(rq);
			st.setString(1, referance);
			n= st.executeUpdate();
			if(n==1)
				System.out.println("Le Prduit a ete supprimer avec succes ");
			else //n=0
				System.out.println("Aucun Prduit n'a ete archive  ");
			st.close();
		}catch(SQLException e) {
			System.out.println("La requete delete n'a pas pu etre executee");
		}
	}
}
