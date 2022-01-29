package accesBD;
import java.sql.*;
public class SConnection {

	private static String url = "jdbc:mysql://localhost:3306/gestion_magazin";
	private static String utilisateur= "root";
	private static String motPasse="";
	private static Connection cnx;



	public static Connection getInstance()
	{
		try {
			if(cnx==null || cnx.isClosed()) {

				Class.forName("com.mysql.jdbc.Driver");

				cnx=DriverManager.getConnection(url,utilisateur,motPasse);
				System.out.println("Connexion a la base de donnees ");
			}
		}
		catch (ClassNotFoundException e) { 
			System.out.println("Classe Driver introuvable");
		}
		catch (SQLException e) {
			System.out.println("L'etablissement de la connexion a echoue.");
		}
		return cnx;

	}
	public static void close() {
		try {
			if(!cnx.isClosed())
				cnx.close();
		} catch (SQLException e) {

			e.printStackTrace();
		}

	}

}
