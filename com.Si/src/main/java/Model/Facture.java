package Model;

import java.sql.Date;
import java.time.LocalDate;
import java.util.Collection;

public class Facture {
	private String numero;
	private Date dateFacture;
	private Collection<LigneFacture> lignes;
	

	public Facture(String numero ,String codeClient, Date localDate) {
		this.codeClient = codeClient;
		this.dateFacture = localDate;
		
		this.numero = numero;
		lignes = null;
	}

	public String getCodeClient() {
		return codeClient;
	}
	public void setCodeClient(String codeClient) {
		this.codeClient = codeClient;
	}
	private String codeClient;

	public Date getDateFacture() {
		return dateFacture;
	}
	public void setDateFacture(Date dateFacture) {
		this.dateFacture = dateFacture;
	}
	public Collection<LigneFacture> getLignes() {
		return lignes;
	}
	public void setLignes(Collection<LigneFacture> lignes) {
		this.lignes = lignes;
	}
	public String getNumero() {
		return numero;
	}
	public void setNumero(String numero) {
		this.numero = numero;
	}
	
	
	@Override
	public String toString() {
		return "Facture [client=" + codeClient + ", dateFacture=" + dateFacture + ", lignes=" + lignes + ", numero="
				+ numero + "]";
	}
	
}
