package accesBD;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collection;

import Model.Client;
import Model.Facture;
import Model.LigneFacture;

public class FactureDAO {
	
	public static void CREATE(Facture f) {
		try{

			String query = "INSERT INTO Facture (numero,codeClient,dateFacture) VALUES (?,?,?)";
			PreparedStatement Stmt = SConnection.getInstance().prepareStatement(query);
			Stmt.setString(1,f.getNumero());
			Stmt.setString(2,f.getCodeClient());
			Stmt.setDate(3,f.getDateFacture());
			Stmt.execute();

			SConnection.close();

			System.out.println("Facture numero "+ f.getNumero() + " est ajoute avec succees!" );




		}
		catch(SQLException e) {System.out.println(e.getMessage());}
	}

	public static Facture findByNum(String num) { //READ
		String rq="select * from Facture where numero=?";
		Facture c= null;
		Connection cnx= SConnection.getInstance();
		PreparedStatement st;
		try {
			st=cnx.prepareStatement(rq);
			st.setString(1, num);
			ResultSet res= st.executeQuery();
			if(res.next())
				c=new Facture(res.getString(1),res.getString(2),res.getDate(3));
			st.close();
		} catch (SQLException e) {
			System.out.println("La requete1 n'a pas pu etre executee ");
		}
		return c;
	}

	public static void UPDATE(String num,String codeClient) {
		int n=0;
		String rq1="update Facture set codeClient= ? where numero=?";
		Connection cnx= SConnection.getInstance();
		PreparedStatement st;
		try {

			st=cnx.prepareStatement(rq1);
			st.setObject(1,codeClient);
			st.setString(2, num  );
			n= st.executeUpdate();
			st.close();
			if(n==1) {
				System.out.println("Mise a jour du Facture avec succes ");
			}
		} catch (SQLException e) {
			System.out.println("Mise � jour du Facture a echoue ");
		}
		}
	

	public static void DELETE(String c) {
		int n=0;
		String rq="Delete from Facture where code=?";
		Connection cnx= SConnection.getInstance();
		PreparedStatement st;
		try {
			st=cnx.prepareStatement(rq);
			st.setString(1, c);
			n= st.executeUpdate();
			if(n==1)
				System.out.println("Le Facture a ete supprimer avec succes ");
			else //n=0
				System.out.println("Aucun Facture n'a ete archive  ");
			st.close();
		}catch(SQLException e) {
			System.out.println("La requete delete n'a pas pu etre executee");
		}

	}
}
