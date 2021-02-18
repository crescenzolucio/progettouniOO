package Entity;

import java.sql.Timestamp;

public class Projection {
	private Integer idpj;
	private Timestamp startpj;
	private Timestamp endpj;
	private Integer price;
	private Integer idfilm;
	private String filmdescription;
	private Integer idsala;
	private String roomdescription;
	
	public String getFilmdescription() {
		return filmdescription;
	}
	public void setFilmdescription(String filmdescription) {
		this.filmdescription = filmdescription;
	}
	public String getRoomdescription() {
		return roomdescription;
	}
	public void setRoomdescription(String roomdescription) {
		this.roomdescription = roomdescription;
	}
	public Integer getIdpj() {
		return idpj;
	}
	public void setIdpj(Integer idpj) {
		this.idpj = idpj;
	}
	public Timestamp getStartpj() {
		return startpj;
	}
	public void setStartpj(Timestamp startpj) {
		this.startpj = startpj;
	}
	public Timestamp getEndpj() {
		return endpj;
	}
	public void setEndpj(Timestamp endpj) {
		this.endpj = endpj;
	}
	public Integer getPrice() {
		return price;
	}
	public void setPrice(Integer price) {
		this.price = price;
	}
	public Integer getIdfilm() {
		return idfilm;
	}
	public void setIdfilm(Integer idfilm) {
		this.idfilm = idfilm;
	}
	public Integer getIdsala() {
		return idsala;
	}
	public void setIdsala(Integer idsala) {
		this.idsala = idsala;
	}
	public Projection() {}
	public Projection(Integer idpj, Timestamp startpj, Timestamp endpj, Integer price, Integer idfilm, Integer idsala) {
		super();
		this.idpj = idpj;
		this.startpj = startpj;
		this.endpj = endpj;
		this.price = price;
		this.idfilm = idfilm;
		this.idsala = idsala;
	}
}
