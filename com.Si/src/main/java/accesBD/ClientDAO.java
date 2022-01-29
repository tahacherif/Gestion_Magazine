package accesBD;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import Model.Client;


public class ClientDAO {



	public ClientDAO() {
		super();
	}

	public static List<Client> findAll () throws SQLException{

		List<Client> c2 = new ArrayList<>() ;
		String requete = "select code,nom from client";

		PreparedStatement stmt = SConnection.getInstance().prepareStatement(requete);
		ResultSet res= stmt.executeQuery();
		while(res.next()){
			
			Client c = new Client(res.getString(1),res.getString(2));

			c2.add(c);
		}
		
		return c2;
	}

	public static void CREATE(Client c) {
		try{

			String query = "INSERT INTO Client (code, nom) VALUES (?,?)";
			PreparedStatement Stmt = SConnection.getInstance().prepareStatement(query);
			Stmt.setString (1, c.getCode());
			Stmt.setString (2,c.getNom());
			Stmt.execute();

			SConnection.close();

			System.out.println("Client "+ c.getNom() + " est ajoute avec succees!" );

		}
		catch(SQLException e) {System.out.println(e.getMessage());}
	}

	public static Client findById(String id) {
		String rq="select * from client where code=?";
		Client c= null;
		Connection cnx= SConnection.getInstance();
		PreparedStatement st;
		try {
			st=cnx.prepareStatement(rq);
			st.setString(1, id);
			ResultSet res= st.executeQuery();
			if(res.next())
				c=new Client(res.getString(1), res.getString(2));
			System.out.println("req bien executee");
			st.close();
		} catch (SQLException e) {
			System.out.println("La requete1 n'a pas pu etre executee ");
		}
		return c;
	}

	public static void UPDATE(String code,String nom) {
		int n=0;
		String rq1="update client set nom= ? where code=?";
		Connection cnx= SConnection.getInstance();
		PreparedStatement st;
		try {

			st=cnx.prepareStatement(rq1);
			st.setString(1,nom);
			st.setString(2, code);
			n= st.executeUpdate();
			st.close();
			if(n==1) {
				System.out.println("Mise a jour du client avec succes ");
			}
		} catch (SQLException e) {
			System.out.println("Mise � jour du client a echoue ");
		}
		if(n==0)
		{try {
			String rq2="insert into client(code, nom) values (?,?)";
			st=cnx.prepareStatement(rq2);			
			st.setString(1,code);
			st.setString(2,nom );	
			n= st.executeUpdate();
			System.out.println("Ajout du client avec succes ");
			st.close();
		} catch (SQLException e) {
			System.out.println("L'ajout du client a echoue ");
		}
		}
	}

	public static void DELETE(String c) {
		int n=0;
		String rq="Delete from client where code=?";
		Connection cnx= SConnection.getInstance();
		PreparedStatement st;
		try {
			st=cnx.prepareStatement(rq);
			st.setString(1, c);
			n= st.executeUpdate();
			if(n==1)
				System.out.println("Le client a ete supprimer avec succes ");
			else //n=0
				System.out.println("Aucun client n'a ete archive  ");
			st.close();
		}catch(SQLException e) {
			System.out.println("La requete delete n'a pas pu etre executee");
		}
	}

}