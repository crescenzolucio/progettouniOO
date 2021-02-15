package Entity;

public class Technology {
	private Integer idtecnology;
	private Integer year;
	private String description;
	public Integer getIdtecnology() {
		return idtecnology;
	}
	public void setIdtecnology(Integer idtecnology) {
		this.idtecnology = idtecnology;
	}
	public Integer getYear() {
		return year;
	}
	public void setYear(Integer year) {
		this.year = year;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Technology(Integer idtecnology, Integer year, String description) {
		super();
		this.idtecnology = idtecnology;
		this.year = year;
		this.description = description;
	}
	public Technology() {}
	
	@Override
	public String toString() {
		return description;
	}
	
}
