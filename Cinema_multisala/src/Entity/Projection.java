package Entity;

import java.sql.Timestamp;

public class Projection {
	private Timestamp inizioproiezione;
	private Timestamp fineproiezione;
	private Integer prezzo;
	private Integer idfilm;
	private Integer idsala;
	public Timestamp getInizioproiezione() {
		return inizioproiezione;
	}
	public void setInizioproiezione(Timestamp inizioproiezione) {
		this.inizioproiezione = inizioproiezione;
	}
	public Timestamp getFineproiezione() {
		return fineproiezione;
	}
	public void setFineproiezione(Timestamp fineproiezione) {
		this.fineproiezione = fineproiezione;
	}
	public Integer getPrezzo() {
		return prezzo;
	}
	public void setPrezzo(Integer prezzo) {
		this.prezzo = prezzo;
	}
	public Integer getIdfilm() {
		return idfilm;
	}
	public void setIdfilm(Integer idfilm) {
		this.idfilm = idfilm;
	}
	public Projection(Timestamp inizioproiezione, Timestamp fineproiezione, Integer prezzo, Integer idfilm,
			Integer idsala) {
		super();
		this.inizioproiezione = inizioproiezione;
		this.fineproiezione = fineproiezione;
		this.prezzo = prezzo;
		this.idfilm = idfilm;
		this.idsala = idsala;
	}
	public Projection() {
		// TODO Auto-generated constructor stub
	}
	public Integer getIdsala() {
		return idsala;
	}
	public void setIdsala(Integer idsala) {
		this.idsala = idsala;
	}
}
