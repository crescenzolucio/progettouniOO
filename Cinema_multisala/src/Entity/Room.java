package Entity;

public class Room {
	private Integer idsala;
	private String descrizione;
	private Integer posti;
	private Integer techaudio;
	private Integer techproj;
	public Integer getIdsala() {
		return idsala;
	}
	public void setIdsala(Integer idsala) {
		this.idsala = idsala;
	}
	public String getDescrizione() {
		return descrizione;
	}
	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}
	public Integer getPosti() {
		return posti;
	}
	public void setPosti(Integer posti) {
		this.posti = posti;
	}
	public Integer getTechaudio() {
		return techaudio;
	}
	public void setTechaudio(Integer techaudio) {
		this.techaudio = techaudio;
	}
	public Integer getTechproj() {
		return techproj;
	}
	public void setTechproj(Integer techproj) {
		this.techproj = techproj;
	}
	public Room(Integer idsala,String descrizione, Integer posti, Integer techaudio, Integer techproj) {
		super();
		this.descrizione = descrizione;
		this.posti = posti;
		this.techaudio = techaudio;
		this.techproj = techproj;
	}
	public Room() {}
	@Override
	public String toString() {
		return descrizione;
	}
}
