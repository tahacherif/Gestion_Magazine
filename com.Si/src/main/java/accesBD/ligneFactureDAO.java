package accesBD;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import Model.LigneFacture;

public class ligneFactureDAO {


	public static void CREATE(float prix, String  prod, int quantite , int numero) {
		try{

			String query = "INSERT INTO Client (prix, prod,quantite,numero) VALUES (?,?,?,?)";
			PreparedStatement Stmt = SConnection.getInstance().prepareStatement(query);
			Stmt.setFloat (1, prix);
			Stmt.setString (2,prod);
			Stmt.setInt (3, quantite);
			Stmt.setInt (4, numero);



			Stmt.execute();

			SConnection.close();

			System.out.println("LigneFacture numero  "+ numero + " est ajoute avec succees!" );




		}
		catch(SQLException e) {System.out.println(e.getMessage());}
	}

	public static LigneFacture findByNumero(int numero) { //READ
		String rq="select * from LigneFacture where numero=?";
		LigneFacture lf= null;
		Connection cnx= SConnection.getInstance();
		PreparedStatement st;
		try {
			st=cnx.prepareStatement(rq);
			st.setInt(1, numero);
			ResultSet res= st.executeQuery();
			if(res.next())
				lf = new LigneFacture(res.getFloat(1),res.getString(2),res.getInt(3),res.getInt(4));		
			st.close();
		} catch (SQLException e) {
			System.out.println("La requete1 n'a pas pu etre executee ");
		}
		return lf;
	}

	public static void UPDATE(float prix, String  prod,int quantite , int numero) {
		int n=0;
		String rq1="update LigneFacture set quantite= ? where numero=?";
		Connection cnx= SConnection.getInstance();
		PreparedStatement st;
		try {

			st=cnx.prepareStatement(rq1);
			st.setFloat(1, quantite);
			st.setInt(2, numero);
			n= st.executeUpdate();
			st.close();
			if(n==1) {
				System.out.println("Mise a jour du LigneFacture avec succes ");
			}
		} catch (SQLException e) {
			System.out.println("Mise a jour du LigneFacture a echoue ");
		}
		if(n==0)
		{
			try {
				String query = "INSERT INTO Client (prix, prod,quantite,numero) VALUES (?,?,?,?)";
				PreparedStatement Stmt = SConnection.getInstance().prepareStatement(query);
				Stmt.setFloat (1, prix);
				Stmt.setString (2,prod);
				Stmt.setInt (3, quantite);
				Stmt.setInt (4, numero);



				Stmt.execute();

				SConnection.close();

				System.out.println("LigneFacture numero  "+ numero + " est ajoute avec succees!" );

			}
			catch (SQLException e) {
				System.out.println("La requete1 n'a pas pu etre executee ");
			}
		}
	}

	public static void DELETE(String num) {
		int n=0;
		String rq="Delete from LigneFacture where numero=?";
		Connection cnx= SConnection.getInstance();
		PreparedStatement st;
		try {
			st=cnx.prepareStatement(rq);
			st.setString(1, num);
			n= st.executeUpdate();
			if(n==1)
				System.out.println("Le LigneFacture a ete supprimer avec succes ");
			else //n=0
				System.out.println("Aucun LigneFacture n'a ete archive  ");
			st.close();
		}catch(SQLException e) {
			System.out.println("La requete delete n'a pas pu etre executee");
		}
	}

}
