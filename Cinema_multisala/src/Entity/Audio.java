package Entity;

public class Audio {
	private Integer idsound;
	private Integer year;
	private String description;
	public Integer getIdsound() {
		return idsound;
	}
	public void setIdsound(Integer idsound) {
		this.idsound = idsound;
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
	public Audio(Integer idsound, Integer year, String description) {
		super();
		this.idsound = idsound;
		this.year = year;
		this.description = description;
	}
	public Audio() {}
	
	@Override
	public String toString() {
		return description;
	}
	
}
