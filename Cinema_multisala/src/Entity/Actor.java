package Entity;

import java.util.Date;

public class Actor {
	private Integer idactor;
	private String name;
	private String country;
	private Date dateofbirth;
	public Integer getIdactor() {
		return idactor;
	}
	public void setIdactor(Integer idactor) {
		this.idactor = idactor;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public Date getDateofbirth() {
		return dateofbirth;
	}
	public void setDateofbirth(Date dateofbirth) {
		this.dateofbirth = dateofbirth;
	}
	public Actor(Integer idactor, String name, String country, Date dateofbirth) {
		super();
		this.idactor = idactor;
		this.name = name;
		this.country = country;
		this.dateofbirth = dateofbirth;
	}
	@Override
	public String toString() {
		return name;
	}
	
}
